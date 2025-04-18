package studymate.tests;

import org.testng.annotations.Test;
import studymate.pages.GoToPage;
import studymate.pages.LoginPage;
import studymate.pages.TrashPage;
import utils.ConfigReader;

import java.util.Arrays;
import java.util.List;

public class TrashTest extends BaseTest{

    @Test(priority = 1)
    public void validateDeletedItemInTrashFunctionality(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.happyLogin(ConfigReader.readProperty("username"), ConfigReader.readProperty("password"));
        GoToPage goToPage = new GoToPage(driver);
        goToPage.switchPage("Trash");
        TrashPage trashPage = new TrashPage(driver);
        List<String> expectedDeletedItemInfo = Arrays.asList("Test Test", "2025-03-14");
        trashPage.validateNameAndDateDeletedItem(expectedDeletedItemInfo
        , "Items in the cart are automatically deleted after 7 days from the date of adding!");
    }

    @Test(priority = 2)
    public void deleteFromTrashFunctionality() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.happyLogin(ConfigReader.readProperty("username"), ConfigReader.readProperty("password"));
        GoToPage goToPage = new GoToPage(driver);
        goToPage.switchPage("Trash");
        TrashPage trashPage = new TrashPage(driver);
        trashPage.deleteFromTrash("Data deleted successfully", "Test Test");
    }
}
