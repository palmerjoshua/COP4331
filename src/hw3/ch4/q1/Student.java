package hw3.ch4.q1;

import java.util.ArrayList;
import java.util.Date;


public class Student { // todo implement comparators
    private String name;
    private Date enrollmentDate;

    public Student(String name, Date enrollmentDate) {
        this.name = name;
        this.enrollmentDate = new Date(enrollmentDate.getTime());
    }

    public String getName() {return name;}

    public Date getEnrollmentDate() {
        return new Date(enrollmentDate.getTime());
    }

    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        // todo sort by name, print output
        // todo sort by date, print output
    }
}
