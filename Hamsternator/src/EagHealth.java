import java.awt.geom.AffineTransform;

public class EagHealth extends Sprite{
	
	private AffineTransform tx;
	static int health = 9;
	int x;
	int y; 
	
	public EagHealth() {
		
		
		super("/pictures/"+"Eagle health " + health + ".png");
		
		this.x = 0;
		this.y = -500;
		tx = AffineTransform.getTranslateInstance(0, 0);
		init(x,y);
		setScale(0.8,0.8);
		update();
		
	}
	
	
	public void eagDmg(){
		health--;
		update();
	}
	
	public void update() {
		init(x, y);
		changePicture("/pictures/"+"Eagle health " + health + ".png");
	}


	public static int getHealth() {
		return health;
	}


	public static void setHealth(int health) {
		EagHealth.health = health;
	}
	
	

}
