package ua.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class AppConfig {

    private final Properties props = new Properties();

    public AppConfig() {
        try (InputStream is = getClass().getClassLoader().getResourceAsStream("config.properties")) {
            if (is == null) throw new RuntimeException("config.properties not found");
            props.load(is);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load config.properties", e);
        }
    }

    public String getJsonPath() {
        return props.getProperty("json.path");
    }

    public String getYamlPath() {
        return props.getProperty("yaml.path");
    }

    public int getTestDataCount() {
        return Integer.parseInt(props.getProperty("testData.count", "10"));
    }
}
