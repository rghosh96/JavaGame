import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;


public class Enemy extends Sprites{

	Random r = new Random();
	int hp = 200;
	int rand;
	MenuOptions game;
	SpritesList things;
	
	public Enemy(int xPos, int yPos, Identifier ID, MenuOptions m, SpritesList s) {
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
			dx = (r.nextInt(2 - -2) + -2);
			dy = (r.nextInt(2 - -2) + -2);
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
		g.drawImage(Images.enemy, x, y, 40, 40, null);
		
	}

	@Override
	public Rectangle bounds() {
		return new Rectangle(x, y, 35, 35);
	}
	
	
}
