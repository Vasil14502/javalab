package ua.university;

import ua.util.InvalidDataException;
import ua.util.ValidationHelper;
import ua.util.Utils;

import java.time.LocalDate;

public class Student extends BasePerson {

    private String studentId;
    private LocalDate enrollmentDate;

    public Student(String first, String last, String studentId, LocalDate date) throws InvalidDataException {
        super(first, last);
        setStudentId(studentId);
        setEnrollmentDate(date);
        Utils.logInfo("Created Student: " + this);
    }

    public static Student create(String first, String last) throws InvalidDataException {
        return new Student(first, last, "UNKNOWN", LocalDate.now());
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) throws InvalidDataException {
        ValidationHelper.requireNonEmpty(studentId, "studentId");
        this.studentId = studentId;
        Utils.logInfo("Set studentId: " + studentId);
    }

    public LocalDate getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(LocalDate enrollmentDate) throws InvalidDataException {
        ValidationHelper.requireNotNull(enrollmentDate, "enrollmentDate");
        this.enrollmentDate = enrollmentDate;
        Utils.logInfo("Set enrollmentDate: " + enrollmentDate);
    }

    @Override
    public String toString() {
        return "Student{" + super.toString() +
                ", id='" + studentId + '\'' +
                ", date=" + enrollmentDate + '}';
    }
}
