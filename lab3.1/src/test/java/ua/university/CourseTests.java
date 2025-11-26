package ua.university;

import ua.util.InvalidDataException;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class CourseTests {

    @Test
    void testCourseCreation() throws InvalidDataException {
        Course c = new Course("Programming", 5, 1);

        assertEquals("Programming", c.getTitle());
        assertEquals(5, c.getCredits());
        assertEquals(1, c.getSemester());

        System.out.println("Course created: " + c.getTitle() + ", Credits: " + c.getCredits() + ", Semester: " + c.getSemester());
    }

    @Test
    void testInvalidCourseCredits() {
        Exception ex = assertThrows(InvalidDataException.class, () -> new Course("Math", -3, 1));
        System.out.println("Caught expected exception: " + ex.getMessage());
    }

    @Test
    void testCourseFactoryMethod() throws InvalidDataException {
        Course c = Course.createBasic("Databases");
        assertEquals("Databases", c.getTitle());
        assertEquals(3, c.getCredits());
        assertEquals(1, c.getSemester());

        System.out.println("Course (factory) created: " + c.getTitle());
    }
}
