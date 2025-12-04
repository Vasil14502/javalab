package ua.repository;

import ua.university.Enrollment;
import ua.university.Student;
import ua.university.Course;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class EnrollmentRepository extends GenericRepository<Enrollment> {
    private static final Logger log = Logger.getLogger(EnrollmentRepository.class.getName());

    public EnrollmentRepository() {
        super(e -> e.getStudent().studentId() + "_" + e.getCourse().getTitle());
    }

    public List<Enrollment> findByStudent(Student student) {
        log.info("Searching enrollments for student: " + student.studentId());
        return items.stream()
                .filter(e -> e.getStudent().equals(student))
                .collect(Collectors.toList());
    }

    public List<Enrollment> findByCourse(Course course) {
        log.info("Searching enrollments for course: " + course.getTitle());
        return items.stream()
                .filter(e -> e.getCourse().equals(course))
                .collect(Collectors.toList());
    }
}
