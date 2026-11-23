package pages;

import org.openqa.selenium.By;

public class DynamicWaitsPage extends BasePage {

    private final By heading1 = By.tagName("h1");

    @Override
     public boolean isPageLoaded() {
        return isVisible(heading1);
    }
}
