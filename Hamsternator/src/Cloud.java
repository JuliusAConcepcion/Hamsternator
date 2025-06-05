import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;
import java.net.URL;

public class Cloud extends Sprite{

	private double vx = (double)(Math.random()*0.6) + 0.1;
	
	public Cloud() {
		super("pictures/Cloud1.png");
		this.setX(0);
		this.setY(0);
		int temp = (int)(Math.random()*5)+2;
		setScaleX(temp);
		setScaleY(temp);
	}
	
	public Cloud(int a, int b) {
		super("pictures/Cloud1.png");
		this.setX(a);
		this.setY(b);
		int temp = (int)(Math.random()*2)+5;
		setScaleX(temp);
		setScaleY(temp);
		
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
		setX(getX()+vx);
		
		if (getX() > 2000) {
			setX((int)(Math.random()*-50) - 10);
		}
		
		super.paint(g);
	}

	

	public double getVx() {
		return vx;
	}

	public void setVx(double vx) {
		this.vx = vx;
	}
	
	
	
}
