import java.awt.Rectangle;

public class GrassTile extends Tiles{

	public GrassTile(int id) {
		super(Images.grass, id);
	}
	
	@Override
	public boolean canWalk() {
		return true;
	}
	
	public Rectangle bounds(int x, int y) {
		return new Rectangle(x, y, 64, 64);
	}

}
