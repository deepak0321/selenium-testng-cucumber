package testng.tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FormsPage;
import pages.HomePage;
import testng.base.BaseTest;
import testng.builders.UserBuilder;
import testng.providers.UserDataProvider;
import utils.JsonReader;

public class FormsTest extends BaseTest {


    @Test(description = "Forms Input Test")
    public void formsTest() {
        User user = JsonReader.read("test-data/json/user.json", User.class);
        HomePage homePage = new HomePage();
        Assert.assertTrue(homePage.isPageLoaded());
        FormsPage formsPage = homePage.goToPracticePage().goToForms();
        formsPage.fillPersonalDetailsForm(user);
    }

    @Test(description = "Forms Input Test With Data Providers", dataProvider = "users", dataProviderClass = UserDataProvider.class)
    public void formsTestWithDataProviders(User user) {
        HomePage homePage = new HomePage();
        Assert.assertTrue(homePage.isPageLoaded());
        FormsPage formsPage = homePage.goToPracticePage().goToForms();
        formsPage.fillPersonalDetailsForm(user);
    }

    @Test(description = "Forms Input Test With Excel Data Providers", dataProvider = "excelUsers", dataProviderClass = UserDataProvider.class)
    public void formsTestWithExcelDataProviders(User user) {
        HomePage homePage = new HomePage();
        Assert.assertTrue(homePage.isPageLoaded());
        FormsPage formsPage = homePage.goToPracticePage().goToForms();
        formsPage.fillPersonalDetailsForm(user);
        Assert.assertTrue(formsPage.isSuccess());
    }

    @Test(description = "Forms Input Test With User Data Builder")
    public void formsTestWithUserDataBuilder() {
        HomePage homePage = new HomePage();
        Assert.assertTrue(homePage.isPageLoaded());
        FormsPage formsPage = homePage.goToPracticePage().goToForms();
        User user = new UserBuilder().firstName("dorothy").lastName("kumar").withUniquePhone().dob("29-03-2003").gender("others").build();
        formsPage.fillPersonalDetailsForm(user);
        Assert.assertTrue(formsPage.isSuccess());
    }


}
