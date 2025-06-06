import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;
import java.awt.image.ImageObserver;
import java.net.URL;

public class Sprite {
	
	private Image img; 	
	private AffineTransform tx;
	private double x;
	private double y;
	private double scaleX = 0;
	private double scaleY = 0;

	public double getScaleX() {
		return scaleX;
	}
	
	

	public void setScaleX(double scaleX) {
		this.scaleX = scaleX;
	}

	public double getScaleY() {
		return scaleY;
	}

	public void setScaleY(double scaleY) {
		this.scaleY = scaleY;
	}

	public Sprite(String a) {
		setImg(getImage(a)); //load the image for Tree
		

		setTx(AffineTransform.getTranslateInstance(0, 0));
		init(0, 0); 				//initialize the location of the image
									//use your variables
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
	
//	public boolean colliding(Sprite other) {
//		
//	}

	public void changePicture(String newFileName) {
		setImg(getImage(newFileName));
	}
	
	public void paint(Graphics g) {
		//these are the 2 lines of code needed draw an image on the screen
		init(x,y);
		this.setScale(scaleX, scaleY);
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(getImg(), getTx(), null);

	}
	
	public void init(double a, double b) {
		x = a;
		y = b;
		getTx().setToTranslation(a, b);
	}
	
	public void setScale(double a, double b) {
		getTx().scale(a, b);
	}

	public Image getImage(String path) {
		Image tempImage = null;
		try {
			URL imageURL = Sprite.class.getResource(path);
			tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempImage;
	}

	public Image getImg() {
		return img;
	}

	public void setImg(Image img) {
		this.img = img;
	}

	public AffineTransform getTx() {
		return tx;
	}

	public void setTx(AffineTransform tx) {
		this.tx = tx;
	}
	
	public int getWidth() {
	    return img.getWidth(null);
	}

	public int getHeight() {
	    return img.getHeight(null);
	}
	
	
}
