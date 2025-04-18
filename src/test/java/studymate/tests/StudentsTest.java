package studymate.tests;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;
import studymate.pages.LoginPage;
import studymate.pages.StudentsPage;
import utils.ConfigReader;

public class StudentsTest extends BaseTest {

    @Test(priority = 1, dataProvider = "positiveCreateNewStudents", dataProviderClass = TestData.class)
    public void validatePositiveStudentsFunctionality(String expectedUrl, String firstName, String lastName,
                                                      String phone, String email, String group,
                                                      String studyFormat, String expectedMessage) throws InterruptedException {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.happyLogin(ConfigReader.readProperty("username"), ConfigReader.readProperty("password"));

        StudentsPage studentsPage = new StudentsPage(driver);

        studentsPage.createNewStudentFunctionality(driver, expectedUrl, firstName, lastName, phone, email, group, studyFormat);
        studentsPage.validateHappyPath(driver, expectedMessage);
    }

    @Test(priority = 2, dataProvider = "negativeCreateNewStudents", dataProviderClass = TestData.class)
    public void validateNegativeStudentsFunctionality(String expectedUrl, String firstName, String lastName,
                                                      String phone, String email, String group,
                                                      String studyFormat, String expectedNegativeMessage) throws InterruptedException {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.happyLogin(ConfigReader.readProperty("username"), ConfigReader.readProperty("password"));

        StudentsPage studentsPage = new StudentsPage(driver);

        studentsPage.createNewStudentFunctionality(driver, expectedUrl, firstName, lastName, phone, email, group, studyFormat);
        studentsPage.validateDuplicateStudents(driver, expectedNegativeMessage);

        
    }

//    @Test
//    public void validateDeleteStudentsFunctionality() throws InterruptedException {
//        LoginPage loginPage = new LoginPage(driver);
//        loginPage.happyLogin(ConfigReader.readProperty("username"), ConfigReader.readProperty("password"));
//
//        StudentsPage studentsPage = new StudentsPage(driver);
//        //studentsPage.validateDeleteStudentsFunctionality(driver, "Student successfully deleted");
//    }

}
