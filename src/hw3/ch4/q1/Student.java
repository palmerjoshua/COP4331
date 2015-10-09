package hw3.ch4.q1;

import java.text.SimpleDateFormat;
import java.util.*;


public class Student { // TODO javadocs: write contracts, pre- and postconditions, class invariant
    private String name;
    private Date enrollmentDate;

    public Student(String name, Date whenEnrolled) {
        this.name = name;
        this.enrollmentDate = new Date(whenEnrolled.getTime());
    }

    public String getName() {return name;}

    public Date getEnrollmentDate() {
        return new Date(enrollmentDate.getTime());
    }

    public static Comparator<Student> getCompByName() {
        return new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return s1.getName().compareTo(s2.getName());
            }
        };
    }

    public static Comparator<Student> getCompByDate() {
        return new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return s1.getEnrollmentDate().compareTo(s2.getEnrollmentDate());
            }
        };
    }


    private static Student createExampleStudent(String name, int month, int day, int year) {
        Calendar c = Calendar.getInstance();
        c.set(year, month, day);
        return new Student(name, c.getTime());
    }

    private static ArrayList<Student> getExampleStudents() {
        ArrayList<Student> students = new ArrayList<Student>();
        Student s1 = createExampleStudent("McDonald, Ronald", Calendar.APRIL, 4, 1994),
                s2 = createExampleStudent("Reynolds, Dennis", Calendar.JUNE, 9, 1990),
                s3 = createExampleStudent("Reynolds, Deandra", Calendar.JANUARY, 1, 1970),
                s4 = createExampleStudent("Kelly, Charlie", Calendar.SEPTEMBER, 30, 1985);

        students.add(s1);
        students.add(s2);
        students.add(s3);
        students.add(s4);
        return students;
    }

    public static void main(String[] args) {
        ArrayList<Student> students = getExampleStudents();
        SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");

        System.out.println("====ORIGINAL====");
        for (Student s: students) {
            System.out.println(s.getName());
            System.out.println(df.format(s.getEnrollmentDate()));
        }

        System.out.println("====BY NAME====");
        Collections.sort(students, Student.getCompByName());
        for (Student s: students) {
            System.out.println(s.getName());
            System.out.println(df.format(s.getEnrollmentDate()));
        }

        System.out.println("====BY DATE====");
        Collections.sort(students, Student.getCompByDate());
        for (Student s: students) {
            System.out.println(s.getName());
            System.out.println(df.format(s.getEnrollmentDate()));
        }
    }
}
