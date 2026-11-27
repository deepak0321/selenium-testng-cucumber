package testng.providers;

import com.fasterxml.jackson.core.type.TypeReference;
import models.User;
import org.testng.annotations.DataProvider;
import utils.ExcelDataProvider;
import utils.JsonReader;

import java.util.List;

public class UserDataProvider {

    private static final String JSON_USERS_FILE_PATH = "test-data/json/users.json";

    private static final String EXCEL_USERS_FILE_PATH = "test-data/excel/Users.xlsx";

    @DataProvider(name = "users")
    public static Object[][] users() {

        List<User> users = JsonReader.read(JSON_USERS_FILE_PATH, new TypeReference<List<User>>() {});

        return users.stream().map(user -> new Object[]{user}).toArray(Object[][]::new);
    }

    @DataProvider(name = "excelUsers")
    public static Object[][] excelUsers() {

        return ExcelDataProvider.getData(EXCEL_USERS_FILE_PATH, "Users", User.class);
    }
}