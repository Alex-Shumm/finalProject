package studymate.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class GoToPage {

    public GoToPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//li[@class='MuiListItem-root MuiListItem-gutters MuiListItem-padding sc-idXgbr VObHa css-1yo8bqd']")
    List<WebElement> allPages;

    public void switchPage(String pageName){
        for (WebElement page : allPages){
            if (page.getText().contains(pageName)){
                page.click();
            }
        }
    }
}
