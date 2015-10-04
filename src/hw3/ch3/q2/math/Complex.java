package hw3.ch3.q2.math;


import java.text.DecimalFormat;

public class Complex implements Mathable {
    private double real, imaginary;
    private final DecimalFormat format = new DecimalFormat("0.#####");

    public Complex(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }
    public Complex(double real) {
        this.real = real;
        this.imaginary = 0.0;
    }

    public Complex conj() {
        return new Complex(real, -imaginary);
    }

    public Complex add(Complex c2) {
        return new Complex(this.real+c2.real, this.imaginary+c2.imaginary);
    }

    public Complex sub(Complex c2) {
        return new Complex(this.real-c2.real, this.imaginary-c2.imaginary);
    }

    public Complex mult(Complex c2) {
        double newReal = (real * c2.r()) - (imaginary * c2.i()),
               newImag = (real * c2.i()) + (imaginary * c2.r());
        return new Complex(newReal, newImag);
    }

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

    public double r() {
        return real;
    }

    public  double i() {
        return imaginary;
    }

    private String realString() {
        return (real!=0) ? format.format(real) : "";
    }

    private String sepString() {
        return (imaginary != 0 && real != 0) ? ((imaginary > 0) ? " + " : " - ") : "";
    }

    private String imaginaryString() {
        if (imaginary == 0.0) {
            return "";
        } else if (real == 0.0) {
            return format.format(imaginary) + "i";
        } else {
            return ((imaginary > 0) ? format.format(imaginary) : format.format(-imaginary)) + "i";
        }
    }

    public String toString() {
        return realString() + sepString() + imaginaryString();
    }

    public boolean equals(Complex c2) {
        return real == c2.real && imaginary == c2.imaginary;
    }

    public static void main(String[] args) {
        Complex c1 = new Complex(2, 4),
                c2 = new Complex(-1, 5.3),
                c3 = new Complex(0.0, -5.1);
        System.out.println(c1.toString());
        System.out.println(c2.toString());
        System.out.println(c3.toString());
    }
}
