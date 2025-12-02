package ua.repository;

import ua.university.Course;

import java.util.Comparator;
import java.util.logging.Logger;

public class CourseRepository extends GenericRepository<Course> {
    private static final Logger log = Logger.getLogger(CourseRepository.class.getName());

    public CourseRepository() {
        super(Course::getTitle);
    }

    public void sortByCredits() {
        items.sort(Comparator.comparingInt(Course::getCredits));
        log.info("Sorted courses by credits");
    }

    public void sortBySemester() {
        items.sort(Comparator.comparingInt(Course::getSemester));
        log.info("Sorted courses by semester");
    }
}
