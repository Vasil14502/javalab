package ua.serialization;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

public class Serializer {

    private final ObjectMapper jsonMapper;
    private final ObjectMapper yamlMapper;

    public Serializer() {
        jsonMapper = new ObjectMapper();
        yamlMapper = new ObjectMapper(new YAMLFactory());
    }

    // JSON
    public String toJson(Object obj) throws JsonProcessingException {
        return jsonMapper.writeValueAsString(obj);
    }

    public <T> T fromJson(String json, Class<T> clazz) throws JsonProcessingException {
        return jsonMapper.readValue(json, clazz);
    }

    // YAML
    public String toYaml(Object obj) throws JsonProcessingException {
        return yamlMapper.writeValueAsString(obj);
    }

    public <T> T fromYaml(String yaml, Class<T> clazz) throws JsonProcessingException {
        return yamlMapper.readValue(yaml, clazz);
    }
}
