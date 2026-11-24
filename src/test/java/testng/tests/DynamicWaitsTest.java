package testng.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DynamicWaitsPage;
import pages.HomePage;
import testng.base.BaseTest;

public class DynamicWaitsTest extends BaseTest {

    private DynamicWaitsPage openDynamicWaitsPage() {
        HomePage home = new HomePage();
        Assert.assertTrue(home.isPageLoaded(), "Home page did not load");

        DynamicWaitsPage dynamicWaitsPage = home.goToPracticePage().goToDynamicWaits();
        Assert.assertTrue(dynamicWaitsPage.isPageLoaded(), "Dynamic Waits page did not load");
        return dynamicWaitsPage;
    }

    @Test(description = "Element that appears after a delay becomes visible")
    public void delayedElementAppears() {
        DynamicWaitsPage dynamicWaitsPage = openDynamicWaitsPage();

        dynamicWaitsPage.triggerDelayedElement();

        Assert.assertTrue(dynamicWaitsPage.isDelayedResultDisplayed(), "Delayed result never appeared");
    }

    @Test(description = "Spinner disappears and the content is shown")
    public void spinnerFinishesAndContentAppears() {
        DynamicWaitsPage dynamicWaitsPage = openDynamicWaitsPage();

        dynamicWaitsPage.loadContentWithSpinner();

        Assert.assertTrue(dynamicWaitsPage.isSpinnerContentDisplayed(), "Content did not appear after spinner");
    }

    @Test(description = "Submit button is clickable once armed")
    public void armedButtonCanBeSubmitted() {
        DynamicWaitsPage dynamicWaitsPage = openDynamicWaitsPage();

        dynamicWaitsPage.armAndSubmit();

        String text = dynamicWaitsPage.submitSuccessText();

        Assert.assertTrue(text.contains("Submit clicked after wait"), "Unexpected submit element text: " + text);
    }

    @Test(description = "Race element text can be read once it is visible")
    public void raceElementTextIsReadable() {
        DynamicWaitsPage dynamicWaitsPage = openDynamicWaitsPage();

        String text = dynamicWaitsPage.getRaceElementText();

        Assert.assertTrue(text.contains("Race element visible"),
                "Unexpected race element text: " + text);
    }
}