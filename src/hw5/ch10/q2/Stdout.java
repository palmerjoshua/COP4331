package hw5.ch10.q2;
import java.io.PrintStream;

public class Stdout {

    public static void main(String[] args) {
        Stdout out = Stdout.getInstance();
        out.printLine("Hello, world!");
    }

    public void printLine(String s) {
        stream.println(s);
    }

    public static Stdout getInstance() {
        return instance;
    }

    private Stdout() {
        stream = System.out;
    }

    private PrintStream stream;
    private static Stdout instance = new Stdout();
}
