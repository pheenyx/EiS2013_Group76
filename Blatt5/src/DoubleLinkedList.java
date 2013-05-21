/**
 * Implements a Double Linked List.
 * 
 * @author Michael Mardaus
 * @author Julian Rost
 * @since 21.05.2013
 */
public class DoubleLinkedList {

	private Entry first;
	private Entry last;
	private int size;
	
    /**
     * @return the first entry
     */
    public final Entry getFirst() {
        return first;
    }
    /**
     * @return the last entry
     */
    public final Entry getLast() {
        return last;
    }
    /**
     * @return the size
     */
    public final int size() {
        return size;
    }
    /**
     * adds the given string to the end of the list.
     * @param element the string to add
     */
    public final void add(String element){
        Entry newEntry = new Entry(element);
        if(!this.isEmpty()){
            Entry last = this.getLast();
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
     * returns if the list is empty.
     * @return true or false
     */
    public final boolean isEmpty() {
        if(this.size == 0) return true;
        else return false;
    }
    /**
     * gets the element at position in the list.
     * @param position index in list
     * @return string element
     */
    public final String get(int position) {
        if(this.isEmpty()) return null;
        if(position > size-1 || position < 0) return null;
        
        Entry current = this.getFirst();
        for(int i = 0; i < position; i++){
            current = current.getNext();
        }
        return current.getElement();
    }
    /**
     * adds the given string to given position in the list.
     * @param position desired index
     * @param element string to add
     */
    public final void add(int position, String element) {
        // if list is empty or position out of bounds return
        if(this.isEmpty()) return;
        if(position > size-1 || position < 0) return;
        
        // traverse to the position
        Entry current = this.getFirst();
        for(int i = 0; i < position; i++){
            current = current.getNext();
        }
        Entry newEntry = new Entry(element);
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
    public final void remove(int position) {
        // if list is empty or position out of bounds return
        if(this.isEmpty()) return;
        if(position > size-1 || position < 0) return;
        
        // traverse to the position
        Entry current = this.getFirst();
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
        DoubleLinkedList list = new DoubleLinkedList();
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
class Entry {
    private String element;
    private Entry prev;
    private Entry next;
    
    public Entry(String element){
        this.element = element;
    }
    
    public Entry(String element, Entry prev, Entry next) {
        this.element = element;
        this.prev = prev;
        this.next = next;
    }
    
    /**
     * @return the element
     */
    public final String getElement() {
        return element;
    }
    /**
     * @param element the element to set
     */
    public final void setElement(String element) {
        this.element = element;
    }
    /**
     * @return the prev
     */
    public final Entry getPrev() {
        return prev;
    }
    /**
     * @param prev the prev to set
     */
    public final void setPrev(Entry prev) {
        this.prev = prev;
    }
    /**
     * @return the next
     */
    public final Entry getNext() {
        return next;
    }
    /**
     * @param next the next to set
     */
    public final void setNext(Entry next) {
        this.next = next;
    }
    
    
}
