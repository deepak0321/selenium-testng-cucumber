package pages;

import org.openqa.selenium.By;
import utils.ConfigReader;

public class HomePage extends BasePage {

    private final By startPracticingFreeLink = By.cssSelector("[data-testid='hero-start-practicing']");

    public PracticePage goToPracticePage() {
        click(startPracticingFreeLink);
        return new PracticePage();
    }

    @Override
    public boolean isPageLoaded() {
        return isVisible(startPracticingFreeLink);
    }
}
