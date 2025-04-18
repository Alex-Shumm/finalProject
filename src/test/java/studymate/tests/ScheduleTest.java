package studymate.tests;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import studymate.pages.GoToPage;
import studymate.pages.LoginPage;
import studymate.pages.SchedulePage;
import utils.ConfigReader;

public class ScheduleTest extends BaseTest{

    @Test(priority = 1)
    public void createScheduleFunctionality() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.happyLogin(ConfigReader.readProperty("username"), ConfigReader.readProperty("password"));
        GoToPage go = new GoToPage(driver);
        go.switchPage("Schedule");
        SchedulePage schedulePage = new SchedulePage(driver);
        schedulePage.createSchedule("13.03.2025", "13:00", "15:00",
                "Cucumber Class", "ЧТ", "20.03.2025");
    }

    @Test(priority = 2)
    public void validateCreatedScheduleFunctionality(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.happyLogin(ConfigReader.readProperty("username"), ConfigReader.readProperty("password"));
        GoToPage go = new GoToPage(driver);
        go.switchPage("Schedule");
        SchedulePage schedulePage = new SchedulePage(driver);
        schedulePage.validateCreatedSchedule("rgba(246, 191, 38, 1)", "Cucumber Class", "13:00 - 15:00");
    }
}
