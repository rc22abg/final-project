import org.junit.Test;
import static org.junit.Assert.*;

public class FitnessClubTest {

    @Test
    public void testAddLesson() {
        FitnessClub fitnessClub = new FitnessClub();
        Lesson spin = new Lesson("Spin", 5, "Saturday", "9:00 AM");
        assertTrue(fitnessClub.addLesson(spin));
    }

    @Test
    public void testAddLesson_Duplicate() {
        FitnessClub fitnessClub = new FitnessClub();
        Lesson spin = new Lesson("Spin", 5, "Saturday", "9:00 AM");
        fitnessClub.addLesson(spin);
        assertFalse(fitnessClub.addLesson(spin));
    }

    @Test
    public void testBookLesson() {
        FitnessClub fitnessClub = new FitnessClub();
        Lesson spin = new Lesson("Spin", 5, "Saturday", "9:00 AM");
        fitnessClub.addLesson(spin);
        assertTrue(fitnessClub.bookLesson(spin));
    }

    @Test
    public void testBookLesson_NoAvailableSpots() {
        FitnessClub fitnessClub = new FitnessClub();
        Lesson spin = new Lesson("Spin", 0, "Saturday", "9:00 AM");
        fitnessClub.addLesson(spin);
        assertFalse(fitnessClub.bookLesson(spin));
    }

    @Test
    public void testViewTimetable() {
        FitnessClub fitnessClub = new FitnessClub();
        Lesson spin = new Lesson("Spin", 5, "Saturday", "9:00 AM");
        Lesson yoga = new Lesson("Yoga", 5, "Saturday", "10:00 AM");
        fitnessClub.addLesson(spin);
        fitnessClub.addLesson(yoga);

        // Test viewing timetable
        String expectedOutput = "Spin on Saturday at 9:00 AM (5 spots available)\n" +
                                "Yoga on Saturday at 10:00 AM (5 spots available)\n";
        assertEquals(expectedOutput, fitnessClub.viewTimetable());
    }
}
