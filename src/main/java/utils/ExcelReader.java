package utils;

import org.apache.poi.ss.usermodel.*;

import java.io.InputStream;
import java.util.*;

public class ExcelReader {

    private ExcelReader() {
    }

    public static List<Map<String, String>> readSheet(String fileName, String sheetName) {

        List<Map<String, String>> data = new ArrayList<>();

        try (InputStream in = ExcelReader.class.getClassLoader().getResourceAsStream(fileName);

             Workbook workbook = WorkbookFactory.create(in)) {

            if (in == null) {
                throw new IllegalArgumentException(fileName + " not found");
            }

            Sheet sheet = workbook.getSheet(sheetName);

            DataFormatter formatter = new DataFormatter();

            Row headerRow = sheet.getRow(0);

            for (int i = 1; i <= sheet.getLastRowNum(); i++) {

                Row row = sheet.getRow(i);

                Map<String, String> rowData = new LinkedHashMap<>();

                for (int j = 0; j < headerRow.getLastCellNum(); j++) {

                    String header = formatter.formatCellValue(headerRow.getCell(j));

                    String value = formatter.formatCellValue(row.getCell(j));

                    rowData.put(header, value);
                }

                data.add(rowData);
            }

            return data;

        } catch (Exception e) {

            throw new RuntimeException("Failed reading excel", e);
        }
    }
}