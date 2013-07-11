/**
 * Bank
 * @author Michael Mardaus
 *
 */
public class Bank {
    public static int berechneA(int input){
        int i = 0;
        while (input != 1) {
            if (input % 2 == 0) {
                input /= 2;
            } else {
                input = input * 3 + 1;
            }
            i++;
        }
        return i;
    }

}
