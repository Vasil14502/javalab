package ua.repository;

import org.junit.jupiter.api.Test;
import ua.university.Course;
import ua.university.Exam;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class ExamRepositoryTest {

    @Test
    void sortByIdentityDateAsc() {
        ExamRepository repo = new ExamRepository();
        Course c = new Course("C", 3, 1);
        Exam e1 = new Exam(c, LocalDate.of(2025, 2, 1), 100);
        Exam e2 = new Exam(c, LocalDate.of(2025, 1, 1), 100);
        repo.add(e1);
        repo.add(e2);

        repo.sortByIdentity("asc");
        assertTrue(repo.getAll().get(0).getDate().isBefore(repo.getAll().get(1).getDate()));
    }
}
