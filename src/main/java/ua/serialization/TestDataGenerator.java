
package ua.serialization;

import ua.university.Course;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public final class TestDataGenerator {
    private TestDataGenerator() {}

    public static List<Course> generateCourses(int count) {
        List<Course> list = new ArrayList<>(count);
        Random r = new Random(12345);
        for (int i = 0; i < count; i++) {
            String title = "Course-" + (i + 1);
            int credits = 1 + r.nextInt(6); // 1..6
            int semester = 1 + r.nextInt(8); // 1..8
            list.add(new Course(title, credits, semester));
        }
        return list;
    }
}
