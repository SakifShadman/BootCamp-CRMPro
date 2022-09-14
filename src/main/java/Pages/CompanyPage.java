package Pages;

import Browser.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class CompanyPage {
    WebDriver driver = Browser.driver;

    @FindBy(name ="cs_name")
    WebElement companiesName;

    @FindBy (name = "cs_submit")
    List<WebElement> list;

    public CompanyPage searchCompanyName(String name) {
        companiesName.sendKeys(name);
        companiesName.sendKeys(Keys.ENTER);
        //list.get(1).click();
        return this;
    }

    public CompanyPage validateCompanyName(String name) {
        List<WebElement> companiesInfoList = driver.findElements(By.xpath("//form[@name='CompaniesForm']//tr[5]//td"));
        Assert.assertEquals(companiesInfoList.get(1).getText(), name);
        return this;
    }

    public CompanyPage validateCompaniesPhone(String phone) {
        List<WebElement> companiesInfoList = driver.findElements(By.xpath("//form[@name='CompaniesForm']//tr[5]//td"));
        Assert.assertEquals(companiesInfoList.get(2).getText(), phone);
        return this;
    }

    public CompanyPage validateCompanyEmail(String email) {
        List<WebElement> companiesInfoList = driver.findElements(By.xpath("//form[@name='CompaniesForm']//tr[5]//td"));
        Assert.assertEquals(companiesInfoList.get(3).getText(), email);
        return this;
    }
}