package ua.repository;

import ua.university.Student;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class StudentRepository extends GenericRepository<Student> {
    private static final Logger log = Logger.getLogger(StudentRepository.class.getName());

    public StudentRepository() {
        super(Student::studentId);
    }

    public List<Student> findByLastName(String lastName) {
        log.info("Searching students by lastName: " + lastName);
        return items.stream()
                .filter(s -> s.lastName().equalsIgnoreCase(lastName))
                .collect(Collectors.toList());
    }

    public List<Student> findByEnrollmentDateRange(LocalDate from, LocalDate to) {
        log.info("Searching students enrolled from " + from + " to " + to);
        return items.stream()
                .filter(s -> !s.enrollmentDate().isBefore(from) && !s.enrollmentDate().isAfter(to))
                .collect(Collectors.toList());
    }

    public int totalStudents() {
        log.info("Counting total students");
        return items.stream().mapToInt(s -> 1).sum();  // приклад reduce альтернативи
    }

    public void sortByFirstName() {
        items.sort(Comparator.comparing(Student::firstName));
        log.info("Sorted students by first name");
    }

    public void sortByLastName() {
        items.sort(Comparator.comparing(Student::lastName));
        log.info("Sorted students by last name");
    }

    public void sortByEnrollmentDateDesc() {
        items.sort(Comparator.comparing(Student::enrollmentDate).reversed());
        log.info("Sorted students by enrollment date desc");
    }

    // convenience to return items for printing
    public List<Student> all() {
        return getAll();
    }
}