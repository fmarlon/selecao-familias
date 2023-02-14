package dev.frankmms.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.IOException;
import java.net.URL;

public class YamlUtils {

    static YAMLMapper yamlMapper = (YAMLMapper) new YAMLMapper().registerModule(new JavaTimeModule());

    public static <T> T readResource(String name, Class<T> clazz) {
        return readValue(YamlUtils.class.getResource(name), clazz);
    }

    public static <T> T readResource(String name, TypeReference<T> typeReference) {
        return readValue(YamlUtils.class.getResource(name), typeReference);
    }

    public static <T> T readValue(URL resource, Class<T> clazz) {
        try {
            return yamlMapper.readValue(resource, clazz);
        } catch (IOException e) {
            throw new IllegalStateException("Unable to read YAML resource '" + resource + " for class " + clazz.getName(), e);
        }
    }

    public static <T> T readValue(URL resource, TypeReference<T> typeReference) {
        try {
            return yamlMapper.readValue(resource, typeReference);
        } catch (IOException e) {
            throw new IllegalStateException("Unable to read YAML resource '" + resource + " for type " + typeReference, e);
        }
    }

}
