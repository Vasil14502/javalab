package ua.university;

import ua.util.ValidationHelper;

public record Professor(String firstName, String lastName, Department department) implements Comparable<Professor> {
    public Professor {
        ValidationHelper.requireNonEmpty(firstName, "firstName");
        ValidationHelper.requireNonEmpty(lastName, "lastName");
        ValidationHelper.requireNonNull(department, "department");
    }

    public static Professor of(String firstName, String lastName, Department department) {
        return new Professor(firstName, lastName, department);
    }

    @Override
    public int compareTo(Professor other) {
        int cmp = this.lastName().compareTo(other.lastName());
        if (cmp != 0) return cmp;
        return this.firstName().compareTo(other.firstName());
    }

    @Override
    public String toString() {
        return "%s %s (%s)".formatted(firstName, lastName, department);
    }
}
