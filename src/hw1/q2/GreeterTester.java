package hw1.q2;

public class GreeterTester
{

    private static void printGreetings(Greeter g1, Greeter g2) {
        System.out.println(g1.sayHello());
        System.out.println(g2.sayHello() + "\n");
    }

    public static void main(String[] args)
    {
        Greeter worldGreeter = new Greeter("World");
        Greeter joshGreeter = new Greeter("Josh");
        printGreetings(worldGreeter, joshGreeter);

        joshGreeter.swapNames(worldGreeter);
        printGreetings(worldGreeter, joshGreeter);

        Greeter qJosh = joshGreeter.createQualifiedGreeter("The Honorable ");
        System.out.println(qJosh.sayHello());
    }
}

