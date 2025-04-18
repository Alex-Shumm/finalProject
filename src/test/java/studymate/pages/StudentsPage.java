package studymate.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.BrowserUtils;

import java.time.Duration;
import java.util.List;

public class StudentsPage {

    public StudentsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(linkText = "Students")
    WebElement studentsButton;

    @FindBy(xpath = "//div[@class='MuiInputBase-root MuiInputBase-colorPrimary css-pm7v0q']")
    WebElement searchBox;

    @FindBy(xpath = "//button[contains(@class, 'css-79mk38')]")
    WebElement addStudentButton;

    @FindBy(xpath = "//button[contains(@class, 'css-jlubt3')]")
    WebElement importExelButton;

    @FindBy(xpath = "//button[contains(@class, 'MuiIconButton-root')][2]")
    WebElement searchParametersButton;
    @FindBy(xpath = "//input[@name='name']")

    WebElement firstName;

    @FindBy(xpath = "//input[@name='lastName']")
    WebElement lastName;

    @FindBy(css = ".css-6vwzer")
    WebElement phone;

    @FindBy(css = "#mui-component-select-groupId")
    WebElement groupBox;

    @FindBy(xpath = "//input[@name='email']")
    WebElement email;

    @FindBy(css = "#mui-component-select-studyFormat")
    WebElement studyFormatBox;

    @FindBy(xpath = "//div[@class='sc-gKPRtg gmDlqC actions']//button[contains(@class, 'css-79mk38')]")
    WebElement addButton;

    @FindBy(xpath = "//li[.='Batch8']")
    WebElement batch8Button;

    @FindBy(xpath = "//li[.='Batch7']")
    WebElement batch7Button;

    @FindBy(xpath = "//li[@data-value='ONLINE']")
    WebElement online;

    @FindBy(xpath = "//li[@data-value='OFFLINE']")
    WebElement offline;

    @FindBy(xpath = "//p[contains(text(),'successfully saved')]")
    WebElement successfulMessage;

    @FindBy(xpath = "//p[contains(text(),'already exists')]")
    WebElement negativeMessage;

    @FindBy(xpath = "//div[@class='css-yys58j']//button[contains(@class,'css-1yxmbwk')]")
    List<WebElement> elementList;

    @FindBy(xpath = "//li[.='Delete']//span[@class='MuiTouchRipple-root css-w0pj6f']")
    WebElement deleteButton;

    @FindBy(xpath = "//button[contains(@class,'css-fab8xs')]")
    WebElement confirmationDeleteButton;

    @FindBy(xpath = "//p[contains(text(),'successfully deleted')]")
    WebElement deleteMessage;

    public void createNewStudentFunctionality(WebDriver driver, String expectedUrl, String firstName, String lastName,
                                              String phone, String email, String group, String studyFormat) throws InterruptedException {
        studentsButton.click();
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);

        addStudentButton.click();
        this.firstName.sendKeys(firstName);
        this.lastName.sendKeys(lastName);
        this.phone.click();
        this.phone.sendKeys(phone);
        this.email.sendKeys(email);

        Actions actions = new Actions(driver);

        this.groupBox.click();
        Thread.sleep(1000);
        if (group.equalsIgnoreCase("Batch8")) {
            actions.moveToElement(batch8Button).click().perform();
        } else if (group.equalsIgnoreCase("Batch7")) {
            actions.moveToElement(batch7Button).click().perform();
        }

        this.studyFormatBox.click();
        Thread.sleep(1000);

        if (studyFormat.toUpperCase().contains("ONLINE")) {
            actions.moveToElement(online).click().perform();
        } else if (studyFormat.toUpperCase().contains("OFFLINE")) {
            actions.moveToElement(offline).click().perform();
        }
        addButton.click();
    }

    public void validateHappyPath(WebDriver driver, String expectedMessage) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(successfulMessage));

        Assert.assertEquals(BrowserUtils.getText(successfulMessage), expectedMessage);
    }

    public void validateDuplicateStudents(WebDriver driver, String expectedNegativeMessage) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(negativeMessage));

        Assert.assertEquals(BrowserUtils.getText(negativeMessage), expectedNegativeMessage);
    }

//    public void validateDeleteStudentsFunctionality(WebDriver driver, String expectedDeleteMessage) throws InterruptedException {
//        studentsButton.click();
//
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.visibilityOfAllElements(elementList));
//
//        Actions actions = new Actions(driver);
//
//        while (!elementList.isEmpty()) {
//            WebElement studentElement = elementList.get(0); // Всегда берем первого
//            studentElement.click();
//
//            wait.until(ExpectedConditions.elementToBeClickable(deleteButton));
//            actions.moveToElement(deleteButton).click().perform();
//
//            wait.until(ExpectedConditions.elementToBeClickable(confirmationDeleteButton));
//            confirmationDeleteButton.click();
//
//            wait.until(ExpectedConditions.visibilityOf(deleteMessage));
//            Assert.assertEquals(BrowserUtils.getText(deleteMessage), expectedDeleteMessage);
//
//
//            // elementList = driver.findElements(By.xpath("//div[@class='css-yys58j']//button[contains(@class,'css-1yxmbwk')]"));
//}

}
