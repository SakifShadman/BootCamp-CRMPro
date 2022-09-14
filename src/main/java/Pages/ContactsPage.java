package Pages;

import Browser.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class ContactsPage {
    WebDriver driver= Browser.driver;

    @FindBy(css = "input[name='cs_name']")
    WebElement nameElement;

    @FindBy(css = "input[value='Search']")
    WebElement searchButton;

    public ContactsPage searchContactsName(String name) {
        nameElement.sendKeys(name);
        searchButton.click();
        return this;
    }
    public ContactsPage validateContactCompany(String company){
        List<WebElement> list=driver.findElements(By.xpath("//form[@id='vContactsForm']//tr[4]//td"));
        Assert.assertEquals(list.get(2).getText(),company);
        return this;
    }
    public ContactsPage validateContactPhone(String phone){
        List<WebElement> list=driver.findElements(By.xpath("//form[@id='vContactsForm']//tr[4]//td"));
        Assert.assertEquals(list.get(3).getText(),phone);
        return this;
    }
    public ContactsPage validateContactEmail(String email){
        List<WebElement> list=driver.findElements(By.xpath("//form[@id='vContactsForm']//tr[4]//td"));
        Assert.assertEquals(list.get(6).getText(),email);
        return this;

    }


    }
