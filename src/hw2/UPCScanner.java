/*Joshua Palmer    Z23280034
* COP 4331 001
* Homework 2 Question 4
*/
package hw2;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UPCScanner {
    /**used to get input from keyboard*/
    private Scanner scanner;

    /**regex to test valid UPC numbers, or the 'pay' button*/
    private final Pattern upcPattern = Pattern.compile("^\\d{12}$|^p$");

    public UPCScanner() {
        scanner = new Scanner(System.in);
    }

    /**
     * Checks whether a given UPC is valid.
     * @param upc UPC number to be tested
     * @return True if valid, False if invalid
     */
    private boolean validUPC(String upc) {
        Matcher matcher = upcPattern.matcher(upc);
        return matcher.matches();
    }

    /**
     * Gets input from the console and returns it
     * if it is a valid UPC number
     * @return user input if valid UPC, or empty string
     * if invalid
     */
    public String scan() {
        String result = scanner.nextLine().trim();
        return validUPC(result) ? result : "";
    }
}
