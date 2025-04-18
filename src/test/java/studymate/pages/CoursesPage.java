package studymate.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CoursesPage {
    public CoursesPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"root\"]/div/div[1]/nav/a[2]/li")
    public WebElement coursesTab;

    @FindBy(xpath = "//button[text()='Create course']")
    public WebElement createCourse;

    @FindBy(name = "courseName")
    public WebElement courseName;

    @FindBy(xpath = "//*[@name='dateOfFinish']")
    public WebElement date;

    @FindBy(css = "textarea[name='description']")
    public WebElement description;

    @FindBy(xpath = "//button[text()='Create']")
    public WebElement create;

    @FindBy(xpath = "(//button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeMedium css-1yxmbwk'])[2]")
    public WebElement editMenuButton;

    @FindBy(xpath = "(//*[text()='Delete'])[2]")
    public WebElement delete;

    @FindBy(xpath = "//button[@class='MuiButtonBase-root MuiButton-root MuiButton-contained MuiButton-containedError MuiButton-sizeMedium MuiButton-containedSizeMedium MuiButton-root MuiButton-contained MuiButton-containedError MuiButton-sizeMedium MuiButton-containedSizeMedium sc-eKJbhj iZsItr css-fab8xs']")
    public WebElement confirmDelete;

    @FindBy(xpath = "//*[text()='Trash']")
    public WebElement trashBin;

    @FindBy(xpath = "//tbody[@class='MuiTableBody-root css-1xnox0e']/tr")
    public List<WebElement> listOfElements;

    @FindBy(xpath = "//p[@class='sc-dkrFOg hbyUzQ']")
    public WebElement popUpWindow;

    @FindBy(name = "courseName")
    public WebElement updateCourseName;

    @FindBy(name = "dateOfFinish")
    public WebElement updateDate;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement saveButton;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement popUpButton;

    @FindBy(xpath = "//p[text()='The course successfully created']")
    public WebElement courseSuccessfullySavedAlert;

    @FindBy(xpath = "//p[text()='Course with the same title already exists']")
    public WebElement courseAlreadyExistsAlert;

}

