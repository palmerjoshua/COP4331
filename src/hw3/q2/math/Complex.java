package hw3.q2.math;


import java.text.DecimalFormat;

public class Complex {
    private double real, imaginary;
    private final DecimalFormat format = new DecimalFormat("0.#####");

    public Complex(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }
    public Complex(double real) { // todo must implement interface
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

    public double r() {
        return real;
    }

    public  double i() {
        return imaginary;
    }

    public String toString() {
        String formattedReal = format.format(real);
        String sep = (imaginary > 0) ? " + " : " - ";
        String formattedImaginary = (imaginary > 0) ? format.format(imaginary) : format.format(-imaginary);
        return formattedReal + ((imaginary!=0) ? sep + formattedImaginary + "i" : "");
    }

    public boolean equals(Complex c2) {
        return real == c2.real && imaginary == c2.imaginary;
    }
}
