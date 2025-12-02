package ua.university;

import ua.repository.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        Department dept = Department.COMPUTER_SCIENCE;
        ExamType exam = ExamType.FINAL;
        System.out.println("Department: " + String.valueOf(dept));
        System.out.println("Exam type: " + String.valueOf(exam));

        Student student1 = Student.create("Alice", "Smith");
        Student student2 = new Student("Bob", "Johnson", "S123", LocalDate.of(2024, 9, 1));
        Professor prof = Professor.of("John", "Doe", Department.MATH);

        System.out.println("\nStudents:");
        System.out.println(student1);
        System.out.println(student2);
        System.out.println("\nProfessor:");
        System.out.println(prof);

        Course course1 = Course.createBasic("Programming 101");
        Course course2 = new Course("Mathematics", 4, 2);
        List<Course> courses = new ArrayList<>();
        courses.add(course1);
        courses.add(course2);
        System.out.println("\nCourses:");
        PrintStreamHolder.out().println(); // helper
        courses.forEach(System.out::println);

        int credits = course2.getCredits();
        String courseLevel;
        switch (credits) {
            case 1:
            case 2:
                courseLevel = "Beginner";
                break;
            case 3:
            case 4:
                courseLevel = "Intermediate";
                break;
            case 5:
            case 6:
                courseLevel = "Advanced";
                break;
            default:
                courseLevel = "Unknown";
        }

        System.out.println("\nCourse " + course2.getTitle() + " level: " + courseLevel);
        List<StudentGrade> studentGrades = new ArrayList<>();
        studentGrades.add(new StudentGrade(student1, course1, 85));
        studentGrades.add(new StudentGrade(student2, course2, 92));
        System.out.println("\nStudent grades:");

        for (StudentGrade sg : studentGrades) {
            String gradeLetter;
            switch (sg.grade() / 10) {
                case 6:
                    gradeLetter = "D";
                    break;
                case 7:
                    gradeLetter = "C";
                    break;
                case 8:
                    gradeLetter = "B";
                    break;
                case 9:
                case 10:
                    gradeLetter = "A";
                    break;
                default:
                    gradeLetter = "F";
            }
            System.out.printf("%s %s отримав %d (%s) в курсі '%s'%n",
                    sg.student().firstName(), sg.student().lastName(), sg.grade(), gradeLetter, sg.course().getTitle());
        }
    }

    public static record StudentGrade(Student student, Course course, int grade) {}
}

// small PrintStream helper
class PrintStreamHolder {
    public static java.io.PrintStream out() {
        return System.out;
    }
}
