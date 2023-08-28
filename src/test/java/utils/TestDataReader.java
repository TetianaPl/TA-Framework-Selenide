package utils;

import java.util.ResourceBundle;

public class TestDataReader {
    private static final ResourceBundle resourceBundle = ResourceBundle.getBundle(PropertiesReader.get("environment"));

    public static String getTestData(String key) {
        return resourceBundle.getString(key);
    }
}
