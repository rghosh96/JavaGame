import java.awt.Graphics;
import java.awt.Rectangle;

public class Portal extends Sprites{
	
	SpritesList things;
	MenuOptions game;

	public Portal(int xPos, int yPos, Identifier ID) {
		super(xPos, yPos, ID);
		// TODO Auto-generated constructor stub
	}
	
	

	@Override
	public void updateState() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateImage(Graphics g) {
		g.drawImage(Images.portal, x, y, 100, 100, null);
		
	}

	@Override
	public Rectangle bounds() {
		return new Rectangle(x-5, y-5, 85, 85);
	}

}
