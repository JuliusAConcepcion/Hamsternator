import java.awt.Graphics;

public class PowerUp extends Sprite{
	
	private String health = "pictures/health-pu-pixilart.png";
	private String shield = "pictures/shield-pu-pixilart.png";
	private String ammo = "pictures/ss-shell-pixilart.png";
	private int type;
	
	private int vx = -10;
	
	public PowerUp(int a) {
		super("");
		
		if (a <= 1) {
			this.changePicture(health);
			setType(1);
		} else if(a == 2) {
			this.changePicture(shield);
			setType(2);
		} else {
			this.changePicture(ammo);
			setType(3);
		}
		
		this.setScaleX(20);
		this.setScaleX(20);
		this.setX(500);
		this.setY(100);
	}
	
	public void setRandomPower() {
		int temp = (int)(Math.random()*2) + 1;
		
		if (temp == 1) {
			this.changePicture(health);
			setType(1);
		} else if(temp == 2) {
			this.changePicture(shield);
			setType(2);
		} else {
			this.changePicture(ammo);
			setType(3);
		}
	}
	
	public boolean isColliding(Hamster a) {//change later
		
		return false;
	}
	
	public void paint(Graphics g) {
		this.setX(getX()+vx);
		
		if (this.getX() < -50) {
			reset();
		}
		
		super.paint(g);
	}

	private void reset() {
		this.setRandomPower();
		this.setX(2000 + 200);
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
}
