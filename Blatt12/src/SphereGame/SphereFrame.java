import java.awt.GridLayout;

import javax.swing.JFrame;

/**
 * For sheet 12 exercise 3 This is the Frame, that can be used for the game.
 */
public class SphereFrame extends JFrame {

	/**
	 * Versions UID of this class
	 */
	private static final long serialVersionUID = 1L;

	/*
	 * The playing field
	 */
	private SphereGamePanel gamePanel;

	/**
	 * The default constructor.
	 */
	public SphereFrame(int millisToFrame) {
		this(millisToFrame, false);
	}

	/**
	 * Constructor that checks for debug flag.
	 */
	public SphereFrame(int millisToFrame, boolean debug) {
		// JFrame with "Sphere Game" as title.
		super("Sphere Game");
		// Size of the screen.
		int screenW = getToolkit().getScreenSize().width;
		int screenH = getToolkit().getScreenSize().height;
		// Quit the program, when the user want it.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// The bounds of the Frame.
		setBounds(screenW / 10, screenH / 10, 8 * screenW / 10,
				8 * screenH / 10);
		// Sets a new GrisLayout.
		getContentPane().setLayout(new GridLayout(1, 1));
		// Set the field of the game in the Frame.
		gamePanel = new SphereGamePanel(millisToFrame, debug);
		getContentPane().add(gamePanel);
		// Makes the frame visible.
		setVisible(true);
	}

}
