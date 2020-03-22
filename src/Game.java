import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Game extends JPanel implements Runnable{
	
	//to run thread
	private boolean isRunning = false;
	private Thread t;
	
	public DoGame gameState;
	public MenuPage menuState; 
	public PausePage pauseState; 
	public GameOver overState; 
	public InstructionsPage instrState;
	public WinPage winState; 
	public NextPage nextState;
	public LevelTwo twoState; 
	public FinalPage finalState;
	public LastLevel finalLevel; 
	

	
	

	
	//the array list holding all game pieces
	//SpritesList sprites;
	Inputs keys;
//	int height;
//	int width;
//	int tiles[][];
	//public int hp = 100;
	JFrame frame;
	private Character c;

	
	public Game(Inputs input, JFrame f) {
		
		start();
		frame = f;
		
		
		
		
		//sprites = new SpritesList();

		
		keys = input;
		
		
	

		
	}
	
	public synchronized void start() {
		if (isRunning) {
			return;
		}
		isRunning = true;
		t = new Thread(this);
		t.start();
	}
	
	public synchronized void stop() {
		if (!isRunning) {
			return;
		}
		isRunning = false;
		try {
			t.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
//	public Tiles getTile(int i, int k) {
//		if (i < 0 || k < 0 || i >= width || k >= height) {
//			return Tiles.grass;
//		}
//		Tiles t = Tiles.map[tiles[i][k]];		//from 256 array of tiles
//		if (t == null) {
//			return Tiles.grass;
//		}
//		return t;
//	}
	
//	public void level(String worldFile) {
//
//		try {
//			BufferedReader br = new BufferedReader(new FileReader(worldFile));
//			height = Integer.parseInt(br.readLine());
//			width = Integer.parseInt(br.readLine());
//			tiles = new int[height][width];
//			String delim = " ";
//			for(int row = 0; row < height; row++) {
//				String line = br.readLine();
//				String[] tokens = line.split(delim);
//				for (int col = 0; col < width; col++) {
//					tiles[row][col] = Integer.parseInt(tokens[col]);
//				}
//			}
//		}
//		catch(Exception e) {}
//		
//
//	}
	
	public Inputs getInputs() {
		return keys;
	}
	
//	public SpritesList getSprites() {
//		return sprites;
//	}
	
	private void init() {
		Images.init();
		gameState = new DoGame(this, keys);			//instantiate generic abstract gamePage (type MenuOptions) to game page
		menuState = new MenuPage(this, frame, keys);
		pauseState = new PausePage(this, frame, keys);
		overState = new GameOver(this, frame, keys);
		winState = new WinPage(this, frame, keys);
		nextState = new NextPage(this, frame, keys);
		twoState = new LevelTwo(this, keys);
		finalState = new FinalPage(this, frame, keys);
		finalLevel = new LastLevel(this, keys);
		instrState = new InstructionsPage(this, frame, keys);
		MenuOptions.setOption(menuState);	//set state to game page
	}
	
//	public MenuOptions getPause() {
//		return gameState;
//	}
//	
//	public MenuOptions getMenuPage() {
//		return menuState;
//	}

	@Override
	public void run() {
		init();
		
		int tps = 60;	//ticks per second
		double timePerTick = 1000000000 / tps;	// 1bil nanoseconds in one second; so 1/how many times want to run (max seconds to achieve 60 ticks per second)
		double delta = 0;
		long now; 
		long lastTime = System.nanoTime();      //current computer time in nanoseconds
		
		while(isRunning) {
			now = System.nanoTime();
			delta += (now-lastTime)/timePerTick;
			lastTime = now;
			
			if (delta >= 1) {
				//tick();
				repaint();
				delta--;
			}		
		}	
	}
	
	public void updateState() {

		if(MenuOptions.getCurrentOption() != null) {		//if it exists!
			MenuOptions.getCurrentOption().updateState();
		}
		

		


	}
	
	public Character c() {
		return c;
	}
	
//	protected boolean tileCollide(int x, int y) {
//		x = x/Tiles.tileW;
//		y = y/Tiles.tileH;
//		if (!getTile(x, y).canWalk()) {
//				return true;
//			}
//		return false;
//		//}
//	}
	
	public void paintComponent(Graphics g) {	
		super.paintComponent(g);
		if(MenuOptions.getCurrentOption() != null) {
			MenuOptions.getCurrentOption().updateImage(g);
		}
		

		
		updateState();
		
	}
}
