package ua.repository;

import ua.university.Enrollment;

public class EnrollmentRepository extends GenericRepository<Enrollment> {
    public EnrollmentRepository() {
        super(e -> e.getStudent().studentId() + "_" + e.getCourse().getTitle());
    }
}
