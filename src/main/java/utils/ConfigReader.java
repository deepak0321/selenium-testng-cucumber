package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Set;

public class ConfigReader {

    private static final String COMMON_FILE = "config.properties";
    private static final Properties properties = new Properties();
    private static final Set<String> SUPPORTED = Set.of("testng", "junit", "cucumber");
    private static final String framework;

    static {
        properties.putAll(load(COMMON_FILE));
        framework = resolveFramework();
        properties.putAll(load(framework + "-config.properties"));
    }

    private ConfigReader() {
    }

    public static String getFramework() {
        return framework;
    }

    public static String getConfigValue(String key) {
        String value = System.getProperty(key);
        if (value == null || value.isBlank()) {
            value = properties.getProperty(key);
        }
        return (value == null || value.isBlank()) ? null : value.trim();
    }

    public static String getConfigValue(String key, String defaultValue) {
        String value = getConfigValue(key);
        return value != null ? value : defaultValue;
    }

    public static String getRequiredConfigValue(String key) {
        String value = getConfigValue(key);
        if (value == null) {
            throw new IllegalStateException("Missing config key '" + key + "' (framework=" + framework + ")");
        }
        return value;
    }

    private static Properties load(String fileName) {
        Properties props = new Properties();
        try (InputStream in = ConfigReader.class.getClassLoader().getResourceAsStream(fileName)) {
            if (in == null) {
                throw new IllegalArgumentException(fileName + " not found on classpath (put it in src/test/resources)");
            }
            props.load(in);
        } catch (IOException e) {
            throw new IllegalStateException("Failed to read " + fileName, e);
        }
        return props;
    }

    private static String resolveFramework() {
        String value = System.getProperty("framework");
        if (value == null || value.isBlank()) {
            value = properties.getProperty("framework");
        }
        if (value == null || value.isBlank()) {
            throw new IllegalStateException("'framework' is not set. Add framework=testng|junit|cucumber to " + COMMON_FILE);
        }
        value = value.trim().toLowerCase();
        if (!SUPPORTED.contains(value)) {
            throw new IllegalStateException("Unsupported framework '" + value + "'. Use one of " + SUPPORTED);
        }
        return value;
    }
}
