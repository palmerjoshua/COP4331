/*Joshua Palmer    Z23280034
* COP 4331 001
* Homework 2 Question 4
*/
package hw2;

import java.util.Scanner;

public class Register {
    /**Stores records of all products*/
    private Inventory inventory;
    /**Stores record of the products currently being purchased*/
    private Transaction currentTransaction;
    /**Gets UPC number from Products*/
    private UPCScanner scanner;

    public Register() {
        currentTransaction = new Transaction();
        scanner = new UPCScanner();
        inventory = new Inventory();
    }

    /**
     * Adds a product to the inventory.
     * @param newProduct product to be added
     */
    public void addToInventory(Product newProduct) {
        inventory.addProduct(newProduct);
    }

    /**
     * Uses the UPCScanner to find items from the inventory,
     * add them to the current transaction, and display their
     * details to the console.
     */
    public void scanItems() {
        String currentUPC = "";
        Product purchasedItem;

        while (!currentUPC.equals("p")) {
            System.out.println("(Enter 'p' to pay)");
            System.out.print("Enter 12-digit UPC: ");

            currentUPC = scanner.scan().trim().toLowerCase();
            if (inventory.productExists(currentUPC)) {
                showProductDetails(currentUPC);
                purchasedItem = inventory.getProduct(currentUPC);
                currentTransaction.addItem(purchasedItem);
            } else if (!currentUPC.equals("p")) {
                System.out.println("Item does not exist, or invalid UPC given.");
            }
        }
    }

    /**
     * Helper function to display a Products details.
     * @param upc id of the Product to be displayed.
     */
    private void showProductDetails(String upc) {
        Product product = inventory.getProduct(upc);
        String[] details = product.getDetails();
        System.out.println();
        System.out.println(String.join("\n", details));
        System.out.println();
    }

    /**
     * Displays the current balance, and
     * uses a Scanner to get the payment amount.
     * @param in Scanner to allow CLI input.
     * @return The user's input String.
     */
    private String getPayment(Scanner in) {
        String amountLabel;
        if (currentTransaction.getBalanceDouble() == currentTransaction.getTotalDouble()) {
            amountLabel = "\nTotal: $";
        } else {
            amountLabel = "\nBalance: $";
        }
        System.out.println(amountLabel + currentTransaction.getBalanceString());
        System.out.print("Enter payment: ");
        return in.nextLine().trim();
    }

    /**
     * Uses a Scanner to receive payment until payment >= balance.
     */
    public void checkOut() {
        double payment;
        String userInput;
        Scanner in = new Scanner(System.in);
        while (currentTransaction.isUnpaid()) {
            userInput = getPayment(in);
            try {
                payment = Double.parseDouble(userInput);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Example: enter 1.50 to pay $1.50");
                continue;
            }
            if (payment <= 0.01) {
                System.out.println("Invalid input. Must pay >= $0.01");
            } else {
                currentTransaction.addPayment(payment);
            }

        }
    }

    /**
     * Prints an itemized receipt, including the total and the change (if any).
     */
    public void printReceipt() {
        if (currentTransaction.isUnpaid()) {
            System.out.println("Items have not been paid for. No receipt available.");
        } else {
            System.out.println("\n====RECEIPT====");
            System.out.println(currentTransaction.getSummary());
        }
    }

    /**
     * Begins a new transaction.
     */
    public void startNewTransaction() {
        currentTransaction = new Transaction();
        scanItems();
        checkOut();
        printReceipt();
    }
}
