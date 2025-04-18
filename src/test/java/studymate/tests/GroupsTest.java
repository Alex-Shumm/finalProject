package studymate.tests;

import org.testng.annotations.Test;
import studymate.pages.GroupsPage;
import studymate.pages.LoginPage;
import utils.ConfigReader;

public class GroupsTest extends BaseTest{
    @Test(dataProvider = "positiveCreateNewGroups", dataProviderClass = TestData.class)
    public void validatePositiveGroupFunctionality(String expectedUrl, String groupName, String date,
                                                   String description, String expectedConfirmationMessage) throws InterruptedException {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.happyLogin(ConfigReader.readProperty("username"), ConfigReader.readProperty("password"));

        GroupsPage groupsPage = new GroupsPage(driver);
        groupsPage. createNewGroupsFunctionality(driver, expectedUrl, groupName, date, description, expectedConfirmationMessage);

}

}
