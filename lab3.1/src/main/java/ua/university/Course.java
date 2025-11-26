package ua.university;

import ua.util.InvalidDataException;
import ua.util.ValidationHelper;
import ua.util.Utils;

public class Course {

    private String title;
    private int credits;
    private int semester;

    public Course(String title, int credits, int semester) throws InvalidDataException {
        setTitle(title);
        setCredits(credits);
        setSemester(semester);
        Utils.logInfo("Created Course: " + this);
    }

    public static Course createBasic(String title) throws InvalidDataException {
        return new Course(title, 3, 1);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) throws InvalidDataException {
        ValidationHelper.requireNonEmpty(title, "title");
        this.title = title;
        Utils.logInfo("Set title: " + title);
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) throws InvalidDataException {
        ValidationHelper.requirePositive(credits, "credits");
        this.credits = credits;
        Utils.logInfo("Set credits: " + credits);
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) throws InvalidDataException {
        ValidationHelper.requirePositive(semester, "semester");
        this.semester = semester;
        Utils.logInfo("Set semester: " + semester);
    }

    @Override
    public String toString() {
        return "Course{" +
                "title='" + title + '\'' +
                ", credits=" + credits +
                ", semester=" + semester +
                '}';
    }
}
