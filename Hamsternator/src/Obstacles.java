import java.awt.Graphics;
import java.awt.image.ImageObserver;

public class Obstacles extends Sprite{
	
	private String CarP = "pictures/CarP.gif";
	private String CarB = "pictures/CarB.gif";
	private String Truck = "pictures/CandE.gif";
	private int type;
	private int lane;
	
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
		
		this.setScaleX(3);
		this.setScaleY(3);
		this.setX(300);
		this.setY(300);
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
			this.setScaleX(1.5);
			this.setScaleY(1.5);
		}
		
		this.setScaleX(4);
		this.setScaleY(4);
		this.setX(x);
		this.setY(y);
		reset();
	}
	
	public void setRandomCar() {
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
		//makes the cars stay on lane
		this.setRandomCar();
		this.setX(2100);
		lane = ((int)(Math.random()*4)) + 1;
		if (lane <= 1) {
			this.setY(700);
		} else if(lane == 2) {
			this.setY(800);
		}else if(lane == 3) {
			this.setY(900);
		}else {
			this.setY(1000);
		}
		
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
}
