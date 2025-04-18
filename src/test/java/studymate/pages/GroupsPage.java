package studymate.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class GroupsPage {

    public GroupsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//li[.='Groups']")
    WebElement groupLink;

    @FindBy(xpath = "//button[.='Create group']")
    WebElement createGroupButton;

    @FindBy(xpath = "//img[@alt='there should be a photo here']")
    WebElement clickPicture;

    @FindBy(xpath = "//input[@type='file']")
    WebElement uploadFile;

    @FindBy(xpath = "//input[@name='name']")
    WebElement groupName;
    @FindBy(xpath = "//input[@placeholder='dd.mm.y']")
    WebElement date;

    @FindBy(xpath = "//textarea[@name='description']")
    WebElement description;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement createButton;

    @FindBy(xpath = "//p[.='Group successfully saved']")
    WebElement confirmationMessage;

    public void createNewGroupsFunctionality(WebDriver driver, String expectedUrl, String groupName, String date, String description, String expectedConfirmationMessage) throws InterruptedException {
        groupLink.click();
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);
        createGroupButton.click();

        this.groupName.sendKeys(groupName);

        this.date.sendKeys(date);
        this.description.sendKeys(description);

        //clickPicture.click();
        uploadFile.sendKeys("C://Users//shuma//OneDrive//Desktop//usa.png");

//        uploadPicture.sendKeys("C:/Users/Scott/Downloads/usa.png");

//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        WebElement uploadElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='file']")));
//        uploadElement.sendKeys("C://Users//Scott//Downloads//usa.png");

        createButton.click();

        Assert.assertEquals(confirmationMessage.getText(), expectedConfirmationMessage);
    }

}
