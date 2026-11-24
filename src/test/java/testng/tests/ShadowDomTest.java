package testng.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ShadowDomPage;
import testng.base.BaseTest;

public class ShadowDomTest extends BaseTest {

    @Test(description = "Button inside a shadow root can be clicked")
    public void shadowBasicButtonCanBeClicked() throws InterruptedException {
        HomePage home = new HomePage();
        Assert.assertTrue(home.isPageLoaded(), "Home page did not load");

        ShadowDomPage shadowDomPage = home.goToPracticePage().goToShadowDOM();
        Thread.sleep(5000);
        Assert.assertTrue(shadowDomPage.isPageLoaded(), "Shadow DOM page did not load");

        shadowDomPage.clickShadowBasicButton();

        String text = shadowDomPage.shadowBasicActionText();

        Assert.assertTrue(text.contains("Shadow button clicked"), "Click had no visible effect");
    }
}