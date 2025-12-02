package ua.repository;

import org.junit.jupiter.api.Test;
import ua.university.Course;
import ua.university.Enrollment;
import ua.university.Student;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class EnrollmentRepositoryTest {

    @Test
    void comparatorsByStudentLastName() {
        Enrollment e1 = new Enrollment(new Student("A","Alpha","S1", LocalDate.now()), new Course("C1",3,1), LocalDate.now());
        Enrollment e2 = new Enrollment(new Student("B","Beta","S2", LocalDate.now()), new Course("C1",3,1), LocalDate.now());

        assertTrue(Enrollment.Comparators.BY_STUDENT_LASTNAME.compare(e1, e2) < 0);
    }
}
