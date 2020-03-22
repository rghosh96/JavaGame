import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class Character extends Sprites{
	
	SpritesList things;
	Inputs keys;

	MenuOptions game;
	private int count;
	private int collection;
	private boolean win = false;
	

	public Character(int xPos, int yPos, Identifier ID, Inputs input, SpritesList s, MenuOptions g) {
		super(xPos, yPos, ID);
		keys = input;

		things = s;
		game = g;
		count = 0;
		collection = 0;
		

		
	}

	@Override
	public void updateState() {
		
		objCollide();
		if(keys.isUp()) {
			dy = -5;
		}
		else if(!keys.isDown()) {
			dy = 0;
		}
		
		if(keys.isDown()) {
			dy = 5;
		}
		else if(!keys.isUp()) {
			dy = 0;
		}
		
		if(keys.isRight()) {
			dx = 5;
		}
		else if(!keys.isLeft()) {
			dx = 0;
		}
		
		if(keys.isLeft()) {
			dx = -5;
		}
		else if(!keys.isRight()) {
			dx = 0;
		}
		
		
		count++;
		
		
		moveX();
		moveY();
		
		if (count % 10 == 0) {
		
		if (keys.isUpA()) {
			things.add(new Ammo(x + 22, y + 15, Identifier.Ammo, 0, -5, game, things));
		}
		if (keys.isDownA()) {
			things.add(new Ammo(x + 22, y + 15, Identifier.Ammo, 0, 5, game, things));
		}
		if (keys.isRightA()) {
			things.add(new Ammo(x + 22, y + 15, Identifier.Ammo, 5, 0, game, things));
		}
		if (keys.isLeftA()) {
			things.add(new Ammo(x + 22, y + 15, Identifier.Ammo, -5, 0, game, things));
		}
		}
		
		for (int i = 0; i < things.objects.size(); i ++) {
			Sprites s = things.objects.get(i);
				if (s.getId() == Identifier.Enemy) {
					if (bounds().intersects(s.bounds())) {
						game.hp = game.hp - 1;
					}
				}
				if (s.getId() == Identifier.Boss) {
					if (bounds().intersects(s.bounds())) {
						game.hp = game.hp - 2;
					}
				}
				if (s.getId() == Identifier.Collect) {
					if (bounds().intersects(s.bounds())) {
						collection++;
						things.remove(s);
					}
				}
				if (s.getId() == Identifier.Portal) {
					if (bounds().intersects(s.bounds())) {
						win = true;
					}
				}
		}
		
		
	}
	
	public void moveX() {
		if (dx > 0) {		//moving right
			int temp = (int)(x + dx + 55);
			if (!tileCollide(temp, y) && !tileCollide(temp, y + 30)) {
				x += dx;
			}
		}
		else if (dx < 0) {		//moving left
			int temp = (int)(x + dx);
			if (!tileCollide(temp, y) && !tileCollide(temp, y + 30)) {
				x += dx;
			}
		}
		
		
		
	}
	
	public void moveY() {
		if (dy < 0) {		//moving up
			int temp = (int)(y + dy);
			if (!tileCollide(x, temp) && !tileCollide(x + 55, temp)) {
				y += dy;
			}
		}
		else if (dy > 0) {		//moving down
			int temp = (int)(y + dy + 30);
			if (!tileCollide(x, temp) && !tileCollide(x + 30, temp)) {
				y += dy;
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
	}
	
	protected void objCollide() {
		for (int i = 0; i < things.objects.size(); i ++) {
			Sprites s = things.objects.get(i);
				if (s.getId() == Identifier.Still) {
					if (bounds().intersects(s.bounds())) {
						x+= dx*-1;
						y+=dy*-1;
					}
				}
		}
	}
	
	public int items() {
		return collection;
	}
	
	public boolean hasWon() {
		return win;
	}
	

	@Override
	public void updateImage(Graphics g) {
		g.drawImage(Images.player,x, y, 55, 30, null);	//center camera on character!

	}

	@Override
	public Rectangle bounds() {
		return new Rectangle(x+5,  y+5,  45, 20);
	}
	

}
