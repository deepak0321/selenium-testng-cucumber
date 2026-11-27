package pages;

import org.openqa.selenium.By;


public class PracticePage extends BasePage {

    private final By dynamicWaitsLink = By.cssSelector("[data-testid='new-practice-card-dynamic-waits']");
    private final By shadowDOMLink = By.cssSelector("[data-testid='new-practice-card-shadow-dom']");
    private final By formsLink = By.cssSelector("[data-testid='new-practice-card-forms']");

    public FormsPage goToForms(){
        click(formsLink);
        return new FormsPage();
    }

    public DynamicWaitsPage goToDynamicWaits() {
        click(dynamicWaitsLink);
        return new DynamicWaitsPage();
    }

    public ShadowDomPage goToShadowDOM() {
        click(shadowDOMLink);
        return new ShadowDomPage();
    }

    @Override
    public boolean isPageLoaded() {
        return isVisible(dynamicWaitsLink);
    }
}
