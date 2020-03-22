import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

public class Tiles {

	protected Image bg;
	protected int type;
	public static final int tileW = 64;
	public static final int tileH = 64;
	
	//one instance of world per game!!!
	public static Tiles[] map = new Tiles[256];
	public static Tiles grass = new GrassTile(0);	//all grass tiles identified by 0
	public static Tiles tree = new TreeTile(2);
	public static Tiles flowers = new FlowerTile(1);
	public static Tiles water = new WaterTile(3);



	public Tiles(Image tile, int id) {
		bg = tile;
		type = id;
		map[id] = this;
	}
	
	public boolean canWalk() {
		return true;
	}
	
	public void updateState() {
		
	}
	
	public void updateImage(Graphics g, int x, int y) {
		g.drawImage(bg, x, y, tileW, tileH, null);
	}
	
	public int getType() {
		return type;
	}
	
	public Rectangle bounds(int x, int y) {
		return new Rectangle(x, y, tileW, tileH);
	}

}
