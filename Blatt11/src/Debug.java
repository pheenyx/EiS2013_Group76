/**
 * Debugging Class from Sheet 11.
 * 
 * @author Michael Mardaus
 * @author Julian Rost
 * @since 03.07.2013
 */
public class Debug {

    /**
     * @param args
     */
    public static int test(int start, int basis) {
        int result = start;
        int stopvalue = start;
        int shift = 0;
        int index = 0;
        do {
            if (result % basis == 0) {
                result = result / basis;
            } else {
                shift = basis - result % basis;
                result = (basis + 1) * result + shift;
            }
            if (index % 2 == 1) {
                if (stopvalue % basis == 0) {
                    stopvalue = stopvalue / basis;
                } else {
                    shift = basis - stopvalue % basis;
                    stopvalue = (basis + 1) * stopvalue + shift;
                }
            }
            System.out.println("durchlauf: "+index);
            System.out.println("start: "+start+" basis: "+basis+" result: "+result+" stopvalue: "+stopvalue);
            index++;
        } while (result != stopvalue);
        return index;
    }
    
    public static void main (String... args){
        test(13,2);
    }

}
