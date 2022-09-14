package Pages;

import Browser.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class ContactPage {

    WebDriver driver = Browser.driver;

    @FindBy(css = "input[name='cs_name']")
    WebElement nameElement;

    public ContactPage searchContactName(String name) {
        nameElement.sendKeys(name);
        nameElement.sendKeys(Keys.ENTER);
        return this;
    }

    public ContactPage validateContactCompany(String company) {
        List<WebElement> list = driver.findElements(By.xpath("//form[@id='vContactsForm']//tr[4]//td"));
        Assert.assertEquals(list.get(2).getText(), company,"Company name not matched");
        return this;
    }

    public ContactPage validateContactPhone(String phone){
        List<WebElement> list = driver.findElements(By.xpath("//form[@id='vContactsForm']//tr[4]//td"));
        Assert.assertEquals(list.get(3).getText(), phone,"Phone number not matched");
        return this;
    }

    public ContactPage validateContactEmail(String email){
        List<WebElement> list = driver.findElements(By.xpath("//form[@id='vContactsForm']//tr[4]//td"));
        Assert.assertEquals(list.get(6).getText(), email,"Email ID not matched");
        return this;
    }
}