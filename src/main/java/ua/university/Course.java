package ua.university;

import ua.util.ValidationHelper;
public class Course implements Comparable<Course> {
    private String title;
    private int credits;
    private int semester;

    public Course(String title, int credits, int semester) {
        setTitle(title);
        setCredits(credits);
        setSemester(semester);
    }

    public static Course createBasic(String title) {
        return new Course(title, 3, 1);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        ValidationHelper.requireNonEmpty(title, "title");
        this.title = title;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        ValidationHelper.requirePositive(credits, "credits");
        this.credits = credits;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        ValidationHelper.requirePositive(semester, "semester");
        this.semester = semester;
    }

    @Override
    public int compareTo(Course other) {
        return this.title.compareTo(other.title);
    }

    @Override
    public String toString() {
        return "Course{title='%s', credits=%d, semester=%d}".formatted(title, credits, semester);
    }
}
