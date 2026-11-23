package pages;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ConfigReader;

import java.time.Duration;

public abstract class BasePage {

    protected WebDriver driver = DriverFactory.getDriver();
    protected WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    public abstract boolean isPageLoaded();

    public void click(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    public void type(By locator, String value) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).sendKeys(value);
    }

    public boolean isVisible(By locator) {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).isDisplayed();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
