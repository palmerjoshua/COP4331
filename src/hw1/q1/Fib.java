/*
 * Joshua Palmer
 * Z: 23280034
 * COP 4331 001
 * HW1 q1 - Fib.java
 *
 * Notes:
 *  Iterative function defined on line 58
 *
 *  Recursive function defined on line 78
 *
 *  Fibonacci function calls on lines 132 and 133
 *
 *  Static helper functions are used to validate input and display output
 *
 *  https://github.com/palmerjoshua/COP4331
 *
 */
package hw1.q1;


/**
 * Takes two integers and uses them as the first two terms of a Fibonacci sequence.
 */
public class Fib {

    /** holds the first term of the sequence
     * @see #a1*/
    private int a0;
    /** holds the second term of the sequence
     * @see #a0*/
    private int a1;

    /** Initializes the first two terms of the sequence with user-given values.
     * @param first The first term of the sequence
     * @param second The second term of the sequence
     * @see #Fib() */
    public Fib(int first, int second) {
        a0 = first;
        a1 = second;
    }

    /** Initializes the first two terms of the sequence with default values of 0 and 1.
     * @see #Fib(int, int)
     */
    public Fib() {
        a0 = 0;
        a1 = 1;
    }

    /**
     * Iterative method for finding the Jth number in the Fibonacci sequence.
     * @param j the index of the desired Fibonacci number.
     * @throws IllegalArgumentException if j is negative
     * @return the Jth term of the sequence.
     * @see #fRec(int)
     */
    public int f(int j) {
        if (j < 0) throw new IllegalArgumentException("j must not be negative.");
        int tmp;
        int a = a0, b = a1;
        for (int i = 0; i < j; i++) {
            tmp = b;
            b += a;
            a = tmp;
        }
        return a;
    }

    /**
     * Recursive method for finding the Jth term of a Fibonacci sequence.
     * @param x The first term of the sequence.
     * @param y The second term of the sequence.
     * @param j The index of the desired Fibonacci number.
     * @return The Jth term of the sequence.
     * @see #fRec(int)
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

    /**
     * Public wrapper for the recursive method.
     * @param j The index of the desired Fibonacci number.
     * @return The Jth term of the sequence.
     * @see #fRec(int, int, int)
     * @see #f(int)
     */
    public int fRec(int j) {
        if (j < 0) throw new IllegalArgumentException("j must not be negative.");
        return fRec(a0, a1, j);
    }

    /**
     * Helper function that validates a command line argument
     * @param arg A command line argument
     * @throws IllegalArgumentException If arg is not an integer
     * @return The argument in integer form
     */
    private static int validateArg(String arg) {
        try {
            return Integer.parseInt(arg);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Argument must be an integer.");
        }
    }

    /**
     * Helper function that computes a Fibonacci sequence and generates a string for console output.
     * @param n The index of the last Fibonacci number to be displayed.
     * @param fib A Fib instance containing the first two numbers in the sequence.
     * @return A string containing output for both the iterative and recursive methods.
     * @throws IllegalArgumentException if n is negative
     * @see #f(int)
     * @see #fRec(int)
     */
    private static String sequenceString(int n, Fib fib) {
        if (n < 0) throw new IllegalArgumentException("n must not be negative.");

        String iterativeString = "Iterative: ",
               recursiveString = "Recursive: ";

        for (int i=0; i<=n; i++) {
            iterativeString += " " + fib.f(i);
            recursiveString += " " + fib.fRec(i);
        }
        return iterativeString + "\n" + recursiveString;
    }

    public static void main(String[] args) {
        int a0, a1, n;
        try {
            a0 = validateArg(args[0]);
            a1 = validateArg(args[1]);
             n = validateArg(args[2]);
        } catch (IndexOutOfBoundsException e1) {
            System.err.println("Please enter a0, a1, and n on the command line.");
            return;
        } catch (IllegalArgumentException e2) {
            System.err.println(e2.getMessage());
            return;
        }

        Fib fib = new Fib(a0, a1);

        try { // fib functions called on lines 132 and 133
            System.out.println(sequenceString(n, fib));
        } catch (IllegalArgumentException e3) {
            System.err.println(e3.getMessage());
        }
    }
}
