package studymate.tests;

import org.testng.annotations.DataProvider;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TestData {

    @DataProvider(name = "negativeLogin")
    public Object[][] negativeLoginData() {
        return new Object[][]{
                {"codewiser@gmail.com", "WiseCoder2024!", "User with email codewiser@gmail.com not found"},
                {"admin@codewise.academy", "Wrong123", "Invalid email or password"}
        };
    }
    @DataProvider(name = "positiveCreateNewGroups")
    public Object[][] positiveCreateNewGroups() {
        String todayDate = LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        return new Object[][]{
                {"https://codewise.studymate.us/admin/groups",
                        "Batch8", todayDate, "Full Stack SDET Course", "Group successfully saved"},
                {"https://codewise.studymate.us/admin/groups",
                        "Batch7", todayDate, "Full Stack SDET Course", "Group successfully saved"}

        };
    }

    @DataProvider(name = "positiveCreateNewStudents")
    public Object[][] positiveNewStudents() {
        return new Object[][]{
                {"https://codewise.studymate.us/admin/students",
                        "John", "Black", "2242963285", "john@gmail.com", "Batch8", "ONLINE",
                        "New student successfully saved"},
                {"https://codewise.studymate.us/admin/students",
                        "Robert", "Downey", "2242945869", "rob@gmail.com", "Batch7", "OFFLINE",
                        "New student successfully saved"},
                {"https://codewise.studymate.us/admin/students",
                        "Tom", "Hanks", "2242963274", "tom@gmail.com", "Batch8", "ONLINE",
                        "New student successfully saved"},
                {"https://codewise.studymate.us/admin/students",
                        "Marilyn", "Monroe", "2242963271", "monroe@gmail.com", "Batch7", "OFFLINE",
                        "New student successfully saved"},
                {"https://codewise.studymate.us/admin/students",
                        "Angelina", "Jolie", "2242963270", "jolie@gmail.com", "Batch8", "OFFLINE",
                        "New student successfully saved"}
        };
    }

    @DataProvider(name = "negativeCreateNewStudents")
    public Object[][] negativeCreateNewStudents() {
        return new Object[][]{
                {"https://codewise.studymate.us/admin/students",
                        "John", "White", "2242963285", "john@gmail.com", "Batch8", "ONLINE",
                        "User with the same email already exists"},
                {"https://codewise.studymate.us/admin/students",
                        "Robert", "Downey", "2242945869", "rob@gmail.com", "Batch7", "OFFLINE",
                        "User with the same email already exists"}
        };
    }

    @DataProvider(name = "positiveAddNewTeacher")
    public Object[][] positiveAddNewTeacher() {
        return new Object[][]{
                {"Jacob", "Grey", "9293455566", "jacobgrey@hotmail.com", "Computer Science", "Selenium", "Instructor successfully saved"},
                {"Alexander", "Bill", "9456345665", "alexander@hotmail.com", "Computer Science", "Cucumber", "Instructor successfully saved"},
                {"Kira", "Pak", "7373453344", "kirapak@hotmail.com", "Computer Science", "Cucumber", "Instructor successfully saved"},
        };
    }

    @DataProvider(name = "negativeTeacherCreation")
    public Object[][] negativeTeacherCreation() {
        return new Object[][]{
                {"Kate", "Peterson", "9293456655", "kirapak@hotmail.com", "Math", "Selenium", "User with the same email already exists"},
        };
    }

    @DataProvider(name = "positiveCreateNewAnnouncements")
    public Object[][] positiveCreateNewAnnouncements() {
        return new Object[][]{
                {"https://codewise.studymate.us/admin/announcements",
                        "Dear Students! You have mock interview in upcoming Friday! 03/20/2025", "Batch8",
                        "Announcement successfully saved"},
                {"https://codewise.studymate.us/admin/announcements",
                        "Dear Students! You have mock interview in upcoming Friday! 03/20/2025", "Batch7",
                        "Announcement successfully saved"}
        };
    }


}
