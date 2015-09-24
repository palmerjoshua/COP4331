package hw2;

import java.math.BigDecimal;
import java.util.HashMap;

public class Transaction {
    /**
     * Stores the purchased Products as key-value pairs.
     * Key: UPC number    Value: Product
     */
    private HashMap<String, Product> items;
    private BigDecimal total, balance;

    public Transaction(){
        items = new HashMap<String, Product>();
        total = balance = new BigDecimal(""+0.00).setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    /**
     * Add a Product to be purchased.
     * @param item The Product that is purchased.
     */
    public void addItem(Product item) {
        items.put(item.getUPC(), item);
        total = total.add(new BigDecimal(item.getPrice()));
        balance = balance.add(new BigDecimal(item.getPrice()));
    }

    /**
     * Helper function to return the total as a double
     * @return a double representing the total.
     */
    public double getTotalDouble() {
        return Double.parseDouble(total.toString());
    }

    /**
     * Helper function to return the total as a String
     * @return a String representing the total.
     * @see #getTotalDouble()
     */
    public String getTotalString(){
        return total.toString();
    }

    /**
     * Helper function to get the balance as a double.
     * The balance is the total - (amount paid by customer).
     * @return double representing the amount of money
     * left to pay before the transaction is fully paid for.
     */
    public double getBalanceDouble() {
        return Double.parseDouble(balance.toString());
    }

    /**
     * Helper function to get the balance as a String.
     * @return String representing the balance.
     * @see #getBalanceDouble()
     */
    public String getBalanceString() {
        return balance.toString();
    }

    /**
     * Subtracts the payment from the balance.
     * @param payment Amount of money paid.
     */
    public void addPayment(double payment) {
        balance = balance.subtract(new BigDecimal(""+payment)).setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    /**
     * Checks whether the balance > 0
     * @return True if balance > 0 else False
     */
    public boolean isUnpaid() {
        return balance.signum() == 1;
    }

    /**
     * Returns all the relevant information to the transaction,
     * including an itemized list of the purchased Products,
     * the total price of the transaction, the amount of money
     * paid by the customer, and the change given to the customer
     * if he or she paid more than the total price.
     * @return String containing a summary of the transaction.
     */
    public String getSummary() {
        String summary = "";
        for (Product item : items.values()) {
            summary += String.join("\n", item.getDetails());
        }

        summary += "\n\nTotal: $" + getTotalString() + "\n";
        BigDecimal payment = total.subtract(balance);
        summary += "Payment: $" + payment.toString();

        if (getBalanceDouble() < 0.0) {
            BigDecimal change = payment.subtract(total).setScale(2, BigDecimal.ROUND_HALF_UP);
            summary += "\nChange: $" + change.toString();
        }
        return summary;
    }
}
