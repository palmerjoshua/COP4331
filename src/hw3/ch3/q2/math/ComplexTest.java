package hw3.ch3.q2.math;
import junit.framework.TestCase;

public class ComplexTest extends TestCase {

    private Complex c1, c2;

    public void setUp() throws Exception {
        super.setUp();
        c1 = new Complex(3, 2);
        c2 = new Complex(3, -2);
    }

    public void testEquals() {
        Complex c1 = new Complex(1, 2),
                c2 = new Complex(1, 2);
        assertTrue(c1.equals(c2) && c2.equals(c1));
    }

    public void testAdd() {
        Complex sum = new Complex(6);
        assertTrue(sum.equals(c1.add(c2)));
    }

    public void testSub() {
        Complex dif = new Complex(0, 4);
        assertTrue(dif.equals(c1.sub(c2)));
    }

    public void testMult() {
        Complex prod = new Complex(13);
        assertTrue(prod.equals(c1.mult(c2)));
    }

    public void testDiv() {
        Complex quot = new Complex(5.0/13.0, 12.0/13.0);
        assertTrue(quot.equals(c1.div(c2)));
    }
}
