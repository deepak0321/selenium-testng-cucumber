package pages;

import org.openqa.selenium.By;

public class DynamicWaitsPage extends BasePage {

    private final By heading = By.tagName("h1");
    private final By triggerDelayButton = By.cssSelector("[data-testid='dw-trigger-delayed']");
    private final By delayedResult = By.id("dw-delayed-result");
    private final By triggerSpinnerButton = By.cssSelector("[data-testid='dw-trigger-spinner']");
    private final By spinner = By.cssSelector("[data-testid='dw-spinner']");
    private final By spinnerContent = By.cssSelector("[data-testid='dw-spinner-content']");
    private final By armButton = By.cssSelector("[data-testid='dw-arm-enable']");
    private final By submitButton = By.id("dw-submit-btn");
    private final By raceButton = By.cssSelector("[data-testid='dw-trigger-race']");
    private final By raceElement = By.cssSelector("[data-testid='dw-race-target']");
    private final By submitButtonResult = By.id("result-s05");

    // ----- delayed element -----
    public void triggerDelayedElement() {
        click(triggerDelayButton);
    }

    public boolean isDelayedResultDisplayed() {
        return isVisible(delayedResult);
    }

    // ----- spinner -----
    public void loadContentWithSpinner() {
        click(triggerSpinnerButton);
        waitForInvisible(spinner);          // waits until the spinner is gone
        waitForVisible(spinnerContent);     // then waits for the content
    }

    public boolean isSpinnerContentDisplayed() {
        return isVisible(spinnerContent);
    }

    // ----- flaky element -----
    public String getRaceElementText() {
        click(raceButton);
        return text(raceElement);           // text() now waits and re-finds the element
    }

    // ----- enable then click -----
    public void armAndSubmit() {
        click(armButton);
        click(submitButton);                // click() waits until it is clickable
    }

    @Override
    public boolean isPageLoaded() {
        return isVisible(heading);
    }

    public String submitSuccessText() {
        return text(submitButtonResult);
    }
}