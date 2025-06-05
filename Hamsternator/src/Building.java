import java.awt.Graphics;

public class Building extends Sprite{
	
	private double vx = -0.3;
	
	public Building(int a, int b) {
		super("pictures/building1.png");
		
		this.setScaleX(15);
		this.setScaleY(15);
		
		this.setX(a);
		this.setY(b);
	}
	
	public void setRandomBuilding() {
		this.changePicture("pictures/building" + ((int)(Math.random()*2) + 1) + ".png");
	}

	public void paint(Graphics a) {
		this.setX(getX()+vx);
		if (this.getX() < -450) {
			this.setX(2050);
		}
		
		super.paint(a);
		
	}
	
}
