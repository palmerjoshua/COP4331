package hw2;


import java.math.BigDecimal;
import java.util.HashMap;

public class Transaction {

    private HashMap<String, Product> items;
    private BigDecimal total;
    private BigDecimal balance;

    public Transaction(){
        items = new HashMap<String, Product>();
        total = balance = new BigDecimal(""+0.00).setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    public void addItem(Product item) {
        items.put(item.getUPC(), item);
        total = total.add(new BigDecimal(item.getPrice()));
        balance = balance.add(new BigDecimal(item.getPrice()));
    }

    public double getTotalDouble() {
        return Double.parseDouble(total.toString());
    }

    public String getTotalString(){
        return total.toString();
    }


    public double getBalanceDouble() {
        return Double.parseDouble(balance.toString());
    }

    public String getBalanceString() {
        return balance.toString();
    }

    public void addPayment(double payment) {
        balance = balance.subtract(new BigDecimal(""+payment)).setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    public boolean isUnpaid() {
        return balance.signum() == 1;
    }

    public String getSummary() {
        String summary = "";
        for(Product item : items.values()) {
            summary += "\nName: " + item.getName() + "\n";
            summary += "UPC: " + item.getUPC() + "\n";
            summary += "Price: $" + item.getPrice() + "\n";
        }
        summary += "\nTotal: $" + total.toString() + "\n";
        BigDecimal payment = total.subtract(balance);
        summary += "Payment: $" + payment.toString();
        if (getBalanceDouble() < 0.0) {
            BigDecimal change = payment.subtract(total).setScale(2, BigDecimal.ROUND_HALF_UP);
            summary += "\nChange: $" + change.toString();
        }
        return summary;
    }
}
