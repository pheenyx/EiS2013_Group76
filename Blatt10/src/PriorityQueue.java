import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Queue;

/**
 * Implements a PriorityQueue.
 * a) Our datastructure is a ArrayList of PQEntries, where an PQEntry is a class
 *    consisting of a tuple of E elememt and a Numbertype N for the priority.
 *    In retrospective an Array would have been sufficient for that implementation.  
 * 
 * @author Michael Mardaus
 * @author Julian Rost
 * @since 29.06.2013
 */
public class PriorityQueue<E> implements Queue<E> {

	private ArrayList<PQEntry<E, Double>> Q;
	private int maxSize;
	private int nItems;

	public PriorityQueue(int maxSize) {
	    this.Q = new ArrayList<PQEntry<E, Double>>(maxSize);
	    for (int i = 0; i < maxSize; i++) Q.add(null);
	    this.maxSize = maxSize;
	    this.nItems = 0;
	}
	
	public boolean add(E entry, double priority){
	
	    try {
            int i;
            PQEntry<E, Double> item = new PQEntry<E, Double>(entry, priority);
            if (nItems == 0)
                Q.set(nItems++, item); // insert at 0
            else {
                for (i = nItems - 1; i >= 0; i--) {
                    if (item.compareTo(Q.get(i)) > 0) // if new item larger,
                        Q.set(i + 1, Q.get(i)); // shift upward
                    else
                        // if smaller,
                        break; // done shifting
                }
                Q.set(i + 1, item); // insert it
                nItems++;
            } // end else (nItems > 0)
            return true;
        } catch (Exception e) {
            throw new IllegalStateException();
        }
	   
	}
	
	@Override
	public boolean add(E entry) {
	    return this.add(entry, nItems + 1);
	}



    @Override
    public boolean addAll(Collection<? extends E> arg0) {
        while (arg0.iterator().hasNext()) {
            this.add(arg0.iterator().next());
        }
        return false;
    }



    @Override
    public void clear() {
        Q.clear();
        nItems = 0;
    }



    @Override
    public boolean contains(Object arg0) {
        throw new UnsupportedOperationException();
    }



    @Override
    public boolean containsAll(Collection<?> arg0) {
        throw new UnsupportedOperationException();
    }



    @Override
    public boolean isEmpty() {
        return nItems == 0;
    }




    @Override
    public boolean remove(Object arg0) {
        throw new UnsupportedOperationException();
    }




    @Override
    public E element() {
        if (this.isEmpty()) {
            throw new NoSuchElementException();
        } else {
            return Q.get(nItems-1).element;
        }
    }



    @Override
    public boolean offer(E arg0) {
        try {
            int i;
            PQEntry<E, Double> item = new PQEntry<E, Double>(arg0, (double)(nItems + 1) );
            if (nItems == 0)
                Q.set(nItems++, item); // insert at 0
            else {
                for (i = nItems - 1; i >= 0; i--) {
                    if (item.compareTo(Q.get(i)) > 0) // if new item larger,
                        Q.set(i + 1, Q.get(i)); // shift upward
                    else
                        // if smaller,
                        break; // done shifting
                }
                Q.set(i + 1, item); // insert it
                nItems++;
            } // end else (nItems > 0)
            return true;
        } catch (Exception e) {
            return false;
        }
    }



    @Override
    public E peek() {
        if (this.isEmpty()) {
            return null;
        } else {
            return Q.get(nItems-1).element;
        }
    }



    @Override
    public E poll() {
        if (this.isEmpty()) {
            return null;
        } else {
            E head = Q.get(nItems-1).element;
            Q.remove(nItems-1);
            nItems--;
            return head;
        }
    }



    @Override
    public E remove() {
        if (this.isEmpty()) {
            throw new NoSuchElementException();
        } else {
            E head = Q.get(nItems-1).element;
            Q.remove(nItems-1);
            nItems--;
            return head;
        }
    }
   

    @Override
    public Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int size() {
        return this.nItems;
    }

    @Override
    public Object[] toArray() {
        throw new UnsupportedOperationException();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        throw new UnsupportedOperationException();
    }
    
    public void print() {
        for (int i = nItems - 1; i >= 0; i--){
            System.out.println(Q.get(i).element);
        }
    }
    
    public static void main(final String[] args) {
        PriorityQueue<String> list = new PriorityQueue<String>(20);
        list.add("This");
        list.add("is");
        list.add("a");
        list.add("test");
        list.add("not", 2.5);
        list.print();
        
        System.out.println("empty? " + list.isEmpty());
        System.out.println("size " + list.size()+"\n");
        
        System.out.println(list.remove());
        System.out.println(list.poll());
        System.out.println(list.poll());
        System.out.println(list.poll());
        System.out.println(list.poll());
        System.out.println("empty? " + list.isEmpty()+"\n");
        
        System.out.println(list.poll());
        System.out.println("now remove should throw an exception");
        System.out.println(list.remove());
        
    }
	
}
