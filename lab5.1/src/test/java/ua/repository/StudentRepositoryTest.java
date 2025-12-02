package ua.repository;

import org.junit.jupiter.api.Test;
import ua.university.Student;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class StudentRepositoryTest {

    @Test
    void sortByLastNameTest() {
        StudentRepository repo = new StudentRepository();
        Student s1 = new Student("Bob", "Johnson", "S1", LocalDate.now());
        Student s2 = new Student("Alice", "Adams", "S2", LocalDate.now());
        repo.add(s1);
        repo.add(s2);

        repo.sortByLastName();

        assertEquals("Adams", repo.getAll().get(0).lastName());
    }

    @Test
    void sortByIdentityAscTest() {
        StudentRepository repo = new StudentRepository();
        Student s1 = new Student("B", "X", "S2", LocalDate.now());
        Student s2 = new Student("A", "Y", "S1", LocalDate.now());
        repo.add(s1);
        repo.add(s2);

        repo.sortByIdentity("asc");
        assertEquals("S1", repo.getAll().get(0).studentId());
    }
}
