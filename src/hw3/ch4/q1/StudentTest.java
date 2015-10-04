package hw3.ch4.q1;
import java.util.Calendar;
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
}