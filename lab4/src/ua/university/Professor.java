package ua.university;

public record Professor(String firstName, String lastName, Department department) {

    public Professor {
        if (firstName == null || firstName.isBlank())
            throw new IllegalArgumentException("firstName cannot be empty");
        if (lastName == null || lastName.isBlank())
            throw new IllegalArgumentException("lastName cannot be empty");
        if (department == null)
            throw new IllegalArgumentException("department cannot be null");
    }

    public static Professor of(String firstName, String lastName, Department department) {
        return new Professor(firstName, lastName, department);
    }
}
