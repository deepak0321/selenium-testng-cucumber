package utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.io.UncheckedIOException;

public final class JsonReader {

    private static final ObjectMapper MAPPER = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    private JsonReader() {
    }

    public static <T> T read(String filename, Class<T> type) {
        try (InputStream in = open(filename)) {
            return MAPPER.readValue(in, type);
        } catch (IOException e) {
            throw new UncheckedIOException("Failed to deserialize '" + filename + "' into " + type.getSimpleName(), e);
        }
    }

    public static <T> T read(String filename, TypeReference<T> typeReference) {
        try (InputStream in = open(filename)) {
            return MAPPER.readValue(in, typeReference);
        } catch (IOException e) {
            throw new UncheckedIOException("Failed to deserialize '" + filename + "' into " + typeReference.getType(), e);
        }
    }

    private static InputStream open(String filename) {
        InputStream in = JsonReader.class.getClassLoader().getResourceAsStream(filename);
        if (in == null) {
            throw new IllegalArgumentException("Resource not found on classpath: " + filename);
        }
        return in;
    }
}