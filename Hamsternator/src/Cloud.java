import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;
import java.net.URL;

public class Cloud extends Sprite{
	
	private double x;
	private double y;
	private double vx = (double)(Math.random()*0.6) + 0.1;
	private int cloudSize = (int)(Math.random()*3)+3;
	
	public Cloud() {
		super("pictures/Cloud1.png");
		x = 0;
		y = 0;
		
	}
	
	public Cloud(int a, int b) {
		super("pictures/Cloud1.png");
		x = a;
		y = b;
		
	}
	
	public void setRandomCloud() {
		this.changePicture("pictures/Cloud" + ((int)(Math.random()*2) + 1) + ".png");
	}
	
	public void change1() {
		this.changePicture("pictures/Cloud1.png");
	}
	public void change2() {
		this.changePicture("pictures/Cloud2.png");

	}
	public void change3() {
		this.changePicture("pictures/Cloud3.png");
	}
	
	public void paint(Graphics g) {
		x+=vx;
		
		if (x > 2000) {
			x = (int)(Math.random()*-50) - 10;
		}
		
		init(x, y);
		setScale(cloudSize, cloudSize);
		super.paint(g);
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getVx() {
		return vx;
	}

	public void setVx(double vx) {
		this.vx = vx;
	}
	
	
	
}
