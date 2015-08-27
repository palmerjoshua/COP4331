package hw1.q2;

public class GreeterTester
{
    public static void main(String[] args)
    {
        Greeter worldGreeter = new Greeter("World");
        Greeter joshGreeter = new Greeter("Josh");
        String worldGreeting = worldGreeter.sayHello();
        String joshGreeting = joshGreeter.sayHello();
        System.out.println(worldGreeting);
        System.out.println(joshGreeting);

        joshGreeter.swapNames(worldGreeter);
        worldGreeting = worldGreeter.sayHello();
        joshGreeting = joshGreeter.sayHello();
        System.out.println(worldGreeting);
        System.out.println(joshGreeting);

        Greeter qjosh = joshGreeter.createQualifiedGreeter("SEXY");
        String qgreeting = qjosh.sayHello();
        System.out.println(qgreeting);
    }
}

