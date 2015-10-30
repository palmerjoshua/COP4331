package hw4.ch6.q2;

public class Manager extends Employee {
    public Manager(String n, int s, int b) {
        name = n; salary = s; bonus = b;
    }
    public int getSalary() {
        return salary + bonus;
    }
    public void setBonus(int bonus) {
        bonus = bonus;
    }
    public int getBonus() {
        return bonus;
    }
    private int bonus;
}
