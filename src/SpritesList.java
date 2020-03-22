import java.awt.Graphics;
import java.util.ArrayList;

public class SpritesList {
	
	ArrayList<Sprites> objects = new ArrayList<Sprites>();
	private boolean up;
	private boolean down;
	private boolean left;
	private boolean right;
	
	


	public void updateState() {
		for (int i = 0; i < objects.size(); i++) {
			objects.get(i).updateState();
		}
	}
	
	public void updateImage(Graphics g) {
		for (int i = 0; i < objects.size(); i++) {
			objects.get(i).updateImage(g);
		}
		
	}
	
	public void add(Sprites s) {
		objects.add(s);
	}
	
	public void remove(Sprites s) {
		objects.remove(s);
	}
	


}
