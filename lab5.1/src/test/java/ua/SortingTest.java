package ua;

import org.junit.jupiter.api.Test;
import ua.university.Course;
import ua.university.Student;
import ua.repository.CourseRepository;
import ua.repository.StudentRepository;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class SortingTest {

    @Test
    void studentEnrollmentSortAndCourseSortCombined() {
        StudentRepository sr = new StudentRepository();
        Student s1 = new Student("Zoe","Zimmer","S3", LocalDate.now());
        Student s2 = new Student("Anna","Aardvark","S1", LocalDate.now());
        sr.add(s1); sr.add(s2);
        sr.sortByLastName();
        assertEquals("Aardvark", sr.getAll().get(0).lastName());

        CourseRepository cr = new CourseRepository();
        cr.add(new Course("Alpha",3,1));
        cr.add(new Course("Beta",5,2));
        cr.sortByCredits();
        assertEquals(3, cr.getAll().get(0).getCredits());
    }
}
