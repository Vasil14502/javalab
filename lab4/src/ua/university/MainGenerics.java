package ua.university;

import ua.repository.GenericRepository;
import java.time.LocalDate;

public class MainGenerics {
    public static void main(String[] args) {

        // --- Репозиторій студентів ---
        GenericRepository<Student> studentRepo = new GenericRepository<>(Student::studentId);
        Student s1 = Student.create("Alice", "Smith");
        Student s2 = new Student("Bob", "Johnson", "S123", LocalDate.of(2024, 9, 1));

        studentRepo.add(s1);
        studentRepo.add(s2);

        System.out.println("\n=== Всі успішно створені студенти: ===");
        studentRepo.getAll().forEach(student ->
                System.out.printf("%s %s, ID: %s, Enrollment: %s%n",
                        student.firstName(),
                        student.lastName(),
                        student.studentId(),
                        student.enrollmentDate())
        );

        System.out.println("\nПошук студента за ID 'S123':");
        Student foundStudent = studentRepo.findByIdentity("S123");
        if (foundStudent != null) {
            System.out.printf("%s %s знайдено!%n", foundStudent.firstName(), foundStudent.lastName());
        }

        // --- Репозиторій професорів ---
        GenericRepository<Professor> profRepo = new GenericRepository<>(p -> p.firstName() + "_" + p.lastName());
        Professor prof1 = Professor.of("John", "Doe", Department.MATH);
        profRepo.add(prof1);

        System.out.println("\n=== Всі успішно створені професори: ===");
        profRepo.getAll().forEach(p ->
                System.out.printf("%s %s, Department: %s%n",
                        p.firstName(),
                        p.lastName(),
                        p.department())
        );

        System.out.println("\nПошук професора за ідентичністю 'John_Doe':");
        Professor foundProf = profRepo.findByIdentity("John_Doe");
        if (foundProf != null) {
            System.out.printf("%s %s знайдено!%n", foundProf.firstName(), foundProf.lastName());
        }

        // --- Репозиторій курсів ---
        GenericRepository<Course> courseRepo = new GenericRepository<>(Course::getTitle);
        Course c1 = Course.createBasic("Programming 101");
        Course c2 = new Course("Mathematics", 4, 2);

        courseRepo.add(c1);
        courseRepo.add(c2);

        System.out.println("\n=== Всі успішно створені курси: ===");
        courseRepo.getAll().forEach(c ->
                System.out.printf("%s, Credits: %d, Semester: %d%n",
                        c.getTitle(),
                        c.getCredits(),
                        c.getSemester())
        );

        System.out.println("\nПошук курсу за назвою 'Mathematics':");
        Course foundCourse = courseRepo.findByIdentity("Mathematics");
        if (foundCourse != null) {
            System.out.printf("Курс '%s' знайдено!%n", foundCourse.getTitle());
        }
    }
}
