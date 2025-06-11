import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.net.URL;

public class EndScreen{
	private Image forward, backward, left, right; 	
	private AffineTransform tx;
	
	int dir = 0; 					//0-forward, 1-backward, 2-left, 3-right
	int width, height;
	int x, y;						//position of the object
	int vx, vy;						//movement variables
	double scaleWidth = 10.0;		//change to scale image
	double scaleHeight = 10.0; 		//change to scale image

	public EndScreen() {
		forward = getImage("/pictures/"+"GameOver Eagle Screen.png"); //load the image for Tree
		

		//alter these
		width = 600;
		height = 600;
		x = 0;
		y = 0;
		vx = 0;
		vy = 0;
		
		tx = AffineTransform.getTranslateInstance(0, 0);
		
		init(x, y); 				//initialize the location of the image
									//use your variables
		
	}
	public  EndScreen(int x, int y) {
		
		this(); //call default constructor
		
		//set the actual values for x,y
		this.x = x;
		this.y = y;
		
		//force refresh image location
		this.init(x,  y);
		
	}

	public void paint(Graphics g) {
		//these are the 2 lines of code needed draw an image on the screen
		Graphics2D g2 = (Graphics2D) g;
		
		x+=vx;
		y+=vy;	
		
		init(x,y);
		
		switch(dir) {
		case 0:
			g2.drawImage(forward, tx, null);
			break;
		case 1:
			g2.drawImage(backward, tx, null);

			break;
		case 2:
			g2.drawImage(left, tx, null);

			break;
		case 3:
			g2.drawImage(right, tx, null);
			break;
		}

	}
	
	public void init(double a, double b) {
		tx.setToTranslation(a, b);
		tx.scale(scaleWidth, scaleHeight);
	}
	

	private Image getImage(String path) {
		Image tempImage = null;
		try {
			URL imageURL = EndScreen.class.getResource(path);
			tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempImage;
	}
	public Image getForward() {
		return forward;
	}
	public void setForward(Image forward) {
		this.forward = forward;
	}
	public Image getBackward() {
		return backward;
	}
	public void setBackward(Image backward) {
		this.backward = backward;
	}
	public Image getLeft() {
		return left;
	}
	public void setLeft(Image left) {
		this.left = left;
	}
	public Image getRight() {
		return right;
	}
	public void setRight(Image right) {
		this.right = right;
	}
	public AffineTransform getTx() {
		return tx;
	}
	public void setTx(AffineTransform tx) {
		this.tx = tx;
	}
	public int getDir() {
		return dir;
	}
	public void setDir(int dir) {
		this.dir = dir;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getVx() {
		return vx;
	}
	public void setVx(int vx) {
		this.vx = vx;
	}
	public int getVy() {
		return vy;
	}
	public void setVy(int vy) {
		this.vy = vy;
	}
	public double getScaleWidth() {
		return scaleWidth;
	}
	public void setScaleWidth(double scaleWidth) {
		this.scaleWidth = scaleWidth;
	}
	public double getScaleHeight() {
		return scaleHeight;
	}
	public void setScaleHeight(double scaleHeight) {
		this.scaleHeight = scaleHeight;
	}

}
