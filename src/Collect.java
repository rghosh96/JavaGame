import java.awt.Graphics;
import java.awt.Rectangle;

public class Collect extends Sprites{

	public Collect(int xPos, int yPos, Identifier ID) {
		super(xPos, yPos, ID);
		// TODO Auto-generated constructor stub
	}
	
	

	@Override
	public void updateState() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateImage(Graphics g) {
		g.drawImage(Images.collect, x, y, 40, 40, null);
		
	}

	@Override
	public Rectangle bounds() {
		return new Rectangle(x, y, 35, 35);
	}

}
