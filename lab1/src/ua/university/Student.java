package ua.university;

import ua.util.ValidationHelper;
import java.time.LocalDate;

public class Student extends BasePerson {

    private String studentId;
    private LocalDate enrollmentDate;

    public Student(String first, String last, String studentId, LocalDate date) {
        super(first, last);
        setStudentId(studentId);
        setEnrollmentDate(date);
    }

    public static Student create(String first, String last) {
        return new Student(first, last, "UNKNOWN", LocalDate.now());
    }

    public String getStudentId() { return studentId; }

    public void setStudentId(String studentId) {
        ValidationHelper.requireNonEmpty(studentId, "studentId");
        this.studentId = studentId;
    }

    public LocalDate getEnrollmentDate() { return enrollmentDate; }

    public void setEnrollmentDate(LocalDate enrollmentDate) {
        if (enrollmentDate == null)
            throw new IllegalArgumentException("enrollmentDate cannot be null");
        this.enrollmentDate = enrollmentDate;
    }

    @Override
    public String toString() {
        return "Student{" + super.toString() +
                ", id='" + studentId + '\'' +
                ", date=" + enrollmentDate + '}';
    }
}
