package pages;

import org.openqa.selenium.By;

public class DynamicWaitsPage extends BasePage {

    private final By heading1 = By.tagName("h1");
    private final By triggerDelayButton = By.cssSelector("[data-testid='dw-trigger-delayed']");
    private final By delayedResult = By.id("dw-delayed-result");
    private final By triggerSpinnerButton = By.cssSelector("[data-testid='dw-trigger-spinner']");
    private final By delayedSpinnerContent = By.cssSelector("[data-testid='dw-spinner-content']");
    private final By spinner = By.cssSelector("[data-testid='dw-spinner']");
    private final By armButton = By.cssSelector("[data-testid='dw-arm-enable']");
    private final By submitButton = By.id("dw-submit-btn");
    private final By raceElement = By.cssSelector("[data-testid='dw-race-target']");
    private final By raceButton = By.cssSelector("[data-testid='dw-trigger-race']");

    public void checkDelayedSpinner(){
        click(triggerSpinnerButton);
        isVisible(spinner);
        isInvisible(spinner);
        isVisible(delayedSpinnerContent);
    }

    public String checkFlakyElement(){
        click(raceButton);
        isVisible(raceElement);
        return text(raceElement);

    }

    public void checkButtonEnableAndClickable(){
        click(armButton);
        click(submitButton);
    }

    public void checkDelayedAppearance(){
        click(triggerDelayButton);
        isVisible(delayedResult);
    }



    @Override
     public boolean isPageLoaded() {
        return isVisible(heading1);
    }
}
