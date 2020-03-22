import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;


public class Boss extends Sprites{

	Random r = new Random();
	int hp = 500;
	int rand;
	MenuOptions game;
	SpritesList things;
	
	public Boss(int xPos, int yPos, Identifier ID, MenuOptions m, SpritesList s) {
		super(xPos, yPos, ID);
		game = m;
		things = s;

	}

	@Override
	public void updateState() {
		x += dx;
		y += dy;
		rand = r.nextInt(10);
		if (rand == 0) {
			dx = (r.nextInt(4 - -4) + -4);
			dy = (r.nextInt(4 - -4) + -4);
		}
		
		if (tileCollide(x, y)) {
			dx = dx*-1;
			dy = dy*-1;
		}
		
		//shoot objects!!!
		for (int i = 0; i < things.objects.size(); i ++) {
			Sprites s = things.objects.get(i);
				if (s.getId() == Identifier.Ammo) {
					if (bounds().intersects(s.bounds())) {
						hp = hp - 25;
				}
			}
		}
		if (hp <= 0) {
			things.remove(this);
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
		g.drawImage(Images.boss, x, y, 80, 80, null);
		
	}

	@Override
	public Rectangle bounds() {
		return new Rectangle(x+5, y+5, 65, 65);
	}
	
	
}
