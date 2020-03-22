import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Inputs implements KeyListener{
	
	private SpritesList things;
	private boolean up = false;
	private boolean down = false;
	private boolean left = false;
	private boolean right = false;
	
	private boolean upA = false;
	private boolean downA = false;
	private boolean leftA = false;
	private boolean rightA = false;
	
	private boolean enter = false;
	private boolean pause = false;
	private boolean resume = false;
	
	private boolean save = false;
	private boolean next = false;
	
	
	public Inputs() {
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void updateState() {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();

		if (key == KeyEvent.VK_W) {
			up = true;
		}
		if (key == KeyEvent.VK_S) {
			down = true;
		}
		if (key == KeyEvent.VK_A) {
			left = true;
		}
		if (key == KeyEvent.VK_D) {
			right = true;
		}
		
		//for ammo
		if (key == KeyEvent.VK_UP) {
			upA = true;
		}
		if (key == KeyEvent.VK_DOWN) {
			downA = true;
		}
		if (key == KeyEvent.VK_LEFT) {
			leftA = true;
		}
		if (key == KeyEvent.VK_RIGHT) {
			rightA = true;
		}
		
		if (key == KeyEvent.VK_ENTER) {
			enter = true;
		}
		
		if (key == KeyEvent.VK_P) {
			pause = true;
		}
		
		if (key == KeyEvent.VK_R) {
			resume = true;
		}
		
		if (key == KeyEvent.VK_S) {
			save = true;
		}
		
		if (key == KeyEvent.VK_N) {
			next = true;
		}
		
		
	}



	@Override
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		
		if (key == KeyEvent.VK_W) {
			up = false;
		}
		if (key == KeyEvent.VK_S) {
			down = false;
		}
		if (key == KeyEvent.VK_A) {
			left = false;
		}
		if (key == KeyEvent.VK_D) {
			right = false;
		}
		
		if (key == KeyEvent.VK_UP) {
			upA = false;
		}
		if (key == KeyEvent.VK_DOWN) {
			downA = false;
		}
		if (key == KeyEvent.VK_LEFT) {
			leftA = false;
		}
		if (key == KeyEvent.VK_RIGHT) {
			rightA = false;
		}
		
		if (key == KeyEvent.VK_ENTER) {
			enter = false;
		}
		
		if (key == KeyEvent.VK_P) {
			pause = false;
		}
		
		if (key == KeyEvent.VK_R) {
			resume = false;
		}
		
		if (key == KeyEvent.VK_S) {
			save = false;
		}
		
		if (key == KeyEvent.VK_N) {
			next = false;
		}
	}
	
	public boolean isUp() {
		return up;
	}

	public boolean isDown() {
		return down;
	}

	public boolean isLeft() {
		return left;
	}

	public boolean isRight() {
		return right;
	}

	public boolean isUpA() {
		return upA;
	}

	public boolean isDownA() {
		return downA;
	}

	public boolean isLeftA() {
		return leftA;
	}

	public boolean isRightA() {
		return rightA;
	}
	
	public boolean isEnter() {
		return enter;
	}
	
	
	public boolean isPaused() {
		return pause;
	}
	
	public boolean isResume() {
		return resume;
	}
	
	public boolean isSave() {
		return save;
	}
	
	public boolean isNext() {
		return next;
	}


}
