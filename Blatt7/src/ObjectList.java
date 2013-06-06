
/**
 * For sheet 7 exercise 1
 * This interface represents a list.
 *   
 * @author Michael Mardaus
 * @author Julian Rost
 *
 */
public interface ObjectList<T> {
	
	/**
	 * getFirst returns the first element of the list.
	 *   
	 * @return The first element as Entry 
	 *
	 */
	public Entry<T> getFirst();
	
	/**
	 * getLast returns the last element of the list.
	 *   
	 * @return The last element as Entry
	 *
	 */
	public Entry<T> getLast();
	
	/**
	 * adds a new element at the end of the list.
	 *   
	 * @param element The string element, that will be added. 
	 *
	 */
	public void add(T element);
	
	/**
	 * checks whether this list is empty or not.
	 *   
	 * @return if the list is empty, it returns true, false otherwise. 
	 *
	 */
	public boolean isEmpty();
	
	/**
	 * counts the elements of the list.
	 *   
	 * @return the count of the elements of the list. 
	 *
	 */
	public int size();
	
	/**
	 * returns the element at the given position
	 *   
	 * @return the element at the given position.
	 * @param position the position of the element. 
	 *
	 */
	public T get(int position);
	
	/**
	 * adds an element at the given position
	 * 
	 * @param position the position of the element.  
	 * @param element the element, which will be added.
	 *
	 */
	public void add(int position, T element);
	
	/**
	 * removes the element at the given position
	 * 
	 * @param position the position of the element.  
	 *
	 */
	public void remove(int position);
}