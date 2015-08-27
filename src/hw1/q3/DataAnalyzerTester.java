package hw1.q3;

import java.util.Scanner;

/**
 * Created by josh on 8/27/2015.
 */
public class DataAnalyzerTester {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String user_input = "";
        while(!user_input.equals("q")) {
            System.out.print("Enter a sequence of numbers separated by spaces: ");
            user_input = in.nextLine();
            System.out.println(user_input);
        }
    }
}
