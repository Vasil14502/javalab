package ua.repository;

import ua.university.Course;

import java.util.Comparator;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class CourseRepository extends GenericRepository<Course> {
    private static final Logger log = Logger.getLogger(CourseRepository.class.getName());

    public CourseRepository() {
        super(Course::getTitle);
    }

    public List<Course> findByCreditsRange(int min, int max) {
        log.info("Searching courses with credits between " + min + " and " + max);
        return items.stream()
                .filter(c -> c.getCredits() >= min && c.getCredits() <= max)
                .collect(Collectors.toList());
    }

    public List<Course> findBySemester(int semester) {
        log.info("Searching courses by semester: " + semester);
        return items.stream()
                .filter(c -> c.getSemester() == semester)
                .collect(Collectors.toList());
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
