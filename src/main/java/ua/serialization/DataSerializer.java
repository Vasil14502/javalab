package ua.serialization;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.logging.Logger;

public class DataSerializer {

    private static final Logger log = Logger.getLogger(DataSerializer.class.getName());

    private final ObjectMapper jsonMapper;
    private final ObjectMapper yamlMapper;

    public DataSerializer() {
        jsonMapper = new ObjectMapper();
        jsonMapper.registerModule(new JavaTimeModule());
        jsonMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        jsonMapper.enable(SerializationFeature.INDENT_OUTPUT);

        yamlMapper = new ObjectMapper(new YAMLFactory());
        yamlMapper.registerModule(new JavaTimeModule());
        yamlMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        yamlMapper.enable(SerializationFeature.INDENT_OUTPUT);
    }

    public <T> void saveJson(Path path, List<T> data) {
        try {
            ensureParent(path);
            jsonMapper.writeValue(path.toFile(), data);
            log.info("JSON saved to " + path);
        } catch (IOException e) {
            log.severe("Failed to save JSON: " + e.getMessage());
            throw new DataSerializationException("JSON save failed", e);
        }
    }

    public <T> List<T> loadJson(Path path, Class<T> clazz) {
        try {
            CollectionType type = jsonMapper.getTypeFactory().constructCollectionType(List.class, clazz);
            List<T> result = jsonMapper.readValue(path.toFile(), type);
            log.info("JSON loaded from " + path);
            return result;
        } catch (IOException e) {
            log.severe("Failed to load JSON: " + e.getMessage());
            throw new DataSerializationException("JSON load failed", e);
        }
    }

    public <T> void saveYaml(Path path, List<T> data) {
        try {
            ensureParent(path);
            yamlMapper.writeValue(path.toFile(), data);
            log.info("YAML saved to " + path);
        } catch (IOException e) {
            log.severe("Failed to save YAML: " + e.getMessage());
            throw new DataSerializationException("YAML save failed", e);
        }
    }

    public <T> List<T> loadYaml(Path path, Class<T> clazz) {
        try {
            CollectionType type = yamlMapper.getTypeFactory().constructCollectionType(List.class, clazz);
            List<T> result = yamlMapper.readValue(path.toFile(), type);
            log.info("YAML loaded from " + path);
            return result;
        } catch (IOException e) {
            log.severe("Failed to load YAML: " + e.getMessage());
            throw new DataSerializationException("YAML load failed", e);
        }
    }

    private void ensureParent(Path path) throws IOException {
        if (path.getParent() != null) Files.createDirectories(path.getParent());
    }
}
