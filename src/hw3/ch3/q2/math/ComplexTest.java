package hw3.ch3.q2.math;
import junit.framework.TestCase;

public class ComplexTest extends TestCase {

    private Complex c, c2, c3;

    public void setUp() throws Exception {
        super.setUp();
        c = new Complex(20, 4);
        c2 = new Complex(0, -5);
        c3 = new Complex(-4, 0.34);
    }

    public void testAdd() {
        Complex second = new Complex(-3, -6),
                result = c.add(second);
        String resultString = result.toString();
        assertEquals("17 - 2i", resultString);
    }

    public void testSub() {
        Complex second = new Complex(1, -2),
                result = c.sub(second);
        assertEquals("19 + 6i", result.toString());
    }

    public void testEquals() {
        Complex c1 = new Complex(1, 2),
                c2 = new Complex(1, 2);
        assertTrue(c1.equals(c2) && c2.equals(c1));
    }

    public void testR() {
        assertEquals(20.0, c.r());
    }

    public void testI() {
        assertEquals(4.0, c.i());
    }

    public void testToString() {
        String   s = c.toString(),
                s2 = c2.toString(),
                s3 = c3.toString();
        String joined = String.join("|", s, s2, s3);
        String expected = "20 + 4i|-5i|-4 + 0.34i";

        assertEquals(expected, joined);
    }

    public void testMult() {
        Complex c1 = new Complex(2, 2),
                c2 = new Complex(3, -4),
                cm1 = c1.mult(c2),
                cm2 = c2.mult(c1);
        String expected = "14 - 2i|14 - 2i",
                actual = String.join("|", cm1.toString(), cm2.toString());
        assertEquals(expected, actual);
    }

    public void testDiv() {
        Complex c1 = new Complex(1, 0),
                c2 = new Complex(5, 7),
                quotient = c1.div(c2);
        String expected = "0.06757 - 0.09459i",
                actual = quotient.toString();
        assertEquals(expected, actual);
    }

    public void testConj() {
        Complex conj = c.conj();
        assertEquals("20 - 4i", conj.toString());
    }
}
