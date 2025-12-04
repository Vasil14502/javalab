
package ua.serialization;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Logger;

public final class Config {
    private static final Logger log = Logger.getLogger(Config.class.getName());
    private static final Properties props = new Properties();

    static {
        try (InputStream is = Config.class.getClassLoader().getResourceAsStream("config.properties")) {
            if (is != null) {
                props.load(is);
                log.info("Loaded config.properties");
            } else {
                log.warning("config.properties not found in classpath");
            }
        } catch (IOException e) {
            log.severe("Failed to load config.properties: " + e.getMessage());
        }
    }

    private Config() {}

    public static String get(String key, String defaultValue) {
        return props.getProperty(key, defaultValue);
    }

    public static int getInt(String key, int defaultValue) {
        String v = props.getProperty(key);
        if (v == null) return defaultValue;
        try {
            return Integer.parseInt(v.trim());
        } catch (NumberFormatException ex) {
            log.warning("Invalid int for key " + key + ": " + v);
            return defaultValue;
        }
    }
}
