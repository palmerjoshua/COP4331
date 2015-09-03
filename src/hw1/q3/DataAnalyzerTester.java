package hw1.q3;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class DataAnalyzerTester {
    /**
     * Regular expression pattern that matches sequences of integers
     * separated by spaces, or the letter 'q'.
     * @see #validInput(String)
     */
    private static final Pattern inputPattern = Pattern.compile("^q$|^(\\d+ *)+$");

    /**
     * Tests a string against a regular expression.
     * @param userInput String to be tested.
     * @return True if the String matches, False if it does not match.
     * @see #inputPattern
     */
    private static boolean validInput(String userInput) {
        Matcher input_matcher = inputPattern.matcher(userInput);
        return input_matcher.matches();
    }

    /**
     * Converts a string of integers into a LinkedList of integers.
     * @param userString An already-validated string of integers.
     * @throws IllegalArgumentException if userString cannot be parsed into an int.
     * @return A LinkedList of integers.
     */
    private static LinkedList<Integer> stringToList(String userString) {
        LinkedList<Integer> result = new LinkedList<Integer>();
        String[] splitString = userString.split(" ");
        for (String s: splitString) {
            if (s.length() > 0) {
                try {
                    result.add(Integer.parseInt(s));
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("Sequence element must be integer.");
                }
            }
        }
        return result;
    }

    /**
     * Helper function to create a string for printing to the console and saving to a file.
     * @param da A DataAnalyzer whose dataList has already been populated.
     * @return A string containing the DataAnalyzer's data.
     */
    private static String[] makeOutputStrings(DataAnalyzer da) {
        String[] result = new String[4];
        result[0] = "Sequence: " + da.getSequence();
        result[1] = "Min: " + da.min();
        result[2] = "Max: " + da.max();
        result[3] = "Average: " + da.average();
        return result;
    } // todo make header for output file

    /**
     * Uses a simple cli to receive sequences of numbers from the user
     * and write data to the console and a file.
     * @param args No command line arguments are used.
     * @throws IOException If opening the output file fails.
     */
    public static void main(String[] args) throws IOException {
        LinkedList<Integer> inputList;
        DataAnalyzer da = new DataAnalyzer();
        Scanner in = new Scanner(System.in);
        PrintWriter pw;
        String[] outputStrings;

        String userInput = "";
        while (!userInput.equals("q")) {
            System.out.println("(Enter 'q' to quit)");
            System.out.print("Enter a sequence of numbers separated by spaces: ");

            userInput = in.nextLine().toLowerCase().trim();
            if (validInput(userInput)){
                if (!userInput.equals("q")) {
                    try {
                        inputList = stringToList(userInput);
                    } catch (IllegalArgumentException e2) {
                        // will never happen thanks to regex
                        System.err.println(e2.getMessage());
                        continue;
                    }
                    da.newSequence(inputList);
                    outputStrings = makeOutputStrings(da);
                    pw = new PrintWriter("q3_output.txt");
                    for (String os: outputStrings) {
                        System.out.println(os);
                        pw.println(os);
                    }
                    pw.close();
                }
            } else {
                System.out.println("INVALID INPUT");
            }
        }
    }
}
