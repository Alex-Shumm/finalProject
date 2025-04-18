package studymate.tests;

import org.testng.annotations.Test;
import studymate.pages.AnnouncementsPage;
import studymate.pages.LoginPage;
import utils.ConfigReader;

public class AnnouncementTest extends BaseTest {

    @Test(dataProvider = "positiveCreateNewAnnouncements", dataProviderClass = TestData.class)
    public void validatePositiveGroupFunctionality(String expectedUrl, String textInput, String group, String expectedAnnouncementMessage) throws InterruptedException {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.happyLogin(ConfigReader.readProperty("username"), ConfigReader.readProperty("password"));

        AnnouncementsPage announcementsPage = new AnnouncementsPage(driver);
        announcementsPage.createNewAnnouncementsFunctionality(driver, expectedUrl, textInput, group, expectedAnnouncementMessage);

    }

}
