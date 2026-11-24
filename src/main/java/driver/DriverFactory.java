package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {

    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();;

    public static void setDriver(WebDriver webDriver){
        driver.set(webDriver);
    }

    public static WebDriver getDriver(){
        return driver.get();
    }

    public static void quitDriver(){
        driver.get().quit();
    }

}
