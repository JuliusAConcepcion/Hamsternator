import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;
import java.net.URL;

public class Cloud extends Sprite{
	
	private int x;
	private int y;
	private int vx = 10;
	
	public Cloud() {
		super("pictures/Cloud1.png");
		x = 0;
		y = 0;
	}
	
	public void change1() {
		this.changePicture("pictures/Cloud1.png");
	}
	public void change2() {
		this.changePicture("pictures/Cloud2.png");

	}
	public void change3() {
		this.changePicture("pictures/cloud3.png");

	}
	
	public void update() {
		x =+ vx;
		init(x,y);
	}
	
	
	
}
