import java.awt.geom.AffineTransform;

public class EagHealth extends Sprite{
	
	private AffineTransform tx;
	static int health = 9;
	
	public EagHealth() {
		
		
		super("/pictures/"+"Eagle health " + health + ".png");
		
		this.setX(0);
		this.setY(0);
		this.setScaleX(1.6);
		this.setScaleY(1.6);
		update();
		
	}
	
	public EagHealth(int a, int b) {
		
		
		super("/pictures/"+"Eagle health " + health + ".png");
		
		this.setX(a);
		this.setY(b);
		this.setScaleX(1.6);
		this.setScaleY(1.6);
		update();
		
	}
	
	
	public void eagDmg(){
		
		if (health != 0) {
			health--;
		}
		update();
	}
	
	public void update() {
		changePicture("/pictures/"+"Eagle health " + health + ".png");
	}


	public static int getHealth() {
		return health;
	}


	public static void setHealth(int health) {
		EagHealth.health = health;
	}
	
	

}
