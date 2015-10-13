package hw3.ch3.q2.math;
import java.text.DecimalFormat;

/**
 * Represents a complex number with two doubles:
 * one to represent the real part, and the other
 * to represent the imaginary part (the coefficient of i).
 */
public class Complex implements Mathable {
    private double real, imaginary;
    private final DecimalFormat format = new DecimalFormat("0.###");

    public Complex(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public Complex(double real) {
        this.real = real;
        this.imaginary = 0.0;
    }

    /**
     * Computes the complex conjugate of the instantiated Complex.
     * @return a Complex with the same real part and a negative
     * imaginary part.
     */
    public Complex conj() {
        return new Complex(real, -imaginary);
    }

    /**
     * Computes the sum of two complex numbers.
     * @param c2 The second Complex in the equation.
     * @return a Complex representing the sum of two
     * Complexes.
     */
    public Complex add(Complex c2) {
        return new Complex(this.real+c2.real, this.imaginary+c2.imaginary);
    }

    /**
     * Computes the difference between two complex numbers.
     * @param c2 a Complex representing the subtrahend.
     * @return a Complex representing the difference.
     */
    public Complex sub(Complex c2) {
        return new Complex(this.real-c2.real, this.imaginary-c2.imaginary);
    }

    /**
     * Computes the product of two complex numbers.
     * @param c2 a Complex representing the multiplier.
     * @return a Complex representing the product.
     */
    public Complex mult(Complex c2) {
        double newReal = (real * c2.r()) - (imaginary * c2.i()),
               newImag = (real * c2.i()) + (imaginary * c2.r());
        return new Complex(newReal, newImag);
    }

    /**
     * Computes the quotient of two complex numbers.
     * @param c2 a Complex representing the divisor.
     * @return a Complex representing the quotient.
     * @throws IllegalArgumentException if the divisor
     * is zero.
     */
    public Complex div(Complex c2) {
        if (c2.r() == 0.0 && c2.i() == 0.0) {
            throw new IllegalArgumentException("Attempted to divide by zero.");
        }
        Complex denominatorConjugate = c2.conj(),
                numerator = mult(denominatorConjugate),
                denominator = c2.mult(denominatorConjugate);
        double newReal = numerator.r() / denominator.r(),
               newImag = numerator.i() / denominator.r();
        return new Complex(newReal, newImag);
    }

    /**
     * Computes the real part of a complex number.
     * @return a double representing the real part.
     */
    public double r() {
        return real;
    }

    /**
     * Computes the imaginary part of a complex number.
     * @return a double representing the coefficient of i.
     */
    public  double i() {
        return imaginary;
    }

    /**
     * Helper function that converts the real part of
     * a complex number into a String
     * @return a String containing the real number if
     * it is not zero, or an empty String if the real
     * number is zero.
     */
    private String realString() {
        return (real!=0) ? format.format(real) : "";
    }

    /**
     * Helper function that returns a '+', '-', or an
     * empty String based on the contents of this.real
     * and this.imaginary.
     * @return a String containing an operator, or an empty String.
     */
    private String sepString() {
        return (imaginary != 0 && real != 0) ? ((imaginary > 0) ? " + " : " - ") : "";
    }

    /**
     * Helper function that formats the imaginary part
     * of a complex number into a readable String.
     * @return a String representing the imaginary
     * part of a complex number.
     */
    private String imaginaryString() {
        if (imaginary == 0.0) {
            return "";
        } else if (real == 0.0) {
            return format.format(imaginary) + "i";
        } else {
            return ((imaginary > 0) ? format.format(imaginary) : format.format(-imaginary)) + "i";
        }
    }

    /**
     * Converts a Complex into a human-readable String.
     * @return String representing this.
     */
    public String toString() {
        return realString() + sepString() + imaginaryString();
    }

    /**
     * Determines whether two Complexes are equivalent.
     * @param c2 The second Complex to compare to this.
     * @return True if they are equal, False if they are
     * unequal.
     */
    public boolean equals(Complex c2) {
        return real == c2.real && imaginary == c2.imaginary;
    }

    public static void main(String[] args) {
        Complex c1 = new Complex(3, 2),
                c2 = new Complex(3, -2);

        Complex sum        = c1.add(c2),
                difference = c1.sub(c2),
                product    = c1.mult(c2),
                quotient   = c1.div(c2),
                conjugate  = c1.conj();

        String[] strings = {
                String.format("(%s) + (%s) = %s", c1.toString(), c2.toString(), sum.toString()),
                String.format("(%s) - (%s) = %s", c1.toString(), c2.toString(), difference.toString()),
                String.format("(%s) * (%s) = %s", c1.toString(), c2.toString(), product.toString()),
                String.format("(%s) / (%s) = %s", c1.toString(), c2.toString(), quotient.toString()),
                String.format("Conjugate of (%s) is (%s)", c1.toString(), conjugate.toString())
        };

        for (String s : strings) {
            System.out.println(s);
        }
    }
}
