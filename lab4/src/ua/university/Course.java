package ua.university;

public class Course {

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

    public String getTitle() { return title; }

    public void setTitle(String title) {
        if (title == null || title.isBlank())
            throw new IllegalArgumentException("title cannot be empty");
        this.title = title;
    }

    public int getCredits() { return credits; }

    public void setCredits(int credits) {
        if (credits <= 0)
            throw new IllegalArgumentException("credits must be positive");
        this.credits = credits;
    }

    public int getSemester() { return semester; }

    public void setSemester(int semester) {
        if (semester <= 0)
            throw new IllegalArgumentException("semester must be positive");
        this.semester = semester;
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
