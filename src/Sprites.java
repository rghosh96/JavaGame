import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class Sprites {
	
	protected int x;
	protected int y;
	protected float dx  = 0;
	protected float dy = 0;
	protected Identifier id;

	
	public Sprites(int xPos, int yPos, Identifier ID) {
		x = xPos;
		y = yPos;
		id = ID;
	}
	


	public abstract void updateState();
	public abstract void updateImage(Graphics g);
	public abstract Rectangle bounds();
	
	

	public Identifier getId() {
		return id;
	}
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public float getDx() {
		return dx;
	}

	public void setDx(float dx) {
		this.dx = dx;
	}

	public float getDy() {
		return dy;
	}

	public void setDy(float dy) {
		this.dy = dy;
	}
	
	
	
}
