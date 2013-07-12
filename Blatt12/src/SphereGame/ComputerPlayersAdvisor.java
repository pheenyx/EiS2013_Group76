import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Advisor class for the CPU AI players of the sphere game.
 * 
 * Note that this implementation is both naïve and inefficient.
 * 
 * @author j-frost
 * 
 */
public class ComputerPlayersAdvisor implements ActionListener {

	/**
	 * Debugging flag.
	 */
	private boolean debug = false;

	/**
	 * The advice that's readily available as output. Note that this is advice
	 * for all computer players.
	 */
	private List<HashMap<Direction, Boolean>> advice;

	/**
	 * The game panel. Why not have all information in one place? What could
	 * possibly go wrong?
	 */
	private SphereGamePanel panel;

	/**
	 * Constructor that only takes the necessary game panel.
	 * 
	 * @param p
	 *            the game's panel
	 */
	ComputerPlayersAdvisor(SphereGamePanel p) {
		panel = p;
		resetAdvice();
	}

	/**
	 * Constructor that accepts a debug flag in addition to the game's panel.
	 * 
	 * @param panel
	 *            game panel
	 * @param debug
	 *            debugging flag
	 */
	ComputerPlayersAdvisor(SphereGamePanel panel, boolean debug) {
		this(panel);
		this.debug = debug;
	}

	/**
	 * Retrieves the last advice that the advisor has thought of.
	 * 
	 * Note that this may be out of date or even midway through being changed
	 * when retrieved. There are no checks and balances in place and if you have
	 * a very slow machine (or you modify the AI to be horrendously difficult to
	 * calculate), this getter may fail to produce valid and/or valuable
	 * results.
	 * 
	 * @return the last known (saved) advice (nothing to do with safe)
	 */
	public List<HashMap<Direction, Boolean>> getAdvice() {
		return advice;
	}

	@Override
	/**
	 * The algorithm for updating the advice every ai calculation cycle.
	 * @param e triggering action event (most likely a timer event)  
	 */
	public void actionPerformed(ActionEvent e) {
		resetAdvice();
		List<HashMap<Axis, Double>> playerPositions = panel
				.getPlayerPositions();
		List<HashMap<Axis, Double>> targetPositions = panel
				.getTargetPositions();
		for (HashMap<Axis, Double> playerPosition : playerPositions) {
			double minDist = Double.MAX_VALUE;
			HashMap<Axis, Double> currentTarget = null;
			for (HashMap<Axis, Double> targetPosition : targetPositions) {
				if (targetPosition.size() == 0)
					continue;
				double distance = dist(playerPosition.get(Axis.X),
						playerPosition.get(Axis.Y), targetPosition.get(Axis.X),
						targetPosition.get(Axis.Y));
				if (distance < minDist) {
					minDist = distance;
					currentTarget = targetPosition;
					if (debug)
						System.out.println(minDist);
				}
			}
			if (currentTarget == null)
				continue;
			for (Direction direction : Direction.values()) {
				if (direction.getXDir() == Math.signum(currentTarget
						.get(Axis.X)
						- playerPosition.get(Axis.X)))
					advice.get(playerPositions.indexOf(playerPosition)).put(
							direction, true);
				if (direction.getYDir() == Math.signum(currentTarget
						.get(Axis.Y)
						- playerPosition.get(Axis.Y)))
					advice.get(playerPositions.indexOf(playerPosition)).put(
							direction, true);
			}
		}

	}

	/**
	 * Resets the advice and wipes it a clean slate (i.e. deletes it and writes
	 * blank values).
	 */
	private void resetAdvice() {
		advice = new ArrayList<HashMap<Direction, Boolean>>();
		for (int i = 0; i < panel.getNumberOfPlayers(); i++) {
			advice.add(new HashMap<Direction, Boolean>());
			for (Direction direction : Direction.values())
				advice.get(i).put(direction, false);
		}
	}

	/**
	 * Calculates the Euclidean distance between two points in a 2D Cartesian
	 * coordinate system.
	 * 
	 * @param x1
	 *            x coordinate of the first point
	 * @param y1
	 *            y coordinate of the first point
	 * @param x2
	 *            x coordinate of the second point
	 * @param y2
	 *            y coordinate of the second point
	 * @return distance between the points
	 */
	public static double dist(double x1, double y1, double x2, double y2) {
		double x = x1 - x2;
		double y = y1 - y2;
		return Math.sqrt(x * x + y * y);
	}

}
