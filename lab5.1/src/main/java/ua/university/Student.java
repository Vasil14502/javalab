package ua.university;

import java.time.LocalDate;
import ua.util.ValidationHelper;

public record Student(String firstName, String lastName, String studentId, LocalDate enrollmentDate) implements Comparable<Student> {
    public Student {
        ValidationHelper.requireNonEmpty(firstName, "firstName");
        ValidationHelper.requireNonEmpty(lastName, "lastName");
        ValidationHelper.requireNonEmpty(studentId, "studentId");
        ValidationHelper.requireNonNull(enrollmentDate, "enrollmentDate");
    }

    public static Student create(String firstName, String lastName) {
        return new Student(firstName, lastName, "UNKNOWN", LocalDate.now());
    }

    @Override
    public int compareTo(Student other) {
        return this.studentId().compareTo(other.studentId());
    }

    @Override
    public String toString() {
        return "%s %s (ID: %s, enrollment: %s)".formatted(firstName, lastName, studentId, enrollmentDate);
    }
}
