package Pages;

import Browser.Browser;
import Informations.Info;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage {
    WebDriver driver = Browser.driver;

    @FindBy(name = "username")
    WebElement userName;

    @FindBy(name = "password")
    WebElement passWord;

    @FindBy(css = "input[value='Login']")
    WebElement loginButton;

    public LoginPage validateTitle() {
        Assert.assertEquals(driver.getTitle(),
                "CRMPRO - CRM software for customer relationship management, sales, and support.",
                "Title name is not matched");
        return this;
    }

    public HomePage navigateToHomePage() {
        userName.sendKeys(Info.USERNAME);
        passWord.sendKeys(Info.PASSWORD);
        loginButton.click();
        return PageFactory.initElements(driver, HomePage.class);
    }
}
