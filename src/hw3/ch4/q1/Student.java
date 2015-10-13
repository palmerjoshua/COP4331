package hw3.ch4.q1;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Represents a school student with a name and an enrollment date.
 * Class invariant: name != null && enrollmentDate != null
 */
public class Student {
    private String name;
    private Date enrollmentDate;

    public Student(String name, Date whenEnrolled) {
        this.name = name;
        this.enrollmentDate = new Date(whenEnrolled.getTime());
    }

    /**
     * Accessor for the Student's name
     * @return String containing the name
     * precondition: name != null
     * postcondition: none
     */
    public String getName() {return name;}

    /**
     * Accessor for the Student's enrollment date
     * @return Date object corresponding to the enrollment date
     * precondition: enrollmentDate != null
     * postcondition: none
     */
    public Date getEnrollmentDate() {
        return new Date(enrollmentDate.getTime());
    }

    /**
     * Provides a Comparator for sorting methods to use to
     * sort Students by their names.
     * @return 0 if both Students' names are lexicographically
     * equivalent, -1 if the second Student's name is lexicographically
     * greater than the first, or 1 if the second Student's name is
     * lexicographically less than the first.
     * precondition: name != null
     * postcondition: none
     */
    public static Comparator<Student> getCompByName() {
        return new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return s1.getName().compareTo(s2.getName());
            }
        };
    }

    /**
     * Provides a Comparator for sorting methods to use to
     * sort Students by their enrollment dates.
     * @return 0 if both Students enrolled on the same date,
     * -1 if the second Student enrolled after the first,
     * or 1 if the second Student enrolled before the first.
     * precondition: enrollmentDate != null
     */
    public static Comparator<Student> getCompByDate() {
        return new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return s1.getEnrollmentDate().compareTo(s2.getEnrollmentDate());
            }
        };
    }

    /**
     * Helper function to create a Student
     * @param name Student's name
     * @param month Month in which the Student enrolled
     * @param day Day on which the Student enrolled
     * @param year Year on which the Student enrolled
     * @return Student
     */
    private static Student createExampleStudent(String name, int month, int day, int year) {
        Calendar c = Calendar.getInstance();
        c.set(year, month, day);
        return new Student(name, c.getTime());
    }

    /**
     * Helper function to create a collection of Students for the example in main()
     * @return ArrayList of Student
     */
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
