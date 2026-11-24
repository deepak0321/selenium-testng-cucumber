package testng.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.PracticePage;
import pages.ShadowDomPage;
import testng.base.BaseTest;

public class ShadowDomTest extends BaseTest {

    @Test
    public void shadowDOMTest() throws InterruptedException {
        HomePage homePage = new HomePage();
        homePage.openWebsite();
        Assert.assertTrue(homePage.isPageLoaded());
        homePage.gotToPracticePage();
        PracticePage practicePage = new PracticePage();
        Assert.assertTrue(practicePage.isPageLoaded());
        practicePage.goToShadowDOM();
        ShadowDomPage shadowDomPage = new ShadowDomPage();
        Assert.assertTrue(shadowDomPage.isPageLoaded());
        shadowDomPage.clickShadowBasicButton();
    }
}
