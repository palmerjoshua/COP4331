package hw2;


import java.util.ArrayList;
import java.util.LinkedHashMap;

public class Register {
    private String mainMenu;
    private LinkedHashMap<String, Product> inventory;
    private ArrayList<Product> transactionList;
    private UPCScanner productScanner;

    public Register() {
        transactionList = new ArrayList<>();
        productScanner = new UPCScanner();
        inventory = new LinkedHashMap<>();
    }

    public void addProduct(Product newProduct) {
        inventory.put(newProduct.getUPC(), newProduct);
    }

    public void startNewTransaction() {
        String currentUPC = "";
        while (currentUPC.equals("")) {
            System.out.print("Enter 12-digit UPC: ");
            currentUPC = productScanner.scan();
            if (!currentUPC.equals(" ") && !currentUPC.equals("")) {
                Product purchasedProduct = inventory.get(currentUPC);
                if (purchasedProduct != null) {
                    transactionList.add(purchasedProduct);
                }
            }
        }

    }


}
