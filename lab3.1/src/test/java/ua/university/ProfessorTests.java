package ua.university;

import ua.util.InvalidDataException;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class ProfessorTests {

    @Test
    void testValidProfessorCreation() throws InvalidDataException {
        Professor p = Professor.of("Olga", "Koval", "Math");

        assertEquals("Olga", p.getFirstName());
        assertEquals("Koval", p.getLastName());
        assertEquals("Math", p.getDepartment());

        System.out.println("Professor created: " + p.getFirstName() + " " + p.getLastName() + ", Department: " + p.getDepartment());
    }

    @Test
    void testInvalidProfessorFirstName() {
        Exception ex = assertThrows(InvalidDataException.class, () ->
                Professor.of("", "Koval", "Math"));
        System.out.println("Caught expected exception for invalid first name: " + ex.getMessage());
    }

    @Test
    void testInvalidProfessorDepartment() {
        Exception ex = assertThrows(InvalidDataException.class, () ->
                Professor.of("Olga", "Koval", ""));
        System.out.println("Caught expected exception for invalid department: " + ex.getMessage());
    }
}

