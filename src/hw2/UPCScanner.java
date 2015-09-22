package hw2;


import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UPCScanner {
    private Scanner scanner;
    private final Pattern upcPattern = Pattern.compile("^\\d{12}$|^\\s+$");
    public UPCScanner() {
        scanner = new Scanner(System.in);
    }

    private boolean validUPC(String upc) {
        Matcher matcher = upcPattern.matcher(upc);
        return matcher.matches();
    }

    public String scan() {
        String result = scanner.nextLine().trim();
        if (validUPC(result)) {
            return result;
        }
        return "";
    }
}
