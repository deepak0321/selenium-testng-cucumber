package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import utils.ConfigReader;


public class DriverFactory {

    private static final ThreadLocal<WebDriver> DRIVER = new ThreadLocal<>();

    private DriverFactory() {
    }

    public static void createDriver() {

        WebDriver existing = DRIVER.get();
        if (existing != null) return;

        String browser = ConfigReader.getConfigValue("browser").toLowerCase();
        boolean headless = Boolean.parseBoolean(ConfigReader.getConfigValue("headless"));

        WebDriver webDriver = build(browser, headless);
        if (!headless) {
            webDriver.manage().window().maximize();
        }
        DRIVER.set(webDriver);
    }

    public static WebDriver getDriver() {
        WebDriver webDriver = DRIVER.get();
        if (webDriver == null) {
            throw new IllegalStateException("No WebDriver On Thread " + Thread.currentThread().getName() + ". Call DriverFactory.createDriver() first.");
        }
        return webDriver;
    }

    public static void quitDriver() {
        WebDriver webDriver = DRIVER.get();
        try {
            if (webDriver != null) {
                webDriver.quit();
            }
        } finally {
            DRIVER.remove();
        }
    }

    private static WebDriver build(String browser, boolean headless) {

        switch (browser) {
            case "chrome": {
                ChromeOptions options = new ChromeOptions();
                if (headless) {
                    options.addArguments("--headless=new", "--window-size=1920,1080");
                }
                return new ChromeDriver(options);
            }
            case "firefox": {
                FirefoxOptions options = new FirefoxOptions();
                if (headless) {
                    options.addArguments("--headless", "--width=1920", "--height=1080");
                }
                return new FirefoxDriver(options);
            }
            case "edge": {
                EdgeOptions options = new EdgeOptions();
                if (headless) {
                    options.addArguments("--headless=new", "--window-size=1920,1080");
                }
                return new EdgeDriver(options);
            }
            default: {
                throw new IllegalArgumentException("Unsupported browser: " + browser + ". Use chrome,firefox or edge.");
            }
        }
    }
}
