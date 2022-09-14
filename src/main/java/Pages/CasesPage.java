package Pages;

import Browser.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class CasesPage {
    WebDriver driver= Browser.driver;

    @FindBy(name = "cs_keyword")
    WebElement keywordElement;

    @FindBy(css = "input[value='Search']")
    WebElement searchButton;

    public CasesPage navigateToSearchCasesTitle(String title){
        keywordElement.sendKeys(title);
        searchButton.click();
        return this;

    }
    public CasesPage validateSearchCasesNo(String number){
        List<WebElement> list=driver.findElements(By.className("datalistrow"));
        Assert.assertEquals(list.get(5).getText(),number);
        return this;
    }
}
