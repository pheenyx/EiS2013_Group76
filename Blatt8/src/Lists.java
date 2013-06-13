import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Some tests with different lists.
 * 
 * @author Michael Mardaus
 * @author Julian Rost
 * @since 11.06.2013
 */
public class Lists {
    final static int times = 100000;
    
    public static void main(String[] strings){
        ArrayList<Integer> arraylist = new ArrayList<Integer>();
        LinkedList<Integer> list = new LinkedList<Integer>();
        int[] bigarray = new int[2*times];
        int[] smallarray = new int[0];
        
        long start, end;
        
        //insert first 1000000 numbers
        System.out.println("Insertion of first bunch of numbers");
        start = System.currentTimeMillis();
        for (int i = 0; i < times; ++i){
//            if (i%10000==0) System.out.println(i+ " " + (System.currentTimeMillis()-start));
            arraylist.add(i);
        }
        end = System.currentTimeMillis();
        System.out.println("arraylist " + (end-start));
        
        start = System.currentTimeMillis();
        for (int i = 0; i < times; ++i){
//            if (i%10000==0) System.out.println(i+ " " + (System.currentTimeMillis()-start));
            list.add(i);
        }
        end = System.currentTimeMillis();
        System.out.println("list " + (end-start));
        
        start = System.currentTimeMillis();
        for (int i = 0; i < times; ++i){
//            if (i%10000==0) System.out.println(i+ " " + (System.currentTimeMillis()-start));
            bigarray[i] = i;
        }
        end = System.currentTimeMillis();
        System.out.println("bigarray " + (end-start));
        
        start = System.currentTimeMillis();
        for (int i = 0; i < times; ++i){
//            if (i%10000==0) System.out.println(i+ " " + (System.currentTimeMillis()-start));
            smallarray = add(smallarray, i, smallarray.length);
        }
        end = System.currentTimeMillis();
        System.out.println("smallarray " + (end-start));
        
        //end of insertion 1
        
        //insert "times" more numbers at "times/4"
        System.out.println("insertion of second bunch of numbers");
        start = System.currentTimeMillis();
        for (int i = 0; i < times; ++i){
//            if (i%10000==0) System.out.println(i+ " " + (System.currentTimeMillis()-start));
            arraylist.add(times/4, i);
        }
        end = System.currentTimeMillis();
        System.out.println("arraylist " + (end-start));
        
        start = System.currentTimeMillis();
        for (int i = 0; i < times; ++i){
//            if (i%10000==0) System.out.println(i+ " " + (System.currentTimeMillis()-start));
            list.add(times/4, i);
        }
        end = System.currentTimeMillis();
        System.out.println("list " + (end-start));
        
        start = System.currentTimeMillis();
        for (int i = 0; i < times; ++i){
//            if (i%10000==0) System.out.println(i+ " " + (System.currentTimeMillis()-start));
            bigarray[times/4] = i;
        }
        end = System.currentTimeMillis();
        System.out.println("bigarray " + (end-start));
        
        start = System.currentTimeMillis();
        for (int i = 0; i < times; ++i){
//            if (i%10000==0) System.out.println(i+ " " + (System.currentTimeMillis()-start));
            smallarray = add(smallarray, i, times/4);
        }
        end = System.currentTimeMillis();
        System.out.println("smallarray " + (end-start));
        
        //end of second insertion
        
        //removing numbers
        System.out.println("Removing first bunch of numbers");
        start = System.currentTimeMillis();
        for (int i = 0; i < times; ++i){
//            if (i%10000==0) System.out.println(i+ " " + (System.currentTimeMillis()-start));
            arraylist.remove(times/2);
        }
        end = System.currentTimeMillis();
        System.out.println("arraylist " + (end-start));
        
        start = System.currentTimeMillis();
        for (int i = 0; i < times; ++i){
//            if (i%10000==0) System.out.println(i+ " " + (System.currentTimeMillis()-start));
            list.remove(times/2);
        }
        end = System.currentTimeMillis();
        System.out.println("list " + (end-start));
        
        start = System.currentTimeMillis();
        int j = 0;
        for (j = 0; j < times; ++j){
//            if (i%10000==0) System.out.println(i+ " " + (System.currentTimeMillis()-start));
            bigarray[times/2 + j] = times + times/2 + j;
        }
        for (; j<bigarray.length;++j){
        	bigarray[j] = 0;
        }
        end = System.currentTimeMillis();
        System.out.println("bigarray " + (end-start));
        
        start = System.currentTimeMillis();
        for (int i = 0; i < times; ++i){
//            if (i%10000==0) System.out.println(i+ " " + (System.currentTimeMillis()-start));
            smallarray = remove(smallarray, times/2);
        }
        end = System.currentTimeMillis();
        System.out.println("smallarray " + (end-start));
        
        //end of removing
        
        //read the rest
        System.out.println("reading the numbers");
        start = System.currentTimeMillis();
        for (int i = 0; i < times; ++i){
//            if (i%10000==0) System.out.println(i+ " " + (System.currentTimeMillis()-start));
            arraylist.get(i);
        }
        end = System.currentTimeMillis();
        System.out.println("arraylist " + (end-start));
        
        start = System.currentTimeMillis();
        for (int i = 0; i < times; ++i){
//            if (i%10000==0) System.out.println(i+ " " + (System.currentTimeMillis()-start));
            list.get(i);
        }
        end = System.currentTimeMillis();
        System.out.println("list " + (end-start));
        
        start = System.currentTimeMillis();
        int readVariable;
        for (int i = 0; i < times; ++i){
//            if (i%10000==0) System.out.println(i+ " " + (System.currentTimeMillis()-start));
            readVariable=bigarray[i];
        }
        end = System.currentTimeMillis();
        System.out.println("bigarray " + (end-start));
        
        start = System.currentTimeMillis();
        for (int i = 0; i < times; ++i){
//            if (i%10000==0) System.out.println(i+ " " + (System.currentTimeMillis()-start));
            readVariable = smallarray[i];
        }
        end = System.currentTimeMillis();
        System.out.println("smallarray " + (end-start));
        
        //end of reading
        
        //setting some values
        System.out.println("setting some new values in");
        start = System.currentTimeMillis();
        for (int i = 0; i < times; ++i){
//            if (i%10000==0) System.out.println(i+ " " + (System.currentTimeMillis()-start));
            arraylist.set(i, i);
        }
        end = System.currentTimeMillis();
        System.out.println("arraylist " + (end-start));
        
        start = System.currentTimeMillis();
        for (int i = 0; i < times; ++i){
//            if (i%10000==0) System.out.println(i+ " " + (System.currentTimeMillis()-start));
            list.set(i, i);
        }
        end = System.currentTimeMillis();
        System.out.println("list " + (end-start));
        
        start = System.currentTimeMillis();
        for (int i = 0; i < times; ++i){
//            if (i%10000==0) System.out.println(i+ " " + (System.currentTimeMillis()-start));
            bigarray[i] = i;
        }
        end = System.currentTimeMillis();
        System.out.println("bigarray " + (end-start));
        
        start = System.currentTimeMillis();
        for (int i = 0; i < times; ++i){
//            if (i%10000==0) System.out.println(i+ " " + (System.currentTimeMillis()-start));
            smallarray[i] = i;
        }
        end = System.currentTimeMillis();
        System.out.println("smallarray " + (end-start));
        
//        smallarray = add(smallarray, 23, 0);
//        for (int i = 0; i < smallarray.length; ++i){
//            System.out.println(smallarray[i]);
//        }
//        smallarray = add(smallarray, 21, 0);
//        for (int i = 0; i < smallarray.length; ++i){
//            System.out.println(smallarray[i]);
//        }
//        smallarray = add(smallarray, 22, 1);
//        for (int i = 0; i < smallarray.length; ++i){
//            System.out.println(smallarray[i]);
//        }
//        
//        smallarray = remove(smallarray, 2);
//        for (int i = 0; i < smallarray.length; ++i){
//            System.out.println(smallarray[i]);
//        }
        
    }
    
    public static int[] add(int[] A, int n, int index){
        int size = A.length;
        if (index > size) System.err.println("index zu hoch");
        int[] B = new int[size+1];
        int i;
        for (i = 0; i < index; ++i){
            B[i] = A[i];
        }
        B[index] = n;
        int j = i;
        for (; i < size; ++i){
            B[++j] = A[i];
        }
        return B;
    }
    
    public static int[] remove(int[] A, int index){
        int size = A.length;
        if (index > size) System.err.println("index zu hoch");
        int[] B = new int[size-1];
        int i;
        for (i = 0; i < index; ++i){
            B[i] = A[i];
        }
        int j = i;
        for (i++; i < size; ++i){
            B[j++] = A[i];
        }
        return B;
    }
}
