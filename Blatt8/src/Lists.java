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
