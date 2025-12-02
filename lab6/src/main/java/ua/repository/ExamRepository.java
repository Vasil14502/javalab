package ua.repository;

import ua.university.Exam;

public class ExamRepository extends GenericRepository<Exam> {
    public ExamRepository() {
        super(e -> e.getCourse().getTitle() + "_" + e.getDate().toString());
    }
}
