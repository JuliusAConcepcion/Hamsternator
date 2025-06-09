import java.awt.Graphics;
import java.awt.image.ImageObserver;

public class PowerUp extends Sprite{
	
	private String health = "pictures/health-pu-pixilart.png";
	private String shield = "pictures/shield-pu-pixilart.png";
	private String ammo = "pictures/ss-shell-pixilart.png";
	private int type;
	private int lane;
	
	private double vx = -10;
	
	public PowerUp(int a) {
		super("");
		
		type = a;
		
		
		if (a <= 1) {
			this.changePicture(health);
		} else if(a == 2) {
			this.changePicture(shield);
		} else {
			this.changePicture(ammo);
		}
		
		this.setScaleX(2);
		this.setScaleY(2);
		this.setX(500);
		this.setY(500);
	}
	
	public PowerUp(int a, int x, int y) {
		super("");
		
		type = a;
		
		if (a <= 1) {
			this.changePicture(health);
		} else if(a == 2) {
			this.changePicture(shield);
		} else {
			this.changePicture(ammo);
		}
		
		this.setScaleX(3);
		this.setScaleY(3);
		this.setX(x);
		this.setY(y);
	}
	
	public void setRandomPower() {
		int temp = (int)(Math.random()*3) + 1;
		
		type = temp;
		
		if (temp <= 1) {
			this.changePicture(health);
		} else if(temp == 2) {
			this.changePicture(shield);
		} else {
			this.changePicture(ammo);
		}
	}
	
	public int getLane() {
		return lane;
	}

	public void setLane(int lane) {
		this.lane = lane;
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

	public void reset() {
		//makes the powerUps stay on lane
		this.setRandomPower();
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
