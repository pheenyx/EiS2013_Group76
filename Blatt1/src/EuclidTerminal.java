import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Calculates the greatest common divisor of two integers in two differnt ways.
 * 1. by subtraction and 2. by division (mod)
 *
 * @author Michael Mardaus
 *
 */
public class EuclidTerminal {
    
    public static int modCounter = 0;
    public static int minCounter = 0;

    /**
     * Calculate the gcd of two ints by division.
     *
     * @param p
     *            first int
     * @param q
     *            second int
     * @return the gcd of p and q
     * @throws Exception if q or p is negative
     */
    public static int modulo(final int p, final int q) throws Exception {
        modCounter++;
        System.out.println("\np = " + p + ", q = " + q);
        if (p < 0 || q < 0) {
            throw new Exception("numbers must be non-negative");
        }

        if (q == 0) {
            return p;
        } else if (p == 0) {
            return q;
        } else if (p > q) {
            return modulo(q, p % q);
        } else {
            return modulo(p, q % p);
        }
        // also works like this
        // if (q == 0) {
        //     return p;
        // }
        // return modulo(q, p % q);
    }

    /**
     * Calculate the gcd of two ints by subtraction.
     *
     * @param p
     *            first int
     * @param q
     *            second int
     * @return the gcd of p and q
     * @throws Exception if q or p is negative
     */
    public static int minus(final int p, final int q) throws Exception {
        minCounter++;
        System.out.println("\np = " + p + ", q = " + q);
        if (p < 0 || q < 0) {
            throw new Exception("numbers must be non-negative");
        }

        if (q == 0) {
            return p;
        } else if (p == 0) {
            return q;
        } else if (p == q) {
            return p;
        } else if (p > q) {
            return minus(p - q, q);
        } else {
            return minus(q - p, p);
        }
    }

    /**
     * The main function.
     *
     * @param args
     *            commandline arguments
     */
    public static void main(final String[] args) {
        Scanner s = new Scanner(System.in);
        int first = 832040;
        int second = 514229;

        System.out.println("Please enter two integers:");
        try {
            first = s.nextInt();
            second = s.nextInt();
            s.close();
        } catch (InputMismatchException e) {
            System.err.println("Error: Input is not an Integer - resuming with sample values...");
        } finally {
            s.close();
        }

        System.out.println("\na = " + first + ", b = " + second);
        long time = System.nanoTime();
        try {
            System.out.println("gcd-mod = " + modulo(first, second));
        } catch (Exception e) {
            System.err.println("Please enter non-negative numbers");
            e.printStackTrace();
        }
        System.out.println("time [ns]: " + (System.nanoTime() - time));
        time = System.nanoTime();
        System.out.println("steps: " + modCounter);
        
        System.out.println();
        
        try {
            System.out.println("gcd-min = " + minus(first, second));
        } catch (Exception e) {
            System.err.println("Please enter non-negative numbers");
            e.printStackTrace();
        }
        System.out.println("time [ns]: " + (System.nanoTime() - time));
        System.out.println("steps: " + minCounter);
    }
}
