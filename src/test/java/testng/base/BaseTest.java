package testng.base;

import driver.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.ConfigReader;


public abstract class BaseTest {

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        DriverFactory.createDriver();
        getDriver().get(ConfigReader.getConfigValue("base.url"));
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        DriverFactory.quitDriver();
    }

    protected WebDriver getDriver() {
        return DriverFactory.getDriver();
    }
}
