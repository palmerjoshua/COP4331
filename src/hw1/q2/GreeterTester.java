/*
 * Joshua Palmer
 * Z: 23280034
 * COP 4331 001
 * HW1 q2 - GreeterTester.java
 *
 * https://github.com/palmerjoshua/COP4331
 *
 */
package hw1.q2;

public class GreeterTester
{
    /**
     * Helper function for printing greetings.
     * @param g1 first greeter whose greeting will be printed.
     * @param g2 second greeter whose greeting will be printed.
     */
    private static void printGreetings(Greeter g1, Greeter g2) {
        System.out.println(g1.sayHello());
        System.out.println(g2.sayHello() + "\n");
    }

    public static void main(String[] args)
    {
        Greeter worldGreeter = new Greeter("World");
        Greeter joshGreeter = new Greeter("Josh");

        printGreetings(worldGreeter, joshGreeter);
        worldGreeter.swapNames(joshGreeter);
        printGreetings(worldGreeter, joshGreeter);

        Greeter qualified = worldGreeter.createQualifiedGreeter("Squeaky");
        System.out.println(qualified.sayHello());
    }
}

