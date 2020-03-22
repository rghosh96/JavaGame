import java.awt.Rectangle;

public class WaterTile extends Tiles{

	public WaterTile(int id) {
		super(Images.water, id);
	}
	
	@Override
	public boolean canWalk() {
		return false;
	}
	
	public Rectangle bounds(int x, int y) {
		return new Rectangle(x, y, 64, 64);
	}

}
