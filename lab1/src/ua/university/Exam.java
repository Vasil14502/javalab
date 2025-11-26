package ua.university;


import ua.util.ValidationHelper;

public class Exam {

    private String subject;
    private String grade;
    private int year;

    // Конструктор
    public Exam(String subject, String grade, int year) {
        setSubject(subject);
        setGrade(grade);
        setYear(year);
    }

    // Фабричний метод
    public static Exam of(String subject, String grade, int year) {
        return new Exam(subject, grade, year);
    }

    // Геттер та сеттер для subject
    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        ValidationHelper.requireNonEmpty(subject, "subject");
        this.subject = subject;
    }

    // Геттер та сеттер для grade
    public String getGrade() {
        ValidationHelper.requireNonEmpty(grade, "grade");
        return grade;
    }

    public void setGrade(String grade) {
        ValidationHelper.requireNonEmpty(grade, "grade");
        this.grade = grade;
    }

    // Геттер та сеттер для year
    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        ValidationHelper.requirePositive(year, "year");
        this.year = year;
    }

    @Override
    public String toString() {
        return "Exam{" +
                "subject='" + subject + '\'' +
                ", grade='" + grade + '\'' +
                ", year=" + year +
                '}';
    }
}
