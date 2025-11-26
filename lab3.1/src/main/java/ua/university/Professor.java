package ua.university;

import ua.util.InvalidDataException;
import ua.util.ValidationHelper;
import ua.util.Utils;

public class Professor extends BasePerson {

    private String department;

    public Professor(String first, String last, String department) throws InvalidDataException {
        super(first, last);
        setDepartment(department);
        Utils.logInfo("Created Professor: " + this);
    }

    public static Professor of(String first, String last, String dept) throws InvalidDataException {
        return new Professor(first, last, dept);
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) throws InvalidDataException {
        ValidationHelper.requireNonEmpty(department, "department");
        this.department = department;
        Utils.logInfo("Set department: " + department);
    }

    @Override
    public String toString() {
        return "Professor{" + super.toString() + ", dept='" + department + "'}";
    }
}
