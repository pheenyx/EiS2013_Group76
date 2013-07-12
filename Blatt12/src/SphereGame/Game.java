import javax.swing.Timer;

/**
 * Main class of the sphere game. 
 * 
 * Nothing special. 
 * @author j-frost
 *
 */
public class Game {

	/**
	 * Milliseconds to wait for one frame update. 
	 * Note: this varies the speed for the whole simulation.
	 */
	private static final int MILLIS_TO_FRAME = 20;
	
	/**
	 * Debugging flag
	 */
	private static final boolean DEBUG_FLAG = false;

	/**
	 * @param args
	 *            no meaning
	 */
	public static void main(String... args) {
		SphereFrame gameFrame = new SphereFrame(MILLIS_TO_FRAME, DEBUG_FLAG);
		// This particular implementation below makes our whole frame update
		// every MILLIS_TO_FRAME ms. Of course, we could also apply this
		// listener only to the panel, or even to other random containers.
		Timer timer = new Timer(MILLIS_TO_FRAME, new RepaintTimerListener(
				gameFrame));
		timer.start();
	}

}