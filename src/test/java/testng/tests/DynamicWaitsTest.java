package testng.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DynamicWaitsPage;
import pages.HomePage;
import pages.PracticePage;
import testng.base.BaseTest;

public class DynamicWaitsTest extends BaseTest {

    @Test
    public void dynamicWaitsTest() throws InterruptedException {

        HomePage homePage = new HomePage();
        homePage.openWebsite();
        Assert.assertTrue(homePage.isPageLoaded());
        homePage.gotToPracticePage();
        PracticePage practicePage = new PracticePage();
        Assert.assertTrue(practicePage.isPageLoaded());
        practicePage.goToDynamicWaits();
        DynamicWaitsPage dynamicWaitsPage = new DynamicWaitsPage();
        Assert.assertTrue(dynamicWaitsPage.isPageLoaded());


    }
}
