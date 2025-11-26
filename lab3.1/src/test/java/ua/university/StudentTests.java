package ua.university;


import ua.util.InvalidDataException;

import org.junit.jupiter.api.*;
import java.io.*;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class StudentTests {

    // -------------------- TEST 1 --------------------
    @Test
    void testStudentInvalidFirstName() {
        assertThrows(InvalidDataException.class, () ->
                new Student("", "Petrenko", "ST001", LocalDate.now())
        );
    }

    // -------------------- TEST 2 --------------------
    @Test
    void testValidStudentCreation() throws InvalidDataException {
        Student st = new Student("Ivan", "Petrenko", "ST001", LocalDate.of(2025, 1, 1));

        assertEquals("Ivan", st.getFirstName());
        assertEquals("Petrenko", st.getLastName());
        assertEquals("ST001", st.getStudentId());
        assertEquals(LocalDate.of(2025, 1, 1), st.getEnrollmentDate());
    }

    // -------------------- TEST 3 --------------------
    @Test
    void testInvalidCourseCredits() {
        assertThrows(InvalidDataException.class, () ->
                new Course("Math", -5, 1)
        );
    }

    // -------------------- TEST 4 --------------------
    @Test
    void testProfessorFactoryMethod() throws InvalidDataException {
        Professor p = Professor.of("Olga", "Koval", "Math");

        assertEquals("Olga", p.getFirstName());
        assertEquals("Koval", p.getLastName());
        assertEquals("Math", p.getDepartment());
    }

    // -------------------- TEST 5 --------------------
    @Test
    void testDataLoaderLoadsStudentsFromCSV() throws Exception {

        // Створюємо папку data
        File folder = new File("data");
        folder.mkdir();

        // Створюємо файл students.csv
        File file = new File(folder, "students.csv");
        try (PrintWriter pw = new PrintWriter(file)) {
            pw.println("Ivan, Petrenko, ST001");
            pw.println("Oleg, Ivanov, ST002");
        }

        List<Student> list = DataLoader.loadStudents();

        assertEquals(2, list.size());
        assertEquals("Ivan", list.get(0).getFirstName());
        assertEquals("ST002", list.get(1).getStudentId());

        // Прибирання після тесту
        file.delete();
        folder.delete();
    }
}
