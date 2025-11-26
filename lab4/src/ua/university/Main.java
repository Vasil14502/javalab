package ua.university;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // --- Створення enum ---
        Department dept = Department.COMPUTER_SCIENCE;
        ExamType exam = ExamType.FINAL;

        System.out.println("Department: " + dept);
        System.out.println("Exam type: " + exam);

        // --- Створення record ---
        Student student1 = Student.create("Alice", "Smith");
        Student student2 = new Student("Bob", "Johnson", "S123", LocalDate.of(2024, 9, 1));
        Professor prof = Professor.of("John", "Doe", Department.MATH);

        System.out.println("\nStudents:");
        System.out.println(student1);
        System.out.println(student2);

        System.out.println("\nProfessor:");
        System.out.println(prof);

        // --- Створення курсів ---
        Course course1 = Course.createBasic("Programming 101");
        Course course2 = new Course("Mathematics", 4, 2);

        List<Course> courses = new ArrayList<>();
        courses.add(course1);
        courses.add(course2);

        System.out.println("\nCourses:");
        courses.forEach(System.out::println);

        // --- Використання switch expression ---
        int credits = course2.getCredits();
        String courseLevel = switch (credits) {
            case 1, 2 -> "Beginner";
            case 3, 4 -> "Intermediate";
            case 5, 6 -> "Advanced";
            default -> "Unknown";
        };
        System.out.println("\nCourse " + course2.getTitle() + " level: " + courseLevel);

        // --- Робота зі структурованими даними ---
        // Припустимо, оцінки студентів по курсам
        var studentGrades = new ArrayList<StudentGrade>();
        studentGrades.add(new StudentGrade(student1, course1, 85));
        studentGrades.add(new StudentGrade(student2, course2, 92));

        System.out.println("\nStudent grades:");
        for (StudentGrade sg : studentGrades) {
            String gradeLetter = switch (sg.grade / 10) {
                case 10, 9 -> "A";
                case 8 -> "B";
                case 7 -> "C";
                case 6 -> "D";
                default -> "F";
            };
            System.out.printf("%s %s отримав %d (%s) в курсі '%s'%n",
                    sg.student.firstName(),
                    sg.student.lastName(),
                    sg.grade,
                    gradeLetter,
                    sg.course.getTitle());
        }
    }

    // Допоміжний record для оцінок
    public record StudentGrade(Student student, Course course, int grade) {}


}
