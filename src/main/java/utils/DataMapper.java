package utils;


import com.fasterxml.jackson.databind.ObjectMapper;

public final class DataMapper {

    private static final ObjectMapper MAPPER = new ObjectMapper();

    private DataMapper() {
    }

    public static <T> T map(Object source, Class<T> targetClass) {

        return MAPPER.convertValue(source, targetClass);
    }
}
