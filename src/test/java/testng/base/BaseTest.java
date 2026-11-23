package testng.base;

import driver.DriverFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.ConfigReader;

public class BaseTest {

    @BeforeMethod
    public void setUp(){
        DriverFactory.initDriver();
        DriverFactory.getDriver().manage().window().maximize();
    }

    @AfterMethod
    public void tearDown(){
        DriverFactory.quitDriver();
    }
}
