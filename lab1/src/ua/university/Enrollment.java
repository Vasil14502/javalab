package ua.university;

import ua.util.ValidationHelper;

public class Enrollment {

    private Student student;
    private Course course;

    // Конструктор
    public Enrollment(Student student, Course course) {
        setStudent(student);
        setCourse(course);
    }

    // Фабричний метод
    public static Enrollment of(Student student, Course course) {
        return new Enrollment(student, course);
    }

    // Геттер та сеттер для student
    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        ValidationHelper.requireNonNull(student, "student");
        this.student = student;
    }

    // Геттер та сеттер для course
    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        ValidationHelper.requireNonNull(course, "course");
        this.course = course;
    }

    @Override
    public String toString() {
        return "Enrollment{" +
                "student=" + student +
                ", course=" + course +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !(o instanceof Enrollment)) return false;
        Enrollment other = (Enrollment) o;

        boolean studentEquals = (student == null ? other.student == null : student.equals(other.student));
        boolean courseEquals = (course == null ? other.course == null : course.equals(other.course));

        return studentEquals && courseEquals;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + (student != null ? student.hashCode() : 0);
        result = 31 * result + (course != null ? course.hashCode() : 0);
        return result;
    }
}
