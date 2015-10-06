package hw3.ch4.q1;

import java.util.*;


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
        ArrayList<Student> students = new ArrayList<>();
        Calendar c1 = Calendar.getInstance(),
                c2 = Calendar.getInstance(),
                c3 = Calendar.getInstance();
        c1.set(Calendar.MONTH, Calendar.JANUARY, Calendar.DATE, 1, Calendar.YEAR, 1970);
        c2.set(Calendar.MONTH, Calendar.JUNE, Calendar.DATE, 9, Calendar.YEAR, 1990);
        c3.set(Calendar.MONTH, Calendar.APRIL, Calendar.DATE, 4, Calendar.YEAR, 1994);

        Student s1 = new Student("John S", c1.getTime()),
                s2 = new Student("Joshua P", c2.getTime()),
                s3 = new Student("Natasha B", c3.getTime());
        students.add(s1);
        students.add(s2);
        students.add(s3);
        return students;
    }

    public static void main(String[] args) {
        ArrayList<Student> students = getExampleStudents();
        Collections.sort(students, Student.getCompByName());
        for (Student s: students) {
            System.out.println(s.getName());
            System.out.println(s.getEnrollmentDate().toString());
        }
        System.out.println();
        Collections.sort(students, Student.getCompByDate());
        for (Student s: students) {
            System.out.println(s.getName());
            System.out.println(s.getEnrollmentDate().toString());
        }
    } // todo check why date defaults to 05 for all students
}
