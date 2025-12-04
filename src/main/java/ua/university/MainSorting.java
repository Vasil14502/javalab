package ua.university;

import ua.repository.*;

import java.time.LocalDate;

public class MainSorting {
    public static void main(String[] args) {
        StudentRepository students = new StudentRepository();
        CourseRepository courses = new CourseRepository();
        EnrollmentRepository enrollments = new EnrollmentRepository();
        ExamRepository exams = new ExamRepository();

        Student s1 = Student.create("Alice", "Smith");
        Student s2 = new Student("Bob", "Johnson", "S123", LocalDate.now());
        Student s3 = new Student("Charlie", "Brown", "S555", LocalDate.now());
        students.add(s1);
        students.add(s2);
        students.add(s3);

        System.out.println("\nStudents sorted by last name:");
        students.sortByLastName();
        students.getAll().forEach(System.out::println);

        System.out.println("\nStudents sorted by identity DESC:");
        students.sortByIdentity("desc");
        students.getAll().forEach(System.out::println);

        Course c1 = new Course("Programming", 3, 1);
        Course c2 = new Course("Algorithms", 5, 3);
        courses.add(c1); courses.add(c2);

        System.out.println("\nCourses sorted by credits:");
        courses.sortByCredits();
        courses.getAll().forEach(System.out::println);

        enrollments.add(new Enrollment(s1, c1, LocalDate.now().minusDays(10)));
        enrollments.add(new Enrollment(s3, c2, LocalDate.now().minusDays(5)));
        enrollments.add(new Enrollment(s2, c1, LocalDate.now()));

        System.out.println("\nEnrollments sorted BY STUDENT last name:");
        enrollments.getAll().stream()
                .sorted(Enrollment.Comparators.BY_STUDENT_LASTNAME)
                .forEach(System.out::println);

        exams.add(new Exam(c1, LocalDate.of(2025, 1, 20), 100));
        exams.add(new Exam(c2, LocalDate.of(2025, 2, 15), 120));

        System.out.println("\nExams sorted by date:");
        exams.sortByIdentity("asc");
        exams.getAll().forEach(System.out::println);
    }
}
