package pages;

import models.User;
import org.openqa.selenium.By;

public class FormsPage extends BasePage {

    private final By firstNameInput = By.id("firstName");
    private final By lastNameInput = By.id("lastName");
    private final By phoneInput = By.id("phone");
    private final By dobInput = By.id("dob");
    private final By genderMaleRadio = By.id("gender-male");
    private final By genderFemaleRadio = By.id("gender-female");
    private final By genderOtherRadio = By.id("gender-other");
    private final By saveDetailsButton = By.id("personalSubmitBtn");
    private final By successMessage = By.cssSelector("#personalResult"); // adjust

    public void fillPersonalDetailsForm(User user) {
        type(firstNameInput, user.getFirstName());
        type(lastNameInput, user.getLastName());
        type(phoneInput, user.getPhone());
        type(dobInput, user.getDob());
        selectGender(user.getGender());
        click(saveDetailsButton);
    }

    public boolean isSuccess() {
        return isVisible(successMessage);
    }

    @Override
    public boolean isPageLoaded() {
        return isVisible(firstNameInput);
    }

    private void selectGender(String gender) {
        if ("male".equalsIgnoreCase(gender)) {
            click(genderMaleRadio);
        } else if ("female".equalsIgnoreCase(gender)) {
            click(genderFemaleRadio);
        } else {
            click(genderOtherRadio);
        }
    }
}