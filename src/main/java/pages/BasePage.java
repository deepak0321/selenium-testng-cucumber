package pages;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

    public void click(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public void type(By locator, String value) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).sendKeys(value);
    }

    public boolean isVisible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).isDisplayed();
    }

    public boolean isInvisible(By locator) {
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public String text(By locator){
        WebElement element = driver.findElement(locator);
        return element.getText();
    }

    public WebElement findShadowElement(By hostLocator,By innerLocator){
        WebElement host = wait.until(ExpectedConditions.presenceOfElementLocated(hostLocator));
        SearchContext shadow = host.getShadowRoot();
        return shadow.findElement(innerLocator);
    }

}
