package ua.university;

import java.time.LocalDate;

public record Student(String firstName, String lastName, String studentId, LocalDate enrollmentDate) {

    public Student {
        if (firstName == null || firstName.isBlank())
            throw new IllegalArgumentException("firstName cannot be empty");
        if (lastName == null || lastName.isBlank())
            throw new IllegalArgumentException("lastName cannot be empty");
        if (studentId == null || studentId.isBlank())
            throw new IllegalArgumentException("studentId cannot be empty");
        if (enrollmentDate == null)
            throw new IllegalArgumentException("enrollmentDate cannot be null");
    }

    public static Student create(String firstName, String lastName) {
        return new Student(firstName, lastName, "UNKNOWN", LocalDate.now());
    }
}

