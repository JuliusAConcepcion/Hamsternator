
public class Road extends Sprite{
	
	int x;
	int y; 
	
	public Road() {
		
		
		super("/pictures/"+"Road.gif");
		
		this.x = 0;
		this.y = 0;
		
	}
	
	public Road(int a, int b) {
		
		super("/pictures/"+"Road.gif");
		
		x=a;
		y=b;
		init(x,y);
	}
	
	
	
	
	

}
