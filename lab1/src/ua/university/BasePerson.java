package ua.university;

public abstract class BasePerson {

    protected String firstName;
    protected String lastName;

    protected BasePerson(String firstName, String lastName) {
        setFirstName(firstName);
        setLastName(lastName);
    }

    public String getFirstName() { return firstName; }

    public void setFirstName(String firstName) {
        if (firstName == null || firstName.isBlank())
            throw new IllegalArgumentException("firstName cannot be empty");
        this.firstName = firstName;
    }

    public String getLastName() { return lastName; }

    public void setLastName(String lastName) {
        if (lastName == null || lastName.isBlank())
            throw new IllegalArgumentException("lastName cannot be empty");
        this.lastName = lastName;
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
        return this.firstName.equals(p.firstName)
                && this.lastName.equals(p.lastName);
    }
}
