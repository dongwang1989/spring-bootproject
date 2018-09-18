package cn.zzdz;

import org.rosuda.REngine.Rserve.RConnection;
import org.rosuda.REngine.Rserve.RserveException;

public class Rservel {
	private static String R_EXE_PATH = "D:\\Program Files\\R\\R-3.5.0\\bin\\Rscript.exe";
	private static String R_SCRIPT_PATH = "D:\\Rserve.R";

	public static RConnection getRConnection() {
		try {
			RConnection rConnection = new RConnection();
			return rConnection;
		} catch (RserveException e) {
			// TODO: handle exception
			System.out.println("正在启动Rserve服务......");
			try {
				Runtime rn = Runtime.getRuntime();
				/*
				 * 不建议写成直接写成rn.exec("R_EXE_PATH R_SCRIPT_PATH")，如果这样学的画前面定义的R_EXE_PATH，
				 * R_SCRIPT_PATH会提示 这两个变量没有用到 运行也许会出错，提示错误如下： java.io.IOException: Cannot run
				 * program "D:\Program": CreateProcess error=2, 系统找不到指定的文件。
				 */

				String[] commandArgs = { R_EXE_PATH, R_SCRIPT_PATH };// 说明：R_EXE_PATH
																		// 是Rscript.exe或者R.exe的路径，这两个都可以。R_SCRIPT_PATH是R脚本的路径。
				rn.exec(commandArgs);
				Thread.sleep(5000);
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
			return getRConnection();
		}
	}
}
