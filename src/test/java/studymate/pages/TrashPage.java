package studymate.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class TrashPage {

    public TrashPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//p[@class='sc-dEVLtI ffxMPc']")
    WebElement trashHeader;

    @FindBy(xpath = "//tbody//tr[1]//td")
    List<WebElement> deletedItem;

    @FindBy(xpath = "/html/body/div/div/div[2]/div/div/div/div/div/div/table/tbody/tr[1]/td[3]/div/*[2]")
    WebElement deleteFromTrashButton;

    @FindBy(xpath = "/html/body/div/div/div[2]/div/div/div/div/div/div/table/tbody/tr[1]/td[3]/div/*[1]")
    WebElement recoverFromTrashButton;

    @FindBy(xpath = "//p[.='Data deleted successfully']")
    WebElement deletedFromTrashMessage;

    @FindBy(xpath = "//p[.='Data successfully recovered']")
    WebElement recoveredFromTrashMessage;



    public void validateNameAndDateDeletedItem(List<String> expectedDeletedItemInfo, String header){
        Assert.assertEquals(trashHeader.getText(), header);
        for (int i = 0; i < deletedItem.size() - 1; i++){
            Assert.assertEquals(deletedItem.get(i).getText(), expectedDeletedItemInfo.get(i));
        }
    }

    public void deleteFromTrash(String message, String name) throws InterruptedException {
        deleteFromTrashButton.click();
        Assert.assertEquals(deletedFromTrashMessage.getText(), message);
        Thread.sleep(1000);
        Assert.assertNotEquals(deletedItem.get(0).getText(), name);
    }

//    public void recoverFromTrash(String message){
//        recoverFromTrashButton.click();
//        Assert.assertEquals(recoveredFromTrashMessage.getText(),message);
//    }
}
