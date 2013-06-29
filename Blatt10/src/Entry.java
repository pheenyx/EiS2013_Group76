
/**
 * For sheet 10 exercise 1
 * This interface represents an entry of a double linked list, every object has a reference to a string 
 * (also called element), to the next element and to the previous element. When the previous entry
 * is set, the next entry of the previous reference will be set automatically.
 *   
 * @author Sascha Fraenkel
 *
 */
public class Entry<T> {
	private Entry<T> previous;    // the reference to the previous element
	private Entry<T> next;		 // the reference to the next element
	private T element;          // the element
	
	/**
	 * creates a new entry this a given element and the previous entry. It set the next reference of the
	 * previous entry automatically. 
	 *
	 */
	public Entry(T elm, Entry<T> previous){
		this.previous=previous;
		if(previous!=null){
			previous.next=this;
		}
		element=elm;
	}
	
	/**
	 * set a new reference to the previous entry. It set the next reference of the
	 * previous entry automatically.
	 * 
	 * @param previous the new previous entry
	 *
	 */
	public void setPrevious(Entry<T> previous){
		this.previous=previous;
		if(previous!=null){
			previous.next=this;
		}
	}
	
	/**
	 * set a new reference to the next entry. It set the previous reference of the
	 * next entry automatically.
	 * 
	 * @param next the new next entry
	 *
	 */
	public void setNext(Entry<T> next){
		this.next=next;
		if(next!=null){
			next.previous=this;
		}
	}
	
	/**
	 * returns the reference to the next entry.
	 * 
	 * @return the next entry
	 *
	 */
	public Entry<T> getNext(){
		return next;
	}
	
	/**
	 * returns the reference to the previous entry
	 * 
	 * @return the previous entry
	 *
	 */
	public Entry<T> getPrevious(){
		return previous;
	}
	
	/**
	 * returns the reference to the element
	 * 
	 * @return the element
	 *
	 */
	public T getElement(){
		return element;
	}
}
