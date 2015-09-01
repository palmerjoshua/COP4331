package hw1.q3;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class DataAnalyzerTester {
    private static final Pattern inputPattern = Pattern.compile("^q$|^(\\d+ *)+$");

    private static boolean validInput(String userInput) {
        Matcher input_matcher = inputPattern.matcher(userInput);
        return input_matcher.matches();
    }

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

    private static String makeOutputString(DataAnalyzer da) {
        String result = "Sequence: " + da.getSequence() + "\n";
        result += "Min: " + da.min() + "\n";
        result += "Max: " + da.max() + "\n";
        result += "Average: " + da.average();
        return result;
    }

    public static void main(String[] args) {
        LinkedList<Integer> inputList;
        DataAnalyzer da = new DataAnalyzer();
        Scanner in = new Scanner(System.in);
        String userInput = "";

        while (!userInput.equals("q")) {
            System.out.println("(Press 'q' to quit)");
            System.out.print("Enter a sequence of numbers separated by spaces: ");

            userInput = in.nextLine().toLowerCase().trim();
            if (validInput(userInput)){
                if (!userInput.equals("q")) {
                    inputList = stringToList(userInput);
                    da.newSequence(inputList);
                    // todo write to file
                    System.out.println(makeOutputString(da));
                }
            } else {
                System.out.println("INVALID INPUT");
            }
        }
    }
}
