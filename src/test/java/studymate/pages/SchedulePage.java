package studymate.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class SchedulePage {

    public SchedulePage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[contains(@class,'css-79mk38')]")
    WebElement createEventButton;

    @FindBy(xpath = "//div[.='Schedule']")
    WebElement scheduleButton;

    @FindBy(css = "#startDate")
    WebElement startDate;

    @FindBy(css = "#startTime")
    WebElement startTime;

    @FindBy(css = "#endTime")
    WebElement endTime;

    @FindBy(xpath = "//input[@name='title']")
    WebElement className;

    @FindBy(css = "#mui-component-select-groupIds")
    WebElement chooseGroup;

    @FindBy(xpath = "//li[.='Batch7']")
    WebElement groupName;

    @FindBy(xpath = "//button[.='Пн']")
    WebElement mondayButton;

    @FindBy(xpath = "//button[.='ВТ']")
    WebElement tuesdayButton;

    @FindBy(xpath = "//button[.='СР']")
    WebElement wednesdayButton;

    @FindBy(xpath = "//button[.='ЧТ']")
    WebElement thursdayButton;

    @FindBy(xpath = "//button[.='ПТ']")
    WebElement fridayButton;

    @FindBy(xpath = "//button[.='СБ']")
    WebElement saturdayButton;

    @FindBy(xpath = "//button[.='ВС']")
    WebElement sundayButton;

    @FindBy(xpath = "//input[@name='endDate']")
    WebElement endDate;

    @FindBy(xpath = "//div[@class='sc-bhNKFk hVVIor']//div[@color='rgb(246, 191, 38)']")
    WebElement yellowColor;

    @FindBy(xpath = "//button[.='Publish']")
    WebElement publishButton;

    @FindBy(xpath = "//td[@data-date='2025-03-13']/*/*[2]/*[1]/*/*/*")
    WebElement startDateColor;

    @FindBy(xpath = "//td[@data-date='2025-03-13']/*/*[2]/*[1]/*/*/*/*[1]")
    WebElement startClassName;

    @FindBy(xpath = "//td[@data-date='2025-03-13']/*/*[2]/*[1]/*/*/*/*[2]")
    WebElement startRangeTime;

    @FindBy(xpath = "//td[@data-date='2025-03-20']/*/*[2]/*[1]/*/*/*")
    WebElement endDateColor;

    @FindBy(xpath = "//td[@data-date='2025-03-20']/*/*[2]/*[1]/*/*/*/*[1]")
    WebElement endClassName;

    @FindBy(xpath = "//td[@data-date='2025-03-20']/*/*[2]/*[1]/*/*/*/*[2]")
    WebElement endRangeTime;

    @FindBy(xpath = "//p[.='Event successfully saved']")
    WebElement successAddScheduleMessage;

    public void createSchedule(String startDate, String startTime, String endTime,
                               String className, String weekDay, String endDate) throws InterruptedException {
        createEventButton.click();
        scheduleButton.click();
        this.startDate.sendKeys(startDate);
        this.startTime.click();
        this.startTime.sendKeys(startTime);
        this.endTime.click();
        this.endTime.sendKeys(endTime);
        this.className.sendKeys(className);
        chooseGroup.click();
        groupName.click();
        switch (weekDay){
            case "Пн":
                mondayButton.click();
                break;
            case "ВТ":
                tuesdayButton.click();
                break;
            case "СР":
                wednesdayButton.click();
                break;
            case "ЧТ" :
                thursdayButton.click();
                break;
            case "ПТ":
                fridayButton.click();
                break;
            case "СБ":
                saturdayButton.click();
                break;
            case "ВС":
                sundayButton.click();
                break;
        }
        this.endDate.sendKeys(endDate);
        yellowColor.click();
        publishButton.click();
        Assert.assertEquals(successAddScheduleMessage.getText(), "Event successfully saved");
    }

    public void validateCreatedSchedule(String color, String className, String rangeTime){

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(startDateColor.getCssValue("color"), color);
        softAssert.assertEquals(endDateColor.getCssValue("color"), color);
        softAssert.assertEquals(startClassName.getText(), className);
        softAssert.assertEquals(endClassName.getText(), className);
        softAssert.assertEquals(startRangeTime.getText(), rangeTime);
        softAssert.assertEquals(endRangeTime.getText(), rangeTime);
        softAssert.assertAll();
    }

}
