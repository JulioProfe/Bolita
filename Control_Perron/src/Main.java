import processing.core.PApplet;

public class Main extends PApplet{
	
	private Logica log;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PApplet.main("Main");
	}
	
	@Override
	public void settings() {
		// TODO Auto-generated method stub
		size(500, 500);
	}
	
	@Override
	public void setup() {
		// TODO Auto-generated method stub
		log = new Logica();
		background(255);
	}
	
	@Override
	public void draw() {
		// TODO Auto-generated method stub
		log.pintar(this);
	}
	
	@Override
	public void mouseClicked() {
// TODO Auto-generated method stub
		log.click(this);
	}
	
}