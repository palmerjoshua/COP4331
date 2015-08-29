package hw1.q3;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by josh on 8/27/2015.
 */




public class DataAnalyzerTester {
    private static final Pattern inputPattern = Pattern.compile("^q$|^[\\d ]+$");

    private static boolean validInput(String userInput) {
        Matcher input_matcher = inputPattern.matcher(userInput);
        return input_matcher.matches();
    }

    private static LinkedList<Integer> stringToList(String userString) {
        LinkedList<Integer> result = new LinkedList<>();
        String[] splitString = userString.split(" ");
        for (String s: splitString) {
            result.add(Integer.parseInt(s));
        }
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
            userInput = in.nextLine().toLowerCase();
            if (validInput(userInput)){
                if (!userInput.equals("q")) {
                    inputList = stringToList(userInput);
                    da.newSequence(inputList);
                    // todo write to file
                    System.out.println("Sequence: " + da.getSequence());
                    System.out.println("Min: " + da.min());
                    System.out.println("Max: " + da.max());
                    System.out.println("Average: " + da.average());
                }
            } else {
                System.out.println("INVALID INPUT");
            }
        }
    }
}
