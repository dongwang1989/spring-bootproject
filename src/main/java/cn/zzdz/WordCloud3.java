package cn.zzdz;

import org.rosuda.REngine.REXPMismatchException;
import org.rosuda.REngine.Rserve.RConnection;
import org.rosuda.REngine.Rserve.RserveException;

public class WordCloud3 {
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		WordCloud3 j = new WordCloud3();
		j.da();
	}

	public void da() throws RserveException, REXPMismatchException {
		RConnection rConnection = new RConnection();// Rservel.getRConnection();
		rConnection.setStringEncoding("utf8");
		// REXP rexp = rConnection.eval("R.version.string");// 测试连接，方法是eval(String arg0)
		// System.out.println(rexp.asString());// R version 3.1.2 (2014-10-31)
		rConnection.eval("source('D:/f.R')");
		int sum = rConnection.eval("dd()").asInteger();
		if (sum == 123) {
			System.out.println("yes");
		} else {
			System.out.println("no");
		}
		// rConnection.eval("dd('123')");
	}
}
