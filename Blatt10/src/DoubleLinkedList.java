import java.util.ListIterator;


/**
 * For sheet 10 exercise 1
 * This class represents a double linked list, which contains strings.
 *   
 * @author Sascha Fraenkel
 *
 */
public class DoubleLinkedList<T>
implements ObjectList<T>{
	
	private Entry<T> first; // The first element of the List
	private Entry<T> last; // The last element of the List
	private int size;     // The size  (count of elements) of the list

	/**
	 * adds a new element at the end of the list.
	 *   
	 * @param element The string element, that will be added. 
	 *
	 */
	public void add(T element){
		Entry<T> entry= new Entry<T>(element,last);
		if(size==0){
			first=entry;
		}
		last=entry;
		size++;
	}
	
	/**
	 * proofs, whether this list is empty or not.
	 *   
	 * @return if the list is empty, it returns true, false otherwise. 
	 *
	 */
	public boolean isEmpty(){
		return (size==0);
	}
	
	/**
	 * counts the elements of the list.
	 *   
	 * @return the count of the elements of the list. 
	 *
	 */
	public int size(){
		return size;
	}
	
	/**
	 * returns the element at the given position as string
	 *   
	 * @return the element at the given position.
	 * @param position the position of the element. 
	 * @exception IndexOutOfBoundsException if the given position do not exists.
	 *
	 */
	public T get(int position){
		if(position<0 || position>=size){
			throw new IndexOutOfBoundsException("It is not able to get the element at "+position+". List size = "+size);
		}
		Entry<T> entry=first;
		for(int i=0; i<position; i++){
			entry=entry.getNext();
		}
		return entry.getElement();
	}
	
	/**
	 * adds an element at the given position
	 * 
	 * @param position the position of the element.  
	 * @param element the element, which will be added.
	 * @exception IndexOutOfBoundsException if the given position do not exists.
	 *
	 */
	public void add(int position, T element){
		if(position<0 || position>size){
			throw new IndexOutOfBoundsException("It is not able to add element at "+position+". List size = "+size);
		}
		if(size==position){
			add(element);
			return;
		}
		if(position==0){
			Entry<T> entry= new Entry<T>(element,null);
			first.setPrevious(entry);
			first=entry;
			size++;
			return;
		}
		Entry<T> prev=first;
		for(int i=0; i<position-1; i++){
			prev=prev.getNext();
		}
		Entry<T> next= prev.getNext();
		Entry<T> entry= new Entry<T>(element,prev);
		if(next!=null){
			next.setPrevious(entry);
		}
		size++;
	}
	
	/**
	 * removes the element at the given position
	 * 
	 * @param position the position of the element.  
	 * @exception IndexOutOfBoundsException if the given position do not exists.
	 *
	 */
	public void remove(int position){
		if(position<0 || position>=size){
			throw new IndexOutOfBoundsException("It is not able to remove element at "+position+". List size = "+size);
		}
		if(position==0){
			first=first.getNext();
			first.setPrevious(null);
			size--;
			return;
		}
		if(position==size-1){
			last=last.getPrevious();
			last.setNext(null);
			size--;
			return;
		}
		Entry<T> prev=first;
		for(int i=0; i<position-1; i++){
			prev=prev.getNext();
		}
		Entry<T> entry= prev.getNext();
		Entry<T> next= entry.getNext();
		if(next!=null){
			next.setPrevious(prev);
		}
		size--;
	}
	
	public ListIterator<T> iterator() {
		return new DoubleLinkedListIterator<T>(first, this);
	}
	
	public ListIterator<T> firstIterator() {
		return new DoubleLinkedListIterator<T>(first, this);
	}
	
	public ListIterator<T> lastIterator() {
		return new DoubleLinkedListIterator<T>(last, this);
	}
}

