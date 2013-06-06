
/**
 *   
 * @author Michael Mardaus
 * @author Julian Rost
 *
 */
public interface ObjectFilter<T> {
	
	/**
	 * isValid proof whether an object meets a condition or not.
	 *   
	 * @param element the object to check
	 * @return whether object passes the test
	 *
	 */
	boolean isValid(T element);
}