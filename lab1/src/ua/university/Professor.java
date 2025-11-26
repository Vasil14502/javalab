package ua.university;

import ua.util.ValidationHelper;

public class Professor extends BasePerson {

    private String department;

    public Professor(String first, String last, String department) {
        super(first, last);
        setDepartment(department);
    }

    public static Professor of(String first, String last, String dept) {
        return new Professor(first, last, dept);
    }

    public String getDepartment() { return department; }

    public void setDepartment(String department) {
        ValidationHelper.requireNonEmpty(department, "department");
        this.department = department;
    }

    @Override
    public String toString() {
        return "Professor{" + super.toString()
                + ", dept='" + department + "'}";
    }
}
