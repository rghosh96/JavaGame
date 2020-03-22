import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Ammo extends Sprites{
	MenuOptions game;
	SpritesList things;

	public Ammo(int xPos, int yPos, Identifier ID, float xDir, float yDir, MenuOptions g, SpritesList s) {
		super(xPos, yPos, ID);
		dx = xDir;
		dy = yDir;
		game = g;
		things = s;
	}

	@Override
	public void updateState() {

			moveX();
			moveY();

		
		
		
	}
	
	public void moveX() {
		if (dx > 0) {		//moving right
			int temp = (int)(x + dx + 8);
			if (!tileCollide(temp, y) && !tileCollide(temp, y + 8)) {
				x += dx;
			}
			else {
				things.remove(this);
			}
		}
		else if (dx < 0) {		//moving left
			int temp = (int)(x + dx);
			if (!tileCollide(temp, y) && !tileCollide(temp, y + 8)) {
				x += dx;
			}
			else {
				things.remove(this);
			}
		}
		
	}
	
	public void moveY() {
		if (dy < 0) {		//moving up
			int temp = (int)(y + dy);
			if (!tileCollide(x, temp) && !tileCollide(x + 8, temp)) {
				y += dy;
			}
			else {
				things.remove(this);
			}
		}
		else if (dy > 0) {		//moving down
			int temp = (int)(y + dy + 8);
			if (!tileCollide(x, temp) && !tileCollide(x + 8, temp)) {
				y += dy;
			}
			else {
				things.remove(this);
			}
		}
	}

	
	protected boolean tileCollide(int x, int y) {
		x = x/Tiles.tileW;
		y = y/Tiles.tileH;
		if (!game.getTile(x, y).canWalk()) {
				return true;
			}
		return false;
		//}
	}
	

	


	@Override
	public void updateImage(Graphics g) {
		g.drawImage(Images.bullets, x, y, 15, 15, null);
		
	}

	@Override
	public Rectangle bounds() {
		return new Rectangle(x, y, 10, 10);
	}
	
}
