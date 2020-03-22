import java.awt.Rectangle;

public class TreeTile extends Tiles{

	public TreeTile(int id) {
		super(Images.tree, id);
	}

	@Override
	public boolean canWalk() {
		return false;
	}
	
	public Rectangle bounds(int x, int y) {
		return new Rectangle(x, y, 128, 128);
	}
}
