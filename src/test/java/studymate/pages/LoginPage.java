package studymate.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.BrowserUtils;
import utils.ConfigReader;
import utils.DriverHelper;

public class LoginPage {
    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    public WebDriver driver = DriverHelper.getDriver();

    @FindBy(xpath = "//input[@id=':r0:']")
    WebElement username;

    @FindBy(xpath = "//input[@id=':r1:']")
    WebElement password;

    @FindBy(xpath = "//button[.='Log in']")
    WebElement loginButton;

    @FindBy(xpath = "//p[@class='sc-dkrFOg hbyUzQ']")
    WebElement errorMessage;

    @FindBy(xpath = "//p[.='Administrator']")
    WebElement adminButton;

    @FindBy(xpath = "//li[contains(@class,'css-1km1ehz')]")
    WebElement logoutButton;

    @FindBy(xpath = "//button[.='Log out']")
    WebElement confirmLogoutButton;

    public void happyLogin(String username, String password){
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        loginButton.click();
    }

    public void negativeLogin(String username, String password, String message){
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        loginButton.click();
        Assert.assertEquals(BrowserUtils.getText(errorMessage), message);
    }

    public void logout(){
        adminButton.click();
        BrowserUtils.scrollWithJS(driver, logoutButton);
        logoutButton.click();
        confirmLogoutButton.click();
    }
}
