
public class EagHealth extends Sprite{
	
	
	static int health = 9;
	int x;
	int y; 
	
	public EagHealth() {
		
		
		super("/pictures/"+"Eagle health " + health + ".png");
		
		this.x = 0;
		this.y = 0;
		
		update();
	}
	
	
	public void eagDmg(){
		health--;
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
