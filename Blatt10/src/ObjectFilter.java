
/**
 * For sheet 10 exercise 1
 * An Object is a StringFilter, when it proofs, whether a string meets a condition or not. The method, that proofs
 * strings is called isValid. 
 *   
 * @author Sascha Fraenkel
 *
 */
public interface ObjectFilter<T> {
	
	/**
	 * isValid proof whether a string meets a condition or not.
	 *   
	 * @param s the string, that will be proofed
	 * @return true, if the string meets the condition.
	 *
	 */
	boolean isValid(T s);
}
