import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Queue;

/**
 * Implements a PriorityQueue.
 * 
 * @author Michael Mardaus
 * @author Julian Rost
 * @since 29.06.2013
 */
public class PriorityQueue<E> implements Queue<E> {

	private ArrayList<PQEntry<E, Double>> Q;
	private int size;
	private int nItems;

	public PriorityQueue(int size) {
	    this.Q = new ArrayList<PQEntry<E, Double>>(size);
	    this.size = size;
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
        return Q.isEmpty();
    }




    @Override
    public boolean remove(Object arg0) {
        throw new UnsupportedOperationException();
    }




    @Override
    public E element() {
        if (Q.isEmpty()) {
            throw new NoSuchElementException();
        } else {
            return Q.get(0).element;
        }
    }



    @Override
    public boolean offer(E arg0) {
        // TODO Auto-generated method stub
        return false;
    }



    @Override
    public E peek() {
        if (Q.isEmpty()) {
            return null;
        } else {
            return Q.get(0).element;
        }
    }



    @Override
    public E poll() {
        // TODO Auto-generated method stub
        return null;
    }



    @Override
    public E remove() {
        // TODO Auto-generated method stub
        return null;
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
    
    public static void main(final String[] args) {
        PriorityQueue<String> list = new PriorityQueue<String>(20);
        list.add("This");
        list.add("is");
        list.add("a");
        list.add("test");
        
        //list.add("not", 2.5);
        //list.print();
        
        System.out.println(list.isEmpty()+"\n");
        
    }
	
}
