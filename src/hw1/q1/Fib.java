package hw1.q1;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Joshua Palmer
 * Takes two integers and uses them as the first two terms of a Fibonacci sequence.*/
public class Fib {

    /** holds the first term of the sequence
     * @see #a1*/
    private int a0;
    /** holds the second term of the sequence
     * @see #a0*/
    private int a1;

    /** Initializes the first two terms of the sequence with user-given values.
     * @param first The first term of the sequence
     * @param second The second term of the sequence*/
    public Fib(int first, int second) {
        a0 = first;
        a1 = second;
    }

    /** Initializes the first two terms of the sequence with default values of 0 and 1.
     */
    public Fib() {
        a0 = 0;
        a1 = 1;
    }

    /** Iterative method for finding the Jth number in the Fibonacci sequence.
     *
     * @param j the index of the desired Fibonacci number.
     * @return the Jth term of the sequence.
     */
    public int f(int j) {
        if (j < 0) throw new IllegalArgumentException("j must not be negative.");
        int tmp;
        int a = a0, b = a1;
        for (int i = 0; i < j; i++) {
            tmp = b;
            b += a;
            if (i+1<=j)
                a = tmp;
        }
        return a;
    }

    /** Recursive method for finding the Jth term of a Fibonnaci sequence.
     *
     * @param x The first term of the sequence.
     * @param y The second term of the sequence.
     * @param j The index of the desired Fibonacci number.
     * @return The Jth term of the sequence.
     */
    private int fRec(int x, int y, int j) {
        int a = x, b = y;
        int tmp;
        if (j >= 1) {
            tmp = b;
            b += a;
            a = tmp;
            return fRec(a, b, j-1);
        }
        return a;
    }

    /** Public wrapper for the recursive method.
     *
     * @param j The index of the desired Fibonacci number.
     * @return The Jth term of the sequence.
     */
    public int fRec(int j) {
        if (j < 0) throw new IllegalArgumentException("j must not be negative.");
        return this.fRec(a0, a1, j);
    }

    /** Validates the command line arguments
     *
     * @param arg A command line argument.
     * @return The argument as an int, or a default value of 1.
     */
    private static int validateArg(String arg) {
        int result = 1;
        try {
            result = Integer.parseInt(arg);
        } catch (NumberFormatException e) {
            System.err.println("Invalid argument: " + arg);
            System.err.println("Defaulting to: " + result);
        }
        return result;
    }

    /** Computes the Fibonnaci sequence and generates a string for console output.
     *
     * @param n The index of the last Fibonacci number to be displayed.
     * @param fib A Fib instance containing the first two numbers in the sequence.
     * @return A string containing output for both the iterative and recursive methods.
     */
    private static String sequenceString(int n, Fib fib) {
        if (n < 0) throw new IllegalArgumentException("n must not be negative.");

        int fibResult;
        String iterativeString = "Iterative: ",
               recursiveString = "Recursive: ";

        for(int i=0; i<=n; i++) {
            fibResult = fib.f(i);
            iterativeString = String.format("%s %d", iterativeString, fibResult);

            fibResult = fib.fRec(i);
            recursiveString = String.format("%s %d", recursiveString, fibResult);

        } return iterativeString + "\n" + recursiveString;
    }

    public static void main(String[] args) {
        int f0, f1, n;
        f0 = validateArg(args[0]);
        f1 = validateArg(args[1]);
         n = validateArg(args[2]);

        Fib fib = new Fib(f0, f1);

        try {
            System.out.println(sequenceString(n, fib));
        } catch (IllegalArgumentException e) {
            System.err.println("n must not be negative.");
        }
    }
}
