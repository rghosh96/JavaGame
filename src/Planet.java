import java.awt.Graphics;
import java.awt.Rectangle;

public class Planet extends Sprites{

	public Planet(int xPos, int yPos, Identifier ID) {
		super(xPos, yPos, ID);
		// TODO Auto-generated constructor stub
	}
	
	

	@Override
	public void updateState() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateImage(Graphics g) {
		g.drawImage(Images.planet, x, y, 150, 150, null);
		
	}

	@Override
	public Rectangle bounds() {
		return new Rectangle(x+20, y+20, 100, 100);
	}

}
