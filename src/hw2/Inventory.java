package hw2;

import java.util.HashMap;

public class Inventory {
    private HashMap<String, Product> inventory;

    public Inventory() {
        inventory = new HashMap<String, Product>();
    }

    void addProduct(Product product) {
        inventory.put(product.getUPC(), product);
    }

    public Product getProduct(String upc) {
        return inventory.get(upc);
    }

    public boolean productExists(String upc) {
        return inventory.get(upc) != null;
    }
}
