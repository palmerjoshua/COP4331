package hw3.ch3.q2.math;

public interface ComplexNumber {
    double r();
    double i();
    Complex add(Complex c);
    Complex sub(Complex c);
    Complex conj();
    Complex mult(Complex c);
    Complex div(Complex c);
    boolean equals(Complex c);
}
