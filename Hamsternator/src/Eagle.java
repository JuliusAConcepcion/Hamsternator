import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;
import java.net.URL;

public class Eagle extends Sprite{
	
	public Eagle() {
		
		super("/pictures/eagleNew.gif");
		this.setScaleX(1);
		this.setScaleY(1);
		setX(0);
		setY(0);
	}
	
	public Eagle(int a, int b) {
		
		super("/pictures/eagleNew.gif");
		this.setScaleX(.15);
		this.setScaleY(.15);
		setX(a);
		setY(b);
	}

	
	
	
	
}
