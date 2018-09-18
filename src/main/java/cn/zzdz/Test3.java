package cn.zzdz;

import org.rosuda.JRI.Rengine;

public class Test3 {
	public static void main(String[] args) {
		Test3 test3 = new Test3();
		test3.method3();
	}

	@SuppressWarnings("deprecation")
	public void method3() {
		// R文件全路径
		String filePath = "D:\\1.R";

		// 初始化R解析类
		Rengine engine = new Rengine(null, false, null);
		System.out.println("Rengine created, waiting for R");

		// 等待解析类初始化完毕
		if (!engine.waitForR()) {
			System.out.println("Cannot load R");
			return;
		}
		// 将文件全路径复制给R中的一个变量
		engine.assign("fileName", filePath);

		// try {
		// engine.eval("source(fileName)");
		// }
		// catch{
		//
		// }
		System.err.println("R文件执行完毕");
		engine.stop();
	}
}
