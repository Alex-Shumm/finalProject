package studymate.tests;

import org.testng.annotations.Test;
import studymate.pages.LoginPage;
import studymate.pages.TeachersPage;
import utils.ConfigReader;

public class TeachersTest extends BaseTest {

    @Test(priority = 1, dataProvider = "positiveAddNewTeacher", dataProviderClass = TestData.class)
    public void validateAddTeacherFunctionality(String teachersFirstName, String teacherLastName, String teachersPhoneNumber,
                                                String teachersEmail, String specialization, String chooseCourse, String expectedMessage) throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.happyLogin(ConfigReader.readProperty("username"), ConfigReader.readProperty("password"));

        TeachersPage teachersPage = new TeachersPage(driver);
        teachersPage.AddTeacherFunctionality(driver, teachersFirstName, teacherLastName, teachersPhoneNumber,
                teachersEmail, specialization, chooseCourse);
        teachersPage.validateSuccessfulTeacherAdding(driver, expectedMessage);

    }

    @Test(priority = 2, dataProvider = "negativeTeacherCreation", dataProviderClass = TestData.class)
    public void validateNegativePath(String teachersFirstName, String teacherLastName, String teachersPhoneNumber,
                                     String teachersEmail, String specialization, String chooseCourse, String expectedErrorMessage) throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.happyLogin(ConfigReader.readProperty("username"), ConfigReader.readProperty("password"));

        TeachersPage teachersPage = new TeachersPage(driver);
        teachersPage.AddTeacherFunctionality(driver, teachersFirstName, teacherLastName,
                teachersPhoneNumber, teachersEmail, specialization, chooseCourse);
        teachersPage.validateDuplicateTeachers(driver, expectedErrorMessage);
    }

}
