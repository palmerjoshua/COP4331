package hw3.q2.math;
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
        Complex identical = new Complex(c.r(), c.i());
        assertTrue(c.equals(identical) && identical.equals(c));
    }

    public void testR() {
        assertEquals(20.0, c.r());
    }

    public void testI() {
        assertEquals(4.0, c.i());
    }

    public void testToString() {
        String   s = this.c.toString(),
                s2 = this.c2.toString(),
                s3 = this.c3.toString();
        String joined = String.join("|", s, s2, s3);
        String expected = "20 + 4i|-5i|-4 + 0.34i";

        assertEquals(expected, joined);
    }

    public void testConj() {
        Complex conj = c.conj();
        assertEquals("20 - 4i", conj.toString());
    }
}
