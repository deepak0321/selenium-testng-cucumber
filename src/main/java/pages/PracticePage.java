package pages;

import org.openqa.selenium.By;
import utils.ConfigReader;

public class PracticePage extends BasePage {

    private final By dynamicWaitsLink = By.cssSelector("[data-testid='new-practice-card-dynamic-waits']");

    public void goToDynamicWaits(){
        click(dynamicWaitsLink);
    }

    @Override
    public boolean isPageLoaded() {
        return isVisible(dynamicWaitsLink);
    }
}
