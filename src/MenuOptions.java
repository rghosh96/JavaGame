import java.awt.Graphics;

public abstract class MenuOptions {
	
	public static MusicPlayer music = new MusicPlayer();
	private static MenuOptions current = null;

	
	public static void setOption(MenuOptions state) {
		current = state;
	}
	public static MenuOptions getCurrentOption() {
		return current;
	}
	public int hp;

	
	public abstract void updateState();
	public abstract void updateImage(Graphics g);
	protected abstract Tiles getTile(int x, int y);


}
