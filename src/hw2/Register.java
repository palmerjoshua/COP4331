package hw2;

import java.util.Scanner;

public class Register {
    private Inventory inventory;
    private Transaction currentTransaction;
    public UPCScanner scanner;

    public Register() {
        currentTransaction = new Transaction();
        scanner = new UPCScanner();
        inventory = new Inventory();
    }

    public void addToInventory(Product newProduct) {
        inventory.addProduct(newProduct);
    }

    public void scanItems() {
        String currentUPC = "";
        while (!currentUPC.equals("p")) {
            System.out.println("(Enter 'p' to pay)");
            System.out.print("Enter 12-digit UPC: ");

            currentUPC = scanner.scan().trim().toLowerCase();
            if (inventory.productExists(currentUPC)) {
                Product purchasedItem = inventory.getProduct(currentUPC);
                currentTransaction.addItem(purchasedItem);
            } else if (!currentUPC.equals("p")) {
                System.out.println("Item does not exist, or invalid UPC given.");
            }
        }
    }

    public void checkOut() {
        Scanner in = new Scanner(System.in);
        String userInput;
        double payment = 0.0, balance = currentTransaction.getBalanceDouble();
        while (balance > 0.0) {
            System.out.println("\nBalance: $" + currentTransaction.getBalanceString());
            System.out.print("Enter payment: ");
            userInput = in.nextLine().trim();
            try {
                payment = Double.parseDouble(userInput);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input for payment. Example: enter 1.50 to pay $1.50");
                continue;
            }
            balance = currentTransaction.addPayment(payment);
        }
    }

    void printReceipt() {
        System.out.println("\n====RECEIPT====");
        System.out.println(currentTransaction.getSummary());
    }

    public void startNewTransaction() {
        currentTransaction = new Transaction();
        scanItems();
        checkOut();
        printReceipt();
    }
}
