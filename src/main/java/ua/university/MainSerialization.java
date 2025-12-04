package ua.university;

import ua.config.AppConfig;
import ua.serialization.DataSerializer;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class MainSerialization {
    public static void main(String[] args) {
        AppConfig config = new AppConfig();
        DataSerializer serializer = new DataSerializer();

        List<Student> students = new ArrayList<>();
        students.add(Student.create("Alice", "Smith"));
        students.add(Student.create("Bob", "Johnson"));

        Path jsonPath = Path.of(config.getJsonPath());
        Path yamlPath = Path.of(config.getYamlPath());

        // Save
        serializer.saveJson(jsonPath, students);
        serializer.saveYaml(yamlPath, students);

        // Load
        List<Student> loadedFromJson = serializer.loadJson(jsonPath, Student.class);
        List<Student> loadedFromYaml = serializer.loadYaml(yamlPath, Student.class);

        System.out.println("Loaded JSON: " + loadedFromJson);
        System.out.println("Loaded YAML: " + loadedFromYaml);
    }
}
