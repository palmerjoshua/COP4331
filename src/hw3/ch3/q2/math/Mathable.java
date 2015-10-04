package hw3.ch3.q2.math;

public interface Mathable { // todo refactor name
    public double r();
    public double i();
    public Complex add(Complex c);
    public Complex sub(Complex c);
    public Complex conj();
    public Complex mult(Complex c);
    public Complex div(Complex c);
    public boolean equals(Complex c);
}
