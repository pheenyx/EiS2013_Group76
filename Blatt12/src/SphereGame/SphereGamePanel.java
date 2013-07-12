import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.Timer;

/**
 * Panel with content for the game of spheres.
 * 
 * By the way, I insist that having private static final variables is superior
 * to having magic numbers in my code.
 */
public class SphereGamePanel extends JPanel {

	/*
	 * 
	 * START OF CONSTANT DECLARATIONS
	 */

	/**
	 * Versions UID of this class
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Background color for the game
	 */
	private static final Color COLOR_BACKGROUND = new Color(0, 0, 0);

	/**
	 * Color of balls that are to be caught
	 */
	private static final Color COLOR_TARGET = new Color(255, 255, 255);

	/**
	 * Possible player ball colors
	 */
	private static final Color[] COLOR_PLAYER = { Color.green, Color.red,
			Color.blue, Color.yellow, Color.pink, Color.orange };

	/**
	 * Player ball size
	 */
	private static final double SIZE_PLAYER = 12.0;

	/**
	 * Target ball size
	 */
	private static final double SIZE_TARGET = 6.0;

	/**
	 * Number of players
	 */
	private static final int NUMBER_PLAYERS = 6;

	/**
	 * Number of balls to be caught
	 */
	private static final int NUMBER_TARGETS = 50;

	/**
	 * Player number (and thusly, color) ("who is the human player?")
	 */
	private static final int HUMAN_PLAYER = 0;

	/**
	 * Random seed for position generation
	 */
	private static final Random GENERATOR_RANDOM = new Random();

	/**
	 * Step size per update call
	 */
	private static final double SIZE_STEP = 2.5;

	/**
	 * Handicap for computer players
	 */
	private static final double HANDICAP_CPU = 1.5;

	/*
	 * 
	 * END OF CONSTANT DECLARATIONS
	 */

	/*
	 * 
	 * START OF VARIABLE DECLARATIONS
	 */

	/**
	 * Debugging flag
	 */
	private boolean debug;

	/**
	 * Tells us whether we still need to initialize the game properly
	 */
	private boolean initFlag = true;

	/**
	 * Computer players AI
	 */
	private ComputerPlayersAdvisor cpuAI;

	/**
	 * Computer player AI timer
	 */
	private Timer cpuTimer;

	/**
	 * Collected sphere counter
	 */
	private int[] sphereCount;

	/**
	 * Map of where to move next according to human player input
	 */
	private Map<Direction, Boolean> movementMap = Collections
			.synchronizedMap(new HashMap<Direction, Boolean>());

	/**
	 * Player ball positions
	 */
	private List<HashMap<Axis, Double>> playerPositions = Collections
			.synchronizedList(new ArrayList<HashMap<Axis, Double>>());

	/**
	 * Positions of balls to be caught
	 */
	private List<HashMap<Axis, Double>> targetPositions = Collections
			.synchronizedList(new ArrayList<HashMap<Axis, Double>>());

	/*
	 * 
	 * END OF VARIABLE DECLARATION
	 */

	/**
	 * Minimal constructor. This panel needs to be told how often to update.
	 * 
	 * @param millisToFrame
	 *            how many milliseconds to wait before updating toward the next
	 *            frame
	 */
	public SphereGamePanel(int millisToFrame) {
		this(millisToFrame, false);
	}

	/**
	 * Constructor that additionally checks for debugging messages to be
	 * printed.
	 * 
	 * @param millisToFrame
	 *            how many milliseconds to wait before updating toward the next
	 *            frame
	 * @param debug
	 *            flag whether to print debugging messages to console
	 */
	public SphereGamePanel(int millisToFrame, boolean debug) {
		requestFocus();
		setKeyBindings();
		setBackground(COLOR_BACKGROUND);
		initializeVariables(debug);
		startUpAI(millisToFrame);
	}

	/**
	 * Sets the key bindings of the JPanel so as to enable input
	 */
	private void setKeyBindings() {
		InputMap im = getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		ActionMap am = getActionMap();
		for (final Direction direction : Direction.values()) {
			KeyStroke pressed = KeyStroke.getKeyStroke(direction.getKeyCode(),
					0, false);
			KeyStroke released = KeyStroke.getKeyStroke(direction.getKeyCode(),
					0, true);
			im.put(pressed, direction.toString() + "pressed");
			im.put(released, direction.toString() + "released");
			am.put(direction.toString() + "pressed", new AbstractAction() {
				private static final long serialVersionUID = 1L;

				@Override
				public void actionPerformed(ActionEvent a) {
					movementMap.put(direction, true);
				}
			});
			am.put(direction.toString() + "released", new AbstractAction() {
				private static final long serialVersionUID = 1L;

				@Override
				public void actionPerformed(ActionEvent a) {
					movementMap.put(direction, false);
				}
			});
		}
	}

	/**
	 * Initializes variables into the constructor.
	 * 
	 * @param d
	 *            debugging flag
	 */
	private void initializeVariables(boolean d) {
		debug = d;
		sphereCount = new int[NUMBER_PLAYERS];
		synchronized (playerPositions) {
			for (int i = 0; i < NUMBER_PLAYERS; i++) {
				playerPositions.add(new HashMap<Axis, Double>());
				sphereCount[i] = 0;
			}
		}
		synchronized (targetPositions) {
			for (int i = 0; i < NUMBER_TARGETS; i++)
				targetPositions.add(new HashMap<Axis, Double>());
		}
		synchronized (movementMap) {
			for (Direction direction : Direction.values())
				movementMap.put(direction, false);
		}
	}

	private void startUpAI(int millisToFrame) {
		cpuAI = new ComputerPlayersAdvisor(this, debug);
		cpuTimer = new Timer(millisToFrame, cpuAI);
		cpuTimer.start();
	}

	/**
	 * Set player position
	 */
	private void setPlayerPosition(int player, double x, double y) {
		synchronized (playerPositions) {
			playerPositions.get(player).put(Axis.X, x);
			playerPositions.get(player).put(Axis.Y, y);
		}
		if (debug)
			System.out.println("p" + player + " " + x + ":" + y);
	}

	/**
	 * Set target position
	 */
	private void setTargetPosition(int target, double x, double y) {
		synchronized (targetPositions) {
			targetPositions.get(target).put(Axis.X, x);
			targetPositions.get(target).put(Axis.Y, y);
		}
		if (debug)
			System.out.println("t" + target + " " + x + ":" + y);
	}

	/**
	 * The paint method paints.
	 */
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		moveActors();
		collectTargets();
		if (endCondition())
			quitGame();
		paintUpdate(g);
	}

	/**
	 * Move all the actors accordingly
	 */
	private void moveActors() {
		if (initFlag)
			moveToInitPositions();
		else
			movePlayers();
	}

	/**
	 * First updates the player's position, then the CPU AIs
	 */
	private void movePlayers() {
		moveHumanPlayer();
		moveCPUAIPlayers();
	}

	/**
	 * Calculates the human player's new position according to the directional
	 * map
	 */
	private void moveHumanPlayer() {
		for (Direction direction : Direction.values()) {
			synchronized (movementMap) {
				if (movementMap.get(direction)) {
					double nx = playerPositions.get(HUMAN_PLAYER).get(Axis.X)
							+ SIZE_STEP * direction.getXDir();
					double ny = playerPositions.get(HUMAN_PLAYER).get(Axis.Y)
							+ SIZE_STEP * direction.getYDir();
					setPlayerPosition(HUMAN_PLAYER, nx, ny);
				}
			}
		}
	}

	/**
	 * Calculates the CPU AI player's new positions according to AI
	 * recommendations
	 */
	private void moveCPUAIPlayers() {
		synchronized (playerPositions) {
			for (int i = 0; i < playerPositions.size(); i++) {
				// skip the human player, he moves himself
				if (i == HUMAN_PLAYER)
					continue;
				for (Direction direction : Direction.values()) {
					if (cpuAI.getAdvice().get(i).get(direction)) {
						double nx = playerPositions.get(i).get(Axis.X)
								+ (double) Math.round(SIZE_STEP
										* direction.getXDir() / HANDICAP_CPU);
						double ny = playerPositions.get(i).get(Axis.Y)
								+ (double) Math.round(SIZE_STEP
										* direction.getYDir() / HANDICAP_CPU);
						setPlayerPosition(i, nx, ny);
					}
				}
			}
		}
	}

	/**
	 * Moves all actors to some randomly generator initial positions
	 */
	private void moveToInitPositions() {
		for (int i = 0; i < NUMBER_PLAYERS; i++) {
			int x = GENERATOR_RANDOM.nextInt(getWidth());
			int y = GENERATOR_RANDOM.nextInt(getHeight());
			setPlayerPosition(i, x, y);
		}
		for (int i = 0; i < NUMBER_TARGETS; i++) {
			int x = GENERATOR_RANDOM.nextInt(getWidth());
			int y = GENERATOR_RANDOM.nextInt(getHeight());
			setTargetPosition(i, x, y);
		}
		initFlag = false;
	}

	/**
	 * Cleans up the playing field and awards points for collected targets
	 */
	private void collectTargets() {
		synchronized (playerPositions) {
			for (HashMap<Axis, Double> playerPosition : playerPositions) {
				synchronized (targetPositions) {
					for (HashMap<Axis, Double> targetPosition : targetPositions) {
						double x1 = playerPosition.get(Axis.X)
								+ (SIZE_PLAYER / 2);
						double y1 = playerPosition.get(Axis.Y)
								+ (SIZE_PLAYER / 2);
						double x2 = targetPosition.get(Axis.X)
								+ (SIZE_TARGET / 2);
						double y2 = targetPosition.get(Axis.Y)
								+ (SIZE_TARGET / 2);
						if (ComputerPlayersAdvisor.dist(x1, y1, x2, y2) < 1.1 * SIZE_TARGET) {
							sphereCount[playerPositions.indexOf(playerPosition)]++;
							targetPositions.remove(targetPosition);
						}
					}
				}
			}
		}
	}

	/**
	 * Returns whether the game is still running or has terminated.
	 * 
	 * @return game end status
	 */
	public synchronized boolean endCondition() {
		return targetPositions.isEmpty();
	}

	/**
	 * Shuts down game operations. Shows an end game screen.
	 */
	private void quitGame() {
		JDialog message = new JDialog();
		message.setTitle("End of Sphere Game");
	}

	/**
	 * Paints the actors anew
	 * 
	 * @param g
	 *            Graphics of the panel
	 */
	private void paintUpdate(Graphics g) {
		// actual update loop
		synchronized (playerPositions) {
			for (int i = 0; i < playerPositions.size(); i++)
				paintPlayer(g, i);
		}
		synchronized (targetPositions) {
			for (int i = 0; i < targetPositions.size(); i++)
				paintTarget(g, i);
		}
	}

	/**
	 * Shortcut method to paint a player, as identified by his ID
	 * 
	 * @param g
	 *            the Grahpics unto which to paint the player
	 * @param player
	 *            the number identifying the player
	 */
	private void paintPlayer(Graphics g, int player) {
		g.setColor(COLOR_PLAYER[player]);
		int x, y, rx, ry;
		synchronized (playerPositions) {
			x = (int) Math.round(playerPositions.get(player).get(Axis.X));
			y = (int) Math.round(playerPositions.get(player).get(Axis.Y));
			rx = (int) Math.round(SIZE_PLAYER);
			ry = (int) Math.round(SIZE_PLAYER);
		}
		g.fillOval(x, y, rx, ry);
	}

	/**
	 * Shortcut method to paint a target, as identified by its ID
	 * 
	 * @param g
	 *            the Grahpics unto which to paint the target
	 * @param target
	 *            the number identifying the target
	 */
	private void paintTarget(Graphics g, int target) {
		g.setColor(COLOR_TARGET);
		int x, y, rx, ry;
		synchronized (targetPositions) {
			x = (int) Math.round(targetPositions.get(target).get(Axis.X));
			y = (int) Math.round(targetPositions.get(target).get(Axis.Y));
			rx = (int) Math.round(SIZE_TARGET);
			ry = (int) Math.round(SIZE_TARGET);
		}
		g.fillOval(x, y, rx, ry);
	}

	@Override
	public void update(Graphics g) {
		paint(g);
	}

	/**
	 * Makes the players' positions accessible from outside
	 * 
	 * @return the players' positions
	 */
	public synchronized List<HashMap<Axis, Double>> getPlayerPositions() {
		return playerPositions;
	}

	/**
	 * Makes the targets' positions accessible from outside
	 * 
	 * @return the targets' positions
	 */
	public synchronized List<HashMap<Axis, Double>> getTargetPositions() {
		return targetPositions;
	}

	/**
	 * Gets the number of players currently in the game
	 * 
	 * @return number of players
	 */
	public synchronized int getNumberOfPlayers() {
		return playerPositions.size();
	}

	/**
	 * Gets the size of players in this game
	 * 
	 * @return size of players
	 */
	public double getSizePlayer() {
		return SIZE_PLAYER;
	}

	/**
	 * Gets the size of targets in this game
	 * 
	 * @return size of targets
	 */
	public double getSizeTarget() {
		return SIZE_TARGET;
	}

}
