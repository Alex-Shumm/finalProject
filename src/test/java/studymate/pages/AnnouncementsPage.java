package studymate.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class AnnouncementsPage {

    public AnnouncementsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//li[.='Announcements']")
    WebElement announcementLink;

    @FindBy(xpath = "//button[.='Add an announcement']")
    WebElement addAnnouncementButton;

    @FindBy(xpath = "//textarea")
    WebElement textInput;

    @FindBy(css = "#mui-component-select-groups")
    WebElement groupSelectButton;

    @FindBy(xpath = "//li[.='Batch8']")
    WebElement batch8Group;

    @FindBy(xpath = "//li[.='Batch7']")
    WebElement batch7Group;

    @FindBy(xpath = "//button[.='Add']")
    WebElement add_btn;

    @FindBy(xpath = "//p[contains(text(),'successfully saved')]")
    WebElement announcementMessage;


    public void createNewAnnouncementsFunctionality(WebDriver driver, String expectedUrl, String textInput, String group, String expectedAnnouncementMessage) throws InterruptedException {
        announcementLink.click();

        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);
        addAnnouncementButton.click();

        this.textInput.sendKeys(textInput);

        Actions actions = new Actions(driver);

        this.groupSelectButton.click();
        Thread.sleep(1000);
        if (group.equalsIgnoreCase("Batch8")) {
            actions.moveToElement(batch8Group).click().perform();
        } else if (group.equalsIgnoreCase("Batch7")) {
            actions.moveToElement(batch7Group).click().perform();
        }
        Thread.sleep(1000);
        add_btn.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(announcementMessage));
        Assert.assertEquals(announcementMessage.getText(), expectedAnnouncementMessage);
    }

}
