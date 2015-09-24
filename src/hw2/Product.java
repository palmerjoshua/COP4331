package hw2;

import java.math.BigDecimal;

public class Product {
    private String upc; // string of 12-digits
    private String name;
    private BigDecimal price; // better precision than floating point math

    /**
     * Initializes a product with the given information.
     * @param upc 12-digit UPC number, stored as a String
     * @param name product name
     * @param price product price
     */
    public Product(String upc, String name, double price) {
        this.upc = upc;
        this.name = name;
        this.price = new BigDecimal(""+price).setScale(2, BigDecimal.ROUND_HALF_UP);
    }// setScale - round everything to two decimal places, standard rounding

    /**
     * UPC getter
     * @return product UPC number
     */
    public String getUPC() {return upc;}

    /**
     * name getter
     * @return product name
     */
    public String getName() {return name;}

    /**
     * price getter
     * @return product price as a String
     */
    public String getPrice() {return price.toString();}

    /**
     * gets all product details and labels the values
     * @return an array of labeled product details
     */
    public String[] getDetails() {
        String[] details = new String[3];
        details[0] = "Name: " + name;
        details[1] = "UPC: " + upc;
        details[2] = "Price: $" + price.toString();
        return details;
    }
}
