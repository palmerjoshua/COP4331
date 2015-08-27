package hw1.q2;
/**
 A class for producing simple greetings.
 */

public class Greeter
{
    /**
     Constructs a Greeter object that can greet a person or
     entity.
     @param aName the name of the person or entity who should
     be addressed in the greetings.
     */
    public Greeter(String aName)
    {
        name = aName;
    }

    /**
     Greet with a "Hello" message.
     @return a message containing "Hello" and the name of
     the greeted person or entity.
     */
    public String sayHello()
    {
        return "Hello, " + name + "!";
    }

    public void swapNames(Greeter other) {
        String tmp = this.name;
        this.name = other.name;
        other.name = tmp;
    }

    public Greeter createQualifiedGreeter(String qualifier) {
        return new Greeter(qualifier + ' ' + this.name);
    }

    private String name;
}