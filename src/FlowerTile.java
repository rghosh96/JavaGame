import java.awt.Rectangle;

public class FlowerTile extends Tiles{

	public FlowerTile(int id) {
		super(Images.flowers, id);
	}

	
	@Override
	public boolean canWalk() {
		return true;
	}
	
	public Rectangle bounds(int x, int y) {
		return new Rectangle(x, y, 128, 128);
	}
}
