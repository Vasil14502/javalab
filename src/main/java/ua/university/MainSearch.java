package ua.university;

import ua.repository.*;

import java.time.LocalDate;
import java.util.List;

public class MainSearch {
    public static void main(String[] args) {
        StudentRepository students = new StudentRepository();
        CourseRepository courses = new CourseRepository();
        EnrollmentRepository enrollments = new EnrollmentRepository();

        Student s1 = Student.create("Alice","Smith");
        Student s2 = new Student("Bob", "Johnson", "S123", LocalDate.of(2024, 9, 1));
        Student s3 = Student.create("Charlie","Brown");

        students.add(s1); students.add(s2); students.add(s3);

        Course c1 = Course.createBasic("Programming 101");
        Course c2 = new Course("Mathematics", 4, 2);

        courses.add(c1); courses.add(c2);

        enrollments.add(new Enrollment(s1, c1, LocalDate.now().minusDays(10)));
        enrollments.add(new Enrollment(s2, c1, LocalDate.now().minusDays(5)));
        enrollments.add(new Enrollment(s3, c2, LocalDate.now()));

        System.out.println("=== Students with last name 'Smith' ===");
        students.findByLastName("Smith").forEach(System.out::println);

        System.out.println("\n=== Courses with 3-4 credits ===");
        courses.findByCreditsRange(3, 4).forEach(System.out::println);

        System.out.println("\n=== Enrollments for Programming 101 ===");
        enrollments.findByCourse(c1).forEach(System.out::println);

        // Демонстрація parallelStream
        System.out.println("\n=== Parallel stream for student IDs ===");
        students.getAll().parallelStream()
                .map(Student::studentId)
                .forEach(System.out::println);

        // reduce приклад
        int totalStudents = students.getAll().stream().mapToInt(s -> 1).reduce(0, Integer::sum);
        System.out.println("\nTotal students (via reduce): " + totalStudents);
    }
}
