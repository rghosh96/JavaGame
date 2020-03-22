import java.awt.Color;
import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Random;

import javax.swing.JPanel;

public class LevelTwo extends MenuOptions{
	
	Game game;
	int height;
	int width;
	Inputs key;
	SpritesList things;
	private int spawn;
	Random r = new Random();
	int rand1;
	int rand2;
	private Character c;
	
	private Portal p;
	Inputs keys;
	int tiles[][];
	
	public LevelTwo(Game g, Inputs k) {
		game = g;
		key = k;
		things = new SpritesList();
		hp = 100;
		
		level("map2.txt");
		spawn = 0;
		
		things.add(new Character(420,90, Identifier.Player, key, things, this));
		things.add(new Planet(400,200, Identifier.Still));
		things.add(new Cloud(150,600, Identifier.Still));
		things.add(new Cloud(700,750, Identifier.Still));
		things.add(new Enemy(830,830, Identifier.Enemy, this, things));
		things.add(new Enemy(830,830, Identifier.Enemy, this, things));
		things.add(new Enemy(830,70, Identifier.Enemy, this, things));
		things.add(new Enemy(830,70, Identifier.Enemy, this, things));
		things.add(new Enemy(70,830, Identifier.Enemy, this, things));
		things.add(new Enemy(70,830, Identifier.Enemy, this, things));
		things.add(new Enemy(70,70, Identifier.Enemy, this, things));
		things.add(new Enemy(70,70, Identifier.Enemy, this, things));
		things.add(new Collect(70,70, Identifier.Collect));
		things.add(new Collect(830,70, Identifier.Collect));
		things.add(new Collect(830,830, Identifier.Collect));
		things.add(new Collect(70,830, Identifier.Collect));
		
		things.add(new Collect(200,200, Identifier.Collect));
		things.add(new Collect(720,200, Identifier.Collect));
		things.add(new Collect(720,720, Identifier.Collect));
		things.add(new Collect(200,720, Identifier.Collect));
		
		p =new Portal(375,390, Identifier.Portal);
		
		c = (Character)things.objects.get(0);
		
	}
	
	public void level(String worldFile) {

		try {
			BufferedReader br = new BufferedReader(new FileReader(worldFile));
			height = Integer.parseInt(br.readLine());
			width = Integer.parseInt(br.readLine());
			tiles = new int[height][width];
			String delim = " ";
			for(int row = 0; row < height; row++) {
				String line = br.readLine();
				String[] tokens = line.split(delim);
				for (int col = 0; col < width; col++) {
					tiles[row][col] = Integer.parseInt(tokens[col]);
				}
			}
		}
		catch(Exception e) {}
		

	}
	
	protected boolean tileCollide(int x, int y) {
		x = x/Tiles.tileW;
		y = y/Tiles.tileH;
		if (!getTile(x, y).canWalk()) {
				return true;
			}
		return false;
		//}
	}
	
	public Tiles getTile(int i, int k) {
		if (i < 0 || k < 0 || i >= width || k >= height) {
			return Tiles.grass;
		}
		Tiles t = Tiles.map[tiles[i][k]];		//from 256 array of tiles
		if (t == null) {
			return Tiles.grass;
		}
		return t;
	}
	
	public void updateImage(Graphics g) {		
		
		things.updateState();
		game.updateState();
		//setBackground(Color.pink);
			
		
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				getTile(x, y).updateImage(g, (int)(x*Tiles.tileW), (int)(y*Tiles.tileH));
			}
		}
		
		things.updateImage(g);
		
		g.setColor(Color.white);
		g.fillRect(5, 5, 200, 32);
		
		g.setColor(Color.pink);
		g.fillRect(5, 5, hp*2, 32);
		
		g.setColor(Color.black);
		g.drawRect(5, 5, 200, 32);
		
		g.setColor(Color.white);
		g.drawString("HP: " + hp, 5, 50);
		
		if (hp <= 0) {
			MenuOptions.setOption(game.overState);
		}
		
		

		
	}

	@Override
	public void updateState() {
		
		spawn++;
		if (spawn % 100 == 0) {
			rand1 = r.nextInt(960);
			rand2 = r.nextInt(960);
			if (!tileCollide(rand1, rand2)) {
				things.add(new Enemy(rand1,rand2, Identifier.Enemy, this, things));
			}
		}
		if(key.isPaused()) {
			MenuOptions.setOption(game.pauseState);
			music.stopMusic();
			music.setSong("#3.wav");
			music.startMusic();

		}
		if (c.items() == 8) {
			things.add(p);
			if (spawn % 300 == 0) {
				things.add(new Boss(375,390, Identifier.Boss, this, things));
			}
		}
		
		if (c.hasWon()) {
			MenuOptions.setOption(game.finalState);
			music.stopMusic();
			music.setSong("#3.wav");
			music.startMusic();
		}
		
	}
	
	
}


