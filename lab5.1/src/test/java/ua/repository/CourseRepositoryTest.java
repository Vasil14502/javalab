package ua.repository;

import org.junit.jupiter.api.Test;
import ua.university.Course;

import static org.junit.jupiter.api.Assertions.*;

public class CourseRepositoryTest {

    @Test
    void sortByCreditsTest() {
        CourseRepository repo = new CourseRepository();
        Course c1 = new Course("A", 5, 2);
        Course c2 = new Course("B", 3, 1);
        repo.add(c1);
        repo.add(c2);

        repo.sortByCredits();
        assertEquals(3, repo.getAll().get(0).getCredits());
    }
}
