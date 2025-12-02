package ua.repository;

import ua.university.Student;

import java.util.Comparator;
import java.util.List;
import java.util.logging.Logger;

public class StudentRepository extends GenericRepository<Student> {
    private static final Logger log = Logger.getLogger(StudentRepository.class.getName());

    public StudentRepository() {
        super(Student::studentId);
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
