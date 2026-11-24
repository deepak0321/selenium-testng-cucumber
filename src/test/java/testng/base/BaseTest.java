package testng.base;

import driver.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.ConfigReader;

public class BaseTest {

    @BeforeMethod
    public void setUp(){
        WebDriver driver = new ChromeDriver();
        DriverFactory.setDriver(driver);
        DriverFactory.getDriver().manage().window().maximize();
    }

    @AfterMethod
    public void tearDown(){
        DriverFactory.quitDriver();
    }
}
