package hw2;

import java.util.HashMap;

public class Inventory {
    /**
     * key: UPC number
     * value: Product
     */
    private HashMap<String, Product> inventory;

    public Inventory() {
        inventory = new HashMap<String, Product>();
    }

    /**
     * Add a Product to the inventory.
     * @param product Product to be added.
     */
    void addProduct(Product product) {
        inventory.put(product.getUPC(), product);
    }

    /**
     * Get a Product from the inventory.
     * @param upc UPC number of the desired Product.
     * @return Product if it exists, null if it does not.
     */
    public Product getProduct(String upc) {
        return inventory.get(upc);
    }

    /**
     * Checks whether a Product exists in the inventory.
     * @param upc UPC of the Product to look for.
     * @return True if it exists, False if it does not.
     */
    public boolean productExists(String upc) {
        return inventory.get(upc) != null;
    }
}
