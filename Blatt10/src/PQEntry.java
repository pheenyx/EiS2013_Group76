/**
 * Helper class for the PQ.
 * @author Michael Mardaus
 * @author Julian Rost
 * @since 29.06.2013
 */
class PQEntry<T , N extends Number & Comparable<N> > 
                                implements Comparable<PQEntry <T, N>>{
    public T element;
    public N prio;
    
    public PQEntry(T element, N priority){
        this.element = element;
        this.prio = priority;
    }
    

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    @Override
    public int compareTo(PQEntry<T, N> other) {
        return this.prio.compareTo(other.prio);
    }

}
