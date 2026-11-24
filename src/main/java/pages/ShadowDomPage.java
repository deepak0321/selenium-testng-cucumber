package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ShadowDomPage extends BasePage {

    private final By heading = By.xpath("//h1[text()='How to Automate Shadow DOM in Selenium and Playwright']");
    private final By shadowBasicButton = By.cssSelector("[data-testid='shadow-btn-basic']");
    private final By shadowHostBasic = By.cssSelector("[data-testid='shadow-host-basic']");
    private final By shadowBasicResultText = By.id("result-s01");

    @Override
    public boolean isPageLoaded() {
        return isVisible(heading);
    }

    public void clickShadowBasicButton() {
        WebElement element = findShadowElement(shadowHostBasic, shadowBasicButton);
        click(element);
    }

    public String shadowBasicActionText() {
        return text(shadowBasicResultText);
    }
}
