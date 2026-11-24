package pages;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchShadowRootException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ConfigReader;

import java.time.Duration;

public abstract class BasePage {

    protected final WebDriver driver;
    protected final WebDriverWait wait;

    protected BasePage() {
        this.driver = DriverFactory.getDriver();
        int seconds = Integer.parseInt(ConfigReader.getConfigValue("explicit.wait.seconds"));
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        // retry instead of failing when the DOM refreshes under us
        this.wait.ignoring(StaleElementReferenceException.class, NoSuchShadowRootException.class);
    }

    public abstract boolean isPageLoaded();

    // ---------- wait helpers ----------

    protected WebElement waitForVisible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected void waitForInvisible(By locator) {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    protected WebElement waitForClickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    // ---------- actions ----------

    protected void click(By locator) {
        waitForClickable(locator).click();
    }

    protected void click(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    protected void type(By locator, String value) {
        WebElement element = waitForVisible(locator);
        element.clear();
        element.sendKeys(value);
    }

    protected String text(By locator) {
        return wait.until(d -> {
            WebElement element = d.findElement(locator);
            return element.isDisplayed() ? element.getText() : null;   // null means retry
        });
    }

    // ---------- state checks (return false instead of throwing) ----------

    protected boolean isVisible(By locator) {
        try {
            return waitForVisible(locator).isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }

    protected boolean isInvisible(By locator) {
        try {
            return wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
        } catch (TimeoutException e) {
            return false;
        }
    }

    // ---------- shadow DOM ----------

    protected WebElement findShadowElement(By hostLocator, By innerLocator) {
        WebElement host = wait.until(ExpectedConditions.presenceOfElementLocated(hostLocator));
        return wait.until(d -> host.getShadowRoot().findElement(innerLocator));
    }
}