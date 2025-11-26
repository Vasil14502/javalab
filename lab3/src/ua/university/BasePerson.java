package ua.university;

import ua.util.InvalidDataException;
import ua.util.ValidationHelper;
import ua.util.Utils;

public abstract class BasePerson {

    protected String firstName;
    protected String lastName;

    protected BasePerson(String firstName, String lastName) throws InvalidDataException {
        setFirstName(firstName);
        setLastName(lastName);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) throws InvalidDataException {
        ValidationHelper.requireNonEmpty(firstName, "firstName");
        this.firstName = firstName;
        Utils.logInfo("Set firstName: " + firstName);
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) throws InvalidDataException {
        ValidationHelper.requireNonEmpty(lastName, "lastName");
        this.lastName = lastName;
        Utils.logInfo("Set lastName: " + lastName);
    }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }

    @Override
    public int hashCode() {
        return (firstName + lastName).hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof BasePerson p)) return false;
        return this.firstName.equals(p.firstName) && this.lastName.equals(p.lastName);
    }
}
