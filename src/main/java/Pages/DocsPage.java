package Pages;

import Browser.Browser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class DocsPage {

    WebDriver driver = Browser.driver;

    @FindBy(linkText = "Screenshot.png")
    WebElement fileElement;

    public DocsPage validateFilePresence(){
        Assert.assertEquals(fileElement.getText(), MultiDocUploadPage.fileName);
        return PageFactory.initElements(driver, DocsPage.class);
    }
}