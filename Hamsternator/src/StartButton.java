
public class StartButton extends Sprite{

	public StartButton() {
		
		super("/pictures/"+"Button.png");
		
		this.setX(0);
		this.setY(0);
		this.setScaleX(10);
		this.setScaleY(10);
		update();
		
	}
	public StartButton(int a, int b) {
		super("/pictures/"+"Button.png");
		
		this.setX(a);
		this.setY(b);
		this.setScaleX(10);
		this.setScaleY(10);
//		update();
	}
	public void update() {
		changePicture("/pictures/"+"Button Pressed.png");
		
	}
	
	
}
