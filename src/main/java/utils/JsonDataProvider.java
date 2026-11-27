package utils;

import com.fasterxml.jackson.core.type.TypeReference;

import java.util.List;

public final class JsonDataProvider {

    private JsonDataProvider() {
    }

    public static <T> Object[][] getData(String file, TypeReference<List<T>> typeReference) {

        List<T> data = JsonReader.read(file, typeReference);

        return data.stream().map(item -> new Object[]{item}).toArray(Object[][]::new);
    }
}
