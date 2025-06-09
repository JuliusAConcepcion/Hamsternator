import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;
import java.net.URL;

public class Hamster extends Sprite{
	
	private int lane;
	
	public Hamster() {
		
		
		super("/pictures/Hamsternator.gif");
		this.setScaleX(2);
		this.setScaleY(2);
		setX(0);
		setY(0);
	}
	
	public Hamster(int a, int b) {
		
		
		super("/pictures/Hamsternator.gif");
		this.setScaleX(2);
		this.setScaleY(2);
		setX(a);
		setY(b);
	}
	
	public int getLane() {
		return lane;
	}

	public void setLane(int lane) {
		this.lane = lane;
	}

	public void paint(Graphics g) {
		
		int y = (int)getY();
		
		if (y == 650) {
			lane = 1;
		} else if (y == 750) {
			lane = 2;
		} else if (y == 850) {
			lane = 3;
		} else if (y == 950) {
			lane = 4;
		}
		
		System.out.println(y);
		
		super.paint(g);
	}
	

	
	
	
}
