import java.awt.Graphics;
import java.awt.image.ImageObserver;

public class Obstacles extends Sprite{
	
	private String CarP = "pictures/CarP.gif";
	private String CarB = "pictures/CarB.gif";
	private String Truck = "pictures/CandE.gif";
	private int type;
	
	private double vx = -10;
	
	public Obstacles(int a) {
		super("");
		
		setType(a); 
		
		if (a <= 1) {
			this.changePicture(CarP);
		} else if(a == 2) {
			this.changePicture(CarB);
		} else {
			this.changePicture(Truck);
		}
		
		this.setScaleX(2);
		this.setScaleY(2);
		this.setX(500);
		this.setY(500);
	}
	
	public Obstacles(int a, int x, int y) {
		super("");
		
		setType(a); 
		
		if (a <= 1) {
			this.changePicture(CarP);
		} else if(a == 2) {
			this.changePicture(CarB);
		} else {
			this.changePicture(Truck);
		}
		
		this.setScaleX(2);
		this.setScaleY(2);
		this.setX(x);
		this.setY(y);
	}
	
	public void setRandomPower() {
		int temp = (int)(Math.random()*3) + 1;
		
		setType(temp);
		
		if (temp <= 1) {
			this.changePicture(CarP);
		} else if(temp == 2) {
			this.changePicture(CarB);
			setType(2);
		} else {
			this.changePicture(Truck);
		}
	}
	
	public boolean isColliding(Hamster a) {//code later
		int px = (int) this.getX();
	    int py = (int) this.getY();
	    int pw = (int)(this.getWidth() * this.getScaleX());
	    int ph = (int)(this.getHeight() * this.getScaleY());

	    int hx = (int) a.getX();
	    int hy = (int) a.getY();
	    int hw = (int)(a.getWidth() * a.getScaleX());
	    int hh = (int)(a.getHeight() * a.getScaleY());

	    return (px < hx + hw &&
	            px + pw > hx &&
	            py < hy + hh &&
	            py + ph > hy);
	}
	
	public void paint(Graphics g) {
		
		this.setX(getX() + vx);
		
		if (this.getX() < -50) {
			reset();
		}
		
		super.paint(g);
		
//		System.out.println("type: " +getType());
//		System.out.println(getX() + " " + getY());
//		System.out.println(this.getWidth()*2);
	}

	private void reset() {
		this.setRandomPower();
		this.setX(2100);
		this.setY((int)(Math.random() * (900 - 730 + 1)) + 730);
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
}
