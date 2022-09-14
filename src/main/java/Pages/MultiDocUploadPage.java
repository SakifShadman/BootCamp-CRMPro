package Pages;

import Browser.Browser;
import Utilities.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MultiDocUploadPage {

    WebDriver driver = Browser.driver;

    String filePath = "C://Users//arnob//Pictures//";
    public static String fileName = "Screenshot.png";

    @FindBy(name = "file1")
    WebElement uploadFileElement;

    @FindBy(xpath = "//input[@value='Save']")
    WebElement saveButton;

    public MultiDocUploadPage validateUploadFile() {
        uploadFileElement.sendKeys(filePath + fileName);
        Utils.explicitWait(saveButton).click();
        return this;
    }
}