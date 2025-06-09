import java.awt.geom.AffineTransform;

public class HamHealth extends Sprite{
	
	private AffineTransform tx;
	static int health = 3;
	
	public HamHealth() {
		
		
		super("/pictures/"+"HealthBar " + health + ".png");
		
		this.setX(0);
		this.setY(0);
		this.setScaleX(5);
		this.setScaleY(5);
		update();
		
	}
	
	public HamHealth(int a, int b) {
		
		
		super("/pictures/"+"HealthBar " + health + ".png");
		
		this.setX(a);
		this.setY(b);
		this.setScaleX(5);
		this.setScaleY(5);
		update();
		
	}
	
	
	public void hamDmg(){
		health--;
		update();
	}
	
	public void hamHeal(){
		health++;
		update();
	}
	
	public void update() {
		changePicture("/pictures/"+"HealthBar " + health + ".png");
	}


	public int getHamHealth() {
		return health;
	}


	public void setHamHealth(int health) {
		HamHealth.health = health;
	}
	
	

}
