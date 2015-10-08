package hw3.ch4.q1;

import java.text.SimpleDateFormat;
import java.util.*;


public class Student {
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

    private static ArrayList<Student> getExampleStudents() {
        ArrayList<Student> students = new ArrayList<Student>();
        Calendar c1 = Calendar.getInstance(),
                 c2 = Calendar.getInstance(),
                 c3 = Calendar.getInstance(),
                 c4 = Calendar.getInstance();

        c1.set(Calendar.MONTH, Calendar.APRIL);
        c1.set(Calendar.DATE, 4);
        c1.set(Calendar.YEAR, 1994);

        c2.set(Calendar.MONTH, Calendar.JUNE);
        c2.set(Calendar.DATE, 9);
        c2.set(Calendar.YEAR, 1990);

        c3.set(Calendar.MONTH, Calendar.JANUARY);
        c3.set(Calendar.DATE, 1);
        c3.set(Calendar.YEAR, 1970);

        c4.set(Calendar.MONTH, Calendar.SEPTEMBER);
        c4.set(Calendar.DATE, 30);
        c4.set(Calendar.YEAR, 1985);

        Student s1 = new Student("Mac", c1.getTime()),
                s2 = new Student("Dennis", c2.getTime()),
                s3 = new Student("Sweet Dee", c3.getTime()),
                s4 = new Student("Charlie", c4.getTime());

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
