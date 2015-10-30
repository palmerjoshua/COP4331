package hw4.ch6.q2;

public class EmployeeTester {
    public static void main(String[] args) {
        Employee josh = new Employee("josh", 20000) {
            @Override
            public int getSalary() {
                return salary;
            }
        };
        Manager john = new Manager("john", 50000, 10000);
        System.out.println(john.toString());
        System.out.println(josh.toString());
    }
}
