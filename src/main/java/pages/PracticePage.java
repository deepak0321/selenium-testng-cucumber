package pages;

import org.openqa.selenium.By;


public class PracticePage extends BasePage {

    private final By dynamicWaitsLink = By.cssSelector("[data-testid='new-practice-card-dynamic-waits']");
    private final By shadowDOMLink = By.cssSelector("[data-testid='new-practice-card-shadow-dom']");

    public void goToDynamicWaits() {
        click(dynamicWaitsLink);
    }

    public void goToShadowDOM() {
        click(shadowDOMLink);
    }

    @Override
    public boolean isPageLoaded() {
        return isVisible(dynamicWaitsLink);
    }
}
