import java.awt.event.KeyEvent;

enum Direction {
	UP(KeyEvent.VK_UP, 0, -1), DOWN(KeyEvent.VK_DOWN, 0, 1), LEFT(
			KeyEvent.VK_LEFT, -1, 0), RIGHT(KeyEvent.VK_RIGHT, 1, 0);

	private int keyCode;
	private int xDir;
	private int yDir;

	private Direction(int keyCode, int xDir, int yDir) {
		this.keyCode = keyCode;
		this.xDir = xDir;
		this.yDir = yDir;
	}

	public int getKeyCode() {
		return keyCode;
	}

	public int getXDir() {
		return xDir;
	}

	public int getYDir() {
		return yDir;
	}
}