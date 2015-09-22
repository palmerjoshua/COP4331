package hw2;

import java.text.DecimalFormat;

public class Product {
    private String upc;
    private String name;
    private DecimalFormat priceFormat;
    private double price;

    public Product(String upc, String name, double price) {
        priceFormat = new DecimalFormat("#.00");
        this.upc = upc;
        this.name = name;
        this.price = price;
    }

    public Product(){
        throw new IllegalArgumentException("No product details given.");
    }

    public String getUPC() {return upc;}
    public String getName() {return name;}
    public String getPrice() {return priceFormat.format(price);}

    public String[] getProductDetails() {
        String[] details = new String[3];
        details[0] = getUPC();
        details[1] = getName();
        details[2] = getPrice();
        return details;
    }

}
