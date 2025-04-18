package studymate.tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import studymate.pages.CoursesPage;
import studymate.pages.LoginPage;
import utils.ConfigReader;
import utils.DriverHelper;

import java.time.Duration;

public class CourseTest extends BaseTest {

    WebDriver driver = DriverHelper.getDriver();
    WebDriverWait wait;
    LoginPage loginPage = new LoginPage(driver);
    CoursesPage coursesPage = new CoursesPage(driver);

    @Parameters({"courseTitle", "courseDate", "courseDesc"})
    @Test(priority = 1)
    public void validatePositiveTesting(String courseTitle, String courseDate, String courseDesc) throws InterruptedException {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        loginPage.happyLogin(ConfigReader.readProperty("username"),
                ConfigReader.readProperty("password"));
        Thread.sleep(2000);
        coursesPage.coursesTab.click();
        coursesPage.createCourse.click();
        coursesPage.courseName.sendKeys(courseTitle);
        coursesPage.date.sendKeys(courseDate);
        coursesPage.description.sendKeys(courseDesc);
        coursesPage.create.click();

        wait.until(ExpectedConditions.visibilityOf(coursesPage.courseSuccessfullySavedAlert));

        Assert.assertTrue(coursesPage.courseSuccessfullySavedAlert.getText()
                .contains("The course successfully created"));
    }
    @Parameters({"courseTitle", "courseDate", "courseDesc"})
    @Test(priority = 2)
    public void validateNegativeTesting(String courseTitle, String courseDate, String courseDesc) throws InterruptedException {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        loginPage.happyLogin(ConfigReader.readProperty("username"),
                ConfigReader.readProperty("password"));
        Thread.sleep(2000);
        coursesPage.coursesTab.click();
        coursesPage.createCourse.click();
        Thread.sleep(2000);
        coursesPage.courseName.sendKeys(courseTitle);
        coursesPage.date.sendKeys(courseDate);
        coursesPage.description.sendKeys(courseDesc);
        coursesPage.create.click();
        wait.until(ExpectedConditions.visibilityOf(coursesPage.courseAlreadyExistsAlert));

        Assert.assertTrue(coursesPage.courseAlreadyExistsAlert.getText().contains("Course with the same title already exists"));
    }

    @Test(priority = 3)
    public void validateCoursesPage() throws InterruptedException {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        loginPage.happyLogin(ConfigReader.readProperty("username"),
                ConfigReader.readProperty("password"));
        Thread.sleep(2000);
        coursesPage.coursesTab.click();
        Actions action = new Actions(driver);
        action.keyDown(coursesPage.updateCourseName, Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL);
        action.keyDown(coursesPage.updateCourseName, Keys.BACK_SPACE).keyUp(Keys.BACK_SPACE);
        action.perform();
        Thread.sleep(2000);
        coursesPage.updateCourseName.sendKeys("Edited course name to new Name");

        action.keyDown(coursesPage.updateDate, Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL);
        action.keyDown(coursesPage.updateDate, Keys.BACK_SPACE).keyUp(Keys.BACK_SPACE);
        action.perform();
        coursesPage.updateDate.sendKeys("14.03.25");
        coursesPage.saveButton.click();
        Thread.sleep(2000);
        Assert.assertTrue(coursesPage.popUpButton.isDisplayed());
    }

    @Test(priority = 4)
    public void validateDeleteFunctionality() throws InterruptedException {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        loginPage.happyLogin(ConfigReader.readProperty("username"),
                ConfigReader.readProperty("password"));
        Thread.sleep(2000);
        coursesPage.coursesTab.click();
        coursesPage.editMenuButton.click();
        Thread.sleep(2000);
        coursesPage.delete.click();
        coursesPage.confirmDelete.click();
        Assert.assertTrue(coursesPage.popUpWindow.isDisplayed());
        coursesPage.trashBin.click();
        Thread.sleep(2000);

        boolean isElementFound = false;
        for (WebElement element : coursesPage.listOfElements) {
            if (element.getText().contains("Course")) {
                isElementFound = true;
                System.out.println(isElementFound);
                break;
            }
        }
        Assert.assertTrue(isElementFound);
    }
}
