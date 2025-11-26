import ua.university.*;
import ua.util.Utils;

import java.time.LocalDate;

public class main {

    public static void main(String[] args) {

        Utils.printHeader("Створення об'єктів");

        Student s1 = new Student("Ivan", "Petrenko", "ST123", LocalDate.of(2023, 9, 1));
        Student s2 = Student.create("Oksana", "Hrytsenko");

        Professor p1 = Professor.of("Mariya", "Koval", "Mathematics");

        Course c1 = new Course("Programming", 5, 1);
        Course c2 = Course.createBasic("Databases");

        Enrollment e1 = Enrollment.of(s1, c1);
        Enrollment e2 = new Enrollment(s2, c2);

        Exam exam1 = Exam.of("Ivan", "Mathematics", 95);
        Exam exam2 = new Exam("Oksana Hrytsenko", "Databases", 88);



        System.out.println(s1);
        System.out.println(s2);
        System.out.println(p1);
        System.out.println(c1);
        System.out.println(c2);
        System.out.println(e1);
        System.out.println(e2);
        System.out.println(exam1);
        System.out.println(exam2);

        Utils.printHeader("Валідація (помилковий сценарій)");

        try {
            Student bad = new Student("", "Ivanov", "ST777", LocalDate.now());
        } catch (Exception ex) {
            System.out.println("Помилка: " + ex.getMessage());
        }

        try {
            Course invalid = new Course("Math", -2, 0);
        } catch (Exception ex) {
            System.out.println("Помилка: " + ex.getMessage());
        }

        Utils.printHeader("Доступ до protected");

        System.out.println("Ім'я студента (protected поле firstName успадковується): "
                + s1.getFirstName());
    }

}

