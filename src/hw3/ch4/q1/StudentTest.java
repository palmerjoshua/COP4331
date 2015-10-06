package hw3.ch4.q1;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import junit.framework.TestCase;


public class StudentTest extends TestCase {

    private Student s1;
    private Calendar cal;

    public void setUp() throws Exception {
        super.setUp();
        cal = Calendar.getInstance();
        cal.set(Calendar.MONTH, Calendar.AUGUST);
        cal.set(Calendar.DATE, 17);
        cal.set(Calendar.YEAR, 2013);
        Date date = cal.getTime();
        s1 = new Student("Joshua Palmer", date);
    }

    public void testGetName() throws Exception {
        String name = s1.getName();
        assertEquals("Joshua Palmer", name);
    }

    public void testGetEnrollmentDate() throws Exception {
        Date d1 = s1.getEnrollmentDate(),
             d2 = cal.getTime();
        assertEquals(d1.getTime(), d2.getTime());
    }

    public void testGetCompByName() throws Exception {
        Student s2 = new Student("Bob Boberson", cal.getTime()),
                s3 = new Student("Harold Harrison", cal.getTime());
        ArrayList<Student> students = new ArrayList<>();
        students.add(s1);
        students.add(s3);
        students.add(s2);
        Collections.sort(students, Student.getCompByName());
        assertTrue(isSortedByName(students));
    }

    private static boolean isSortedByName(ArrayList<Student> al) {
        boolean sorted = true;
        for (int i=1; i < al.size(); i++)  {
            Student s1 = al.get(i-1),
                    s2 = al.get(i);
            if (s1.getName().compareTo(s2.getName()) > 0)
                sorted = false;
        }
        return sorted;
    }

    private static boolean isSortedByDate(ArrayList<Student> al) {
        boolean sorted = true;
        for (int i=1; i < al.size(); i++)  {
            Student s1 = al.get(i-1),
                    s2 = al.get(i);
            if (s1.getEnrollmentDate().compareTo(s2.getEnrollmentDate()) > 0)
                sorted = false;
        }
        return sorted;
    }

    public void testGetCompByDate() throws Exception {
        Calendar c2 = Calendar.getInstance(),
                 c3 = Calendar.getInstance();
        c2.set(Calendar.MONTH, Calendar.JANUARY);
        c2.set(Calendar.DATE, 1);
        c2.set(Calendar.YEAR, 2013);

        c3.set(Calendar.MONTH, Calendar.JUNE);
        c3.set(Calendar.DATE, 1);
        c3.set(Calendar.YEAR, 2013);

        Student s2 = new Student("Bob", c2.getTime()),
                s3 = new Student("Harry", c3.getTime());
        ArrayList<Student> students = new ArrayList<>();
        students.add(s1);
        students.add(s2);
        students.add(s3);
        Collections.sort(students, Student.getCompByDate());
        assertTrue(isSortedByDate(students));





    }
}