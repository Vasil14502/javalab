package ua.university;

import ua.util.InvalidDataException;
import ua.util.Utils;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DataLoader {

    private static final String DATA_FOLDER = "data";
    private static final String STUDENTS_FILE = "students.csv";

    public static List<Student> loadStudents() {
        List<Student> students = new ArrayList<>();

        // Переконаємось, що папка існує
        File folder = new File(DATA_FOLDER);
        if (!folder.exists()) {
            boolean created = folder.mkdirs();
            if (created) {
                Utils.logInfo("Папка 'data' створена автоматично");
            } else {
                Utils.logError("Не вдалося створити папку 'data'");
            }
        }

        File file = new File(folder, STUDENTS_FILE);
        if (!file.exists()) {
            Utils.logError("Файл " + STUDENTS_FILE + " не знайдено у папці " + DATA_FOLDER);
            return students; // Повертаємо порожній список
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            int lineNumber = 0;
            while ((line = br.readLine()) != null) {
                lineNumber++;
                try {
                    String[] parts = line.split(",");
                    if (parts.length != 3) throw new InvalidDataException("Невірний формат CSV");
                    Student s = new Student(parts[0].trim(), parts[1].trim(), parts[2].trim(), LocalDate.now());
                    students.add(s);
                    Utils.logInfo("Line " + lineNumber + ": Created student -> " + s);
                } catch (InvalidDataException ex) {
                    Utils.logError("Line " + lineNumber + ": Error -> " + ex.getMessage());
                }
            }
        } catch (IOException e) {
            Utils.logError("Помилка роботи з файлом: " + e.getMessage());
        }

        return students;
    }
}
