import java.awt.Graphics;
import java.awt.Rectangle;

public class Cloud extends Sprites{

	public Cloud(int xPos, int yPos, Identifier ID) {
		super(xPos, yPos, ID);
		// TODO Auto-generated constructor stub
	}
	
	

	@Override
	public void updateState() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateImage(Graphics g) {
		g.drawImage(Images.cloud, x, y, 150, 100, null);
		
	}

	@Override
	public Rectangle bounds() {
		return new Rectangle(x+10, y+10, 100, 80);
	}

}
