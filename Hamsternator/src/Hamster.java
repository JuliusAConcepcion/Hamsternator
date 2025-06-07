import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;
import java.net.URL;

public class Hamster extends Sprite{
	
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
	

	
	
	
}
