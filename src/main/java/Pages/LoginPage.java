package Pages;

import Browser.Browser;
import Informations.LoginInformation;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class LoginPage {

    WebDriver driver = Browser.driver;

    @FindBy(name = "username")
    WebElement userName;

    @FindBy(name = "password")
    WebElement passWord;

    @FindBy(css = "input[value='Login']")
    WebElement loginButton;

    @FindBy(linkText = "Sign Up")
    WebElement signUpElement;

    public LoginPage validateTitle() {
        Assert.assertEquals(driver.getTitle(),
                "Free CRM - CRM software for customer relationship management, sales, and support.",
                "Title name is not matched");
        return this;
    }

    public LoginPage validateLoginButton() {
        Assert.assertTrue(loginButton.isDisplayed(), "Login Button is not Displayed");
        return this;
    }

    public LoginPage validateBrokenLink() {
        List<WebElement> allLinks = driver.findElements(By.tagName("a"));
        allLinks.addAll(driver.findElements(By.tagName("//img")));

        List<WebElement> activeLinks = new ArrayList<>();

        for (WebElement element : allLinks) {
            if ((element.getAttribute("href") != null) && (!element.getAttribute("href").contains("javascript"))) {
                activeLinks.add(element);
            }
        }
        Assert.assertEquals(activeLinks.size(), allLinks.size(), "There are broken link/pictures");

        //For HTTP URL connection status
        for (WebElement element: activeLinks) {
            try {
                HttpURLConnection connection = (HttpURLConnection) new URL(element.getAttribute("href")).openConnection();
                connection.connect();
                String response = connection.getResponseMessage();
                connection.disconnect();
                System.out.println(element.getAttribute("href") + " ---> " + response);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return this;
    }

    public SignUpPage navigateToSignUpPage() {
        signUpElement.click();
        return PageFactory.initElements(driver, SignUpPage.class);
    }

    public HomePage navigateToHomePage() {
        userName.sendKeys(LoginInformation.USERNAME);
        passWord.sendKeys(LoginInformation.PASSWORD);
        loginButton.click();
        return PageFactory.initElements(driver, HomePage.class);
    }
}