package studymate.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.ConfigReader;
import utils.DriverHelper;

public class BaseTest {
    public WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = DriverHelper.getDriver();
        driver.get(ConfigReader.readProperty("studymateLogin_url"));
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
