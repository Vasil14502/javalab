package ua.university;

import ua.util.ValidationHelper;
import java.time.LocalDate;
import java.util.Comparator;

public class Exam implements Comparable<Exam> {
    private final Course course;
    private final LocalDate date;
    private final int maxPoints;

    public Exam(Course course, LocalDate date, int maxPoints) {
        ValidationHelper.requireNonNull(course, "course");
        ValidationHelper.requireNonNull(date, "date");
        ValidationHelper.requirePositive(maxPoints, "maxPoints");
        this.course = course;
        this.date = date;
        this.maxPoints = maxPoints;
    }

    public Course getCourse() { return course; }
    public LocalDate getDate() { return date; }
    public int getMaxPoints() { return maxPoints; }

    @Override
    public int compareTo(Exam other) {
        return this.date.compareTo(other.date);
    }

    @Override
    public String toString() {
        return "Exam{%s, date=%s, max=%d}".formatted(course.getTitle(), date, maxPoints);
    }

    public static class Comparators {
        public static final Comparator<Exam> BY_COURSE_TITLE =
                Comparator.comparing(e -> e.getCourse().getTitle());

        public static final Comparator<Exam> BY_MAX_POINTS =
                Comparator.comparingInt(Exam::getMaxPoints);
    }
}
