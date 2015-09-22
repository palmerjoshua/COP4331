package hw2;


public class RegisterTester {
    public static void main(String[] args) {
        Product apple = new Product("111111111111", "apple", 0.50);
        Product banana = new Product("222222222222", "banana", 0.65);
        Product camera = new Product("333333333333", "camera", 199.99);

        Register register = new Register();
        register.addToInventory(apple);
        register.addToInventory(banana);
        register.addToInventory(camera);

        register.startNewTransaction();
    }
}
