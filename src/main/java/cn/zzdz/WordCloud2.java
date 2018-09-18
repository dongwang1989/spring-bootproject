package cn.zzdz;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;

import javax.swing.JFrame;

import org.rosuda.REngine.REXP;
import org.rosuda.REngine.Rserve.RConnection;

public class WordCloud2 extends JFrame {
	private static final long serialVersionUID = 1L;
	static Image img;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		WordCloud2 wc = new WordCloud2();

		wc.getRobj();// 获得R的内容对象
	}

	private void getRobj() throws Exception {
		RConnection c = Rservel.getRConnection();
		c.setStringEncoding("utf8");
		c.eval("dd()");
		// REXP Rversion = c.eval("dd");
		// System.out.println(Rversion.asString());
		System.out.println("\n--------------画图演示----------------");

	}

	public void PlotDemo(REXP xp, JFrame f) throws Exception {
		img = Toolkit.getDefaultToolkit().createImage(xp.asBytes());
		MediaTracker mediaTracker = new MediaTracker(this);
		mediaTracker.addImage(img, 0);
		mediaTracker.waitForID(0);
		f.setTitle("Test image");
		f.setSize(img.getWidth(null), img.getHeight(null));
		f.setDefaultCloseOperation(EXIT_ON_CLOSE);
		f.setVisible(true);
	}

	public void paint(Graphics g) {
		g.drawImage(img, 0, 0, null);
	}
}
