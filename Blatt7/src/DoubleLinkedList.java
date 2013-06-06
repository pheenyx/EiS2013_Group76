/**
 * Implements a Double Linked List.
 * 
 * @author Michael Mardaus
 * @author Julian Rost
 * @since 21.05.2013
 */
public class DoubleLinkedList<T> implements ObjectList<T> {

	private Entry<T> first;
	private Entry<T> last;
	private int size;
	
    /**
     * @return the first entry
     */
    public final Entry<T> getFirst() {
        return first;
    }
    /**
     * @return the last entry
     */
    public final Entry<T> getLast() {
        return last;
    }
    /**
     * @return the size
     */
    public final int size() {
        return size;
    }
    /**
     * adds the given object to the end of the list.
     * @param element the object to add
     */
    public final void add(T element){
        Entry<T> newEntry = new Entry<T>(element);
        if(!this.isEmpty()){
            Entry<T> last = this.getLast();
            last.setNext(newEntry);
            newEntry.setPrev(last);
            }
        else {
            this.first = newEntry;
        }
        this.last = newEntry;
        this.size++;
        return;
    }
    /**
     * returns whether the list is empty.
     * @return true or false
     */
    public final boolean isEmpty() {
        if(this.size == 0) return true;
        else return false;
    }
    /**
     * gets the element at position in the list.
     * @param position index in list
     * @return object element
     */
    public final T get(int position) {
        if(this.isEmpty()) return null;
        if(position > size-1 || position < 0) return null;
        
        Entry<T> current = this.getFirst();
        for(int i = 0; i < position; i++){
            current = current.getNext();
        }
        return current.getElement();
    }
    /**
     * adds the given object to given position in the list.
     * @param position desired index
     * @param element object to add
     */
    public final void add(int position, T element) {
        // if list is empty or position out of bounds return
        if(this.isEmpty()) return;
        if(position > size-1 || position < 0) return;
        
        // traverse to the position
        Entry<T> current = this.getFirst();
        for(int i = 0; i < position; i++){
            current = current.getNext();
        }
        Entry<T> newEntry = new Entry<T>(element);
        newEntry.setPrev(current.getPrev());
        newEntry.setNext(current);
        if(current.getPrev() != null){
            current.getPrev().setNext(newEntry);
        } else {
            // then current is first
            this.first = newEntry;
        }
        current.setPrev(newEntry);
        this.size++;
        return;
    }
    
    /**
     * removes an object from the list
     * @param position position of the element to be removed
     */
    public final void remove(int position) {
        // if list is empty or position out of bounds return
        if(this.isEmpty()) return;
        if(position > size-1 || position < 0) return;
        
        // traverse to the position
        Entry<T> current = this.getFirst();
        for(int i = 0; i < position; i++){
            current = current.getNext();
        }
        
        if(current.getNext() != null){
            current.getNext().setPrev(current.getPrev());
        }
        else {
            // we are at the list end
            this.last = current.getPrev();
        }
        
        if(current.getPrev() != null){
            current.getPrev().setNext(current.getNext());
        }
        else {
            // we are at the list begin
            this.first = current.getNext();
        }
        // delete outgoing pointers, not sure if necessary 
        current.setNext(null);
        current.setPrev(null);
        this.size--;
 
        return;
    }
    
    public final void print(){
        for(int i = 0; i < this.size; i++){
            System.out.println(this.get(i));
        }
        System.out.println();
    }

    public static void main(final String[] args) {
        DoubleLinkedList<String> list = new DoubleLinkedList<String>();
        list.add("This");
        list.add("is");
        list.add("a");
        list.add("test");
        list.add("and");
        list.add("it");
        list.add("should");
        list.add("show");
        list.add("that");
        list.add("my");
        list.add("program");
        list.add("works");
        list.print();
        
        list.add(3,"small");
        list.print();
        
        System.out.println(list.isEmpty()+"\n");
        
        list.remove(6);
        list.remove(7);
        list.remove(8);
        list.print();
    }
	
}

/**
 * Helper class for the DLList.
 * @author Michael Mardaus
 * @author Julian Rost
 * @since 21.05.2013
 */
class Entry<T> {
    private T element;
    private Entry<T> prev;
    private Entry<T> next;
    
    public Entry(T element){
        this.element = element;
    }
    
    public Entry(T element, Entry<T> prev, Entry<T> next) {
        this.element = element;
        this.prev = prev;
        this.next = next;
    }
    
    /**
     * @return the element
     */
    public final T getElement() {
        return element;
    }
    /**
     * @param element the element to set
     */
    public final void setElement(T element) {
        this.element = element;
    }
    /**
     * @return the prev
     */
    public final Entry<T> getPrev() {
        return prev;
    }
    /**
     * @param prev the prev to set
     */
    public final void setPrev(Entry<T> prev) {
        this.prev = prev;
    }
    /**
     * @return the next
     */
    public final Entry<T> getNext() {
        return next;
    }
    /**
     * @param next the next to set
     */
    public final void setNext(Entry<T> next) {
        this.next = next;
    }
    
    
}
