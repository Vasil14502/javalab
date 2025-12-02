package ua.university;

import ua.util.ValidationHelper;
import java.time.LocalDate;
import java.util.Comparator;

public class Enrollment implements Comparable<Enrollment> {
    private final Student student;
    private final Course course;
    private final LocalDate date;

    public Enrollment(Student student, Course course, LocalDate date) {
        ValidationHelper.requireNonNull(student, "student");
        ValidationHelper.requireNonNull(course, "course");
        ValidationHelper.requireNonNull(date, "date");
        this.student = student;
        this.course = course;
        this.date = date;
    }

    public Student getStudent() { return student; }
    public Course getCourse() { return course; }
    public LocalDate getDate() { return date; }

    @Override
    public int compareTo(Enrollment o) {
        return this.student.studentId().compareTo(o.student.studentId());
    }

    @Override
    public String toString() {
        return "%s %s -> %s (%s)".formatted(student.firstName(), student.lastName(), course.getTitle(), date);
    }

    public static class Comparators {
        public static final Comparator<Enrollment> BY_COURSE_TITLE =
                Comparator.comparing(e -> e.getCourse().getTitle());

        public static final Comparator<Enrollment> BY_STUDENT_LASTNAME =
                Comparator.comparing(e -> e.getStudent().lastName());

        public static final Comparator<Enrollment> BY_DATE =
                Comparator.comparing(Enrollment::getDate);
    }
}
