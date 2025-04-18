package studymate.tests;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import studymate.pages.LoginPage;
import studymate.pages.TrashPage;
import utils.ConfigReader;

public class LoginTest extends BaseTest {
    @Parameters({"url", "title"})
    @Test
    public void validateHappyPathLoginFunctionality(String url, String title) throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.happyLogin(ConfigReader.readProperty("username"), ConfigReader.readProperty("password"));
        Thread.sleep(2000);
        Assert.assertEquals(driver.getCurrentUrl(), ConfigReader.readProperty("studymateGroup_url"));
        Assert.assertEquals(driver.getTitle(), title);
    }

    @Test(dataProvider = "negativeLogin", dataProviderClass = TestData.class)
    public void validateNegativePathLoginFunctionality(String username, String password, String message){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.negativeLogin(username, password, message);
    }

    @Test
    public void validateLogoutFunctionality() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.happyLogin(ConfigReader.readProperty("username"), ConfigReader.readProperty("password"));
        Thread.sleep(1000);
        loginPage.logout();
        Assert.assertEquals(driver.getCurrentUrl(), ConfigReader.readProperty("studymateLogout_url"));
    }
}
