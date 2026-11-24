package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ShadowDomPage extends BasePage{


    private final By headingText = By.xpath("//h1[text()='How to Automate Shadow DOM in Selenium and Playwright']");
    private final By shadowBasicButton = By.cssSelector("[data-testid='shadow-btn-basic']");
    private final By shadowHostBasic = By.cssSelector("[data-testid='shadow-host-basic']");

    @Override
    public boolean isPageLoaded() {
        return isVisible(headingText);
    }

    public void clickShadowBasicButton(){
        WebElement element = findShadowElement(shadowHostBasic,shadowBasicButton);
        click(element);
    }

}
