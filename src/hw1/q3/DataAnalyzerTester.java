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
     * @return A LinkedList of integers.
     */
    private static LinkedList<Integer> stringToList(String userString) {
        LinkedList<Integer> result = new LinkedList<Integer>();
        String[] splitString = userString.split(" ");
        for (String s: splitString) {
            if (s.length() > 0) {
                result.add(Integer.parseInt(s)); // no try-catch because input already validated
            }
        }
        return result;
    }

    /**
     * Helper function to create a string for printing to the console and saving to a file.
     * @param da A DataAnalyzer whose dataList has already been populated.
     * @return A string containing the DataAnalyzer's data.
     */
    private static String makeOutputString(DataAnalyzer da) {
        String result = "Sequence: " + da.getSequence() + "\n";
        result += "Min: " + da.min() + "\n";
        result += "Max: " + da.max() + "\n";
        result += "Average: " + da.average();
        return result;
    } // todo make header for output file

    public static void main(String[] args) throws IOException {
        LinkedList<Integer> inputList;
        DataAnalyzer da = new DataAnalyzer();
        Scanner in = new Scanner(System.in);
        PrintWriter pw;
        String output;

        String userInput = "";
        while (!userInput.equals("q")) {
            System.out.println("(Press 'q' to quit)");
            System.out.print("Enter a sequence of numbers separated by spaces: ");

            userInput = in.nextLine().toLowerCase().trim();
            if (validInput(userInput)){
                if (!userInput.equals("q")) {
                    inputList = stringToList(userInput);
                    da.newSequence(inputList);
                    output = makeOutputString(da);
                    pw = new PrintWriter("q3_output.txt");
                    System.out.println(output);
                    pw.println(output);
                    pw.close();
                }
            } else {
                System.out.println("INVALID INPUT");
            }
        }
    }
}
