package hw4.ch6.q2;

public abstract class Employee {

    public Employee() {
        name = ""; salary = 0;
    }
    public Employee(String n, int s) {
        name = n; salary = s;
    }
    public void setSalary(int s) {
        salary = s;
    }
    public void setName(String n) {
        name = n;
    }
    public String getName() {
        return name;
    }

    public abstract int getSalary();

    public String toString() {
        return    "        Name: " + name   + "\n"
                + " Base Salary: " + salary + "\n"
                + "Total Salary: " + getSalary();
    }

    protected String name;
    protected int salary;
}
