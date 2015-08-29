package hw1.q3;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by josh on 8/27/2015.
 */




public class DataAnalyzerTester {
    private static Pattern input_pattern = Pattern.compile("^q$|^[\\d ]+$");
    private static  Matcher input_matcher;

    private static boolean validInput(String userInput) {
        input_matcher = input_pattern.matcher(userInput);
        return input_matcher.matches();
    }


    public static void main(String[] args) {
        DataAnalyzer da = new DataAnalyzer();
        Scanner in = new Scanner(System.in);
        String userInput = "";
        while (!userInput.equals("q")) {
            System.out.println("(Press 'q' to quit)");
            System.out.print("Enter a sequence of numbers separated by spaces: ");
            userInput = in.nextLine().toLowerCase();
            if (validInput(userInput)){
                if (!userInput.equals("q")) {
                    da.newSequence(userInput);
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
