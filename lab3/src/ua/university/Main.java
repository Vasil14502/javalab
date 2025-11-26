import ua.university.*;
import ua.util.Utils;
import ua.util.InvalidDataException;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        Utils.printHeader("Зчитування студентів з файлу");
        List<Student> students = DataLoader.loadStudents();

        Utils.printHeader("Всі успішно створені студенти:");
        for (Student s : students) {
            System.out.println(s);
        }

        Utils.printHeader("Перевірка некоректних даних");

        try {
            Student invalid = new Student("", "Ivanov", "ST777", null);
        } catch (InvalidDataException | IllegalArgumentException ex) {
            Utils.logError("Помилка створення студента: " + ex.getMessage());
        } finally {
            Utils.logInfo("Перевірка некоректного студента завершена.");
        }

        Utils.printHeader("Демонстрація створення курсів та викладачів");
        try {
            Course c1 = new Course("Programming", 5, 1);
            Course c2 = Course.createBasic("Databases");
            Professor p1 = Professor.of("Mariya", "Koval", "Mathematics");

            System.out.println(c1);
            System.out.println(c2);
            System.out.println(p1);
        } catch (InvalidDataException e) {
            Utils.logError("Помилка створення об’єкта: " + e.getMessage());
        }

        Utils.printHeader("Успішне завершення Main");
    }
}
