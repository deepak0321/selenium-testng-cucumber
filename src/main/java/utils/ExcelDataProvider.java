package utils;

import java.util.List;
import java.util.Map;

public final class ExcelDataProvider {

    private ExcelDataProvider() {
    }

    public static <T> Object[][] getData(String file, String sheet, Class<T> clazz) {

        List<Map<String, String>> rows = ExcelReader.readSheet(file, sheet);

        return rows.stream().map(row -> new Object[]{DataMapper.map(row, clazz)}).toArray(Object[][]::new);
    }
}
