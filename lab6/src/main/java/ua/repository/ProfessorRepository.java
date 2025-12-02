package ua.repository;

import ua.university.Professor;

import java.util.Comparator;
import java.util.logging.Logger;

public class ProfessorRepository extends GenericRepository<Professor> {
    private static final Logger log = Logger.getLogger(ProfessorRepository.class.getName());

    public ProfessorRepository() {
        super(p -> p.firstName() + "_" + p.lastName());
    }

    public void sortByDepartmentThenLastName() {
        items.sort(Comparator.comparing((Professor p) -> p.department()).thenComparing(Professor::lastName));
        log.info("Sorted professors by department then last name");
    }
}
