
/**
 *   
 * @author Michael Mardaus
 * @author Julian Rost
 *
 */
public class FilteredList<T> implements ObjectList<T> {
	
	private ObjectList<T> list;		// the list, that contains the elements
	private ObjectFilter<T> filter;   // the filter, that proofs the strings
	
	/**
	 * Constructs a list with the list, that contains the elements and the filter. 
	 *   
	 * @param list it contains the element.
	 * @return filter it proofs the strings.
	 *
	 */
	@SuppressWarnings("unchecked") // nothing to do here
	public FilteredList(ObjectList<T> list, ObjectFilter<? extends T> filter){
		this.list=list;
		this.filter=(ObjectFilter<T>)filter;
	}
	
	/**
	 * getFirst returns the first element of the list.
	 *   
	 * @return The first element as Entry 
	 *
	 */
	public Entry<T> getFirst() {
		return list.getFirst();
	}
	
	/**
	 * getLast returns the last element of the list.
	 *   
	 * @return The last element as Entry
	 *
	 */
	public Entry<T> getLast() {
		return list.getLast();
	}
	
	/**
	 * adds a new element at the end of the list.
	 *   
	 * @param element The string element, that will be added. 
	 *
	 */
	public void add(T element) {
		if(filter.isValid(element)){
			list.add(element);
		}
	}
	
	/**
	 * proofs, whether this list is empty or not.
	 *   
	 * @return if the list is empty, it returns true, false otherwise. 
	 *
	 */
	public boolean isEmpty() {
		return list.isEmpty();
	}
	
	/**
	 * counts the elements of the list.
	 *   
	 * @return the count of the elements of the list. 
	 *
	 */
	public int size() {
		return list.size();
	}
	
	/**
	 * returns the element at the given position as string
	 *   
	 * @return the element at the given position.
	 * @param position the position of the element. 
	 * @exception IndexOutOfBoundsException if the given position do not exists.
	 *
	 */
	public T get(int position) {
		return list.get(position);
	}
	
	/**
	 * adds an element at the given position
	 * 
	 * @param position the position of the element.  
	 * @param element the element, which will be added.
	 *
	 */
	public void add(int position, T element) {
		if(filter.isValid(element)){
			list.add(position,element);
		}	
	}
	
	/**
	 * removes the element at the given position
	 * 
	 * @param position the position of the element.  
	 *
	 */
	public void remove(int position) {
		list.remove(position);	
	}

}