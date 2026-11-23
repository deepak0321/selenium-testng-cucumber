package pages;

import org.openqa.selenium.By;
import utils.ConfigReader;

public class HomePage extends BasePage{

    private final By startPractisingFreeLink = By.cssSelector("[data-testid='hero-start-practicing']");

    public void openWebsite(){
        driver.get(ConfigReader.get("url"));
    }

    public void gotToPracticePage(){
        click(startPractisingFreeLink);
    }
    @Override
    public boolean isPageLoaded() {
        return isVisible(startPractisingFreeLink);
    }
}
