package Pages;

import Browser.Browser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CasesPage {

    WebDriver driver = Browser.driver;

    @FindBy(name = "cs_keyword")
    WebElement keyWordElement;

    @FindBy(css = "input[value='Search']")
    WebElement searchButton;

    public CasesPage verifyCasesTitle(String title) {
        keyWordElement.sendKeys(title);
        searchButton.click();
        return this;
    }
}