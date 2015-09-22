package hw2;

import java.math.BigDecimal;

public class Product {
    private String upc;
    private String name;
    private BigDecimal price;


    public Product(String upc, String name, double price) {
        this.upc = upc;
        this.name = name;
        this.price = new BigDecimal(""+price).setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    public String getUPC() {return upc;}
    public String getName() {return name;}
    public String getPrice() {return price.toString();}
}
