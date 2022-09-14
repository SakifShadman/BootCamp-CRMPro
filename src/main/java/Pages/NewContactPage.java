package Pages;

import Browser.Browser;
import Utilities.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.DataProvider;

public class NewContactPage {

    WebDriver driver = Browser.driver;

    @FindBy(id = "first_name")
    WebElement firstNameElement;

    @FindBy(id = "surname")
    WebElement lastNameElement;

    @FindBy(name = "client_lookup")
    WebElement companyElement;

    @FindBy(id = "email")
    WebElement emailElement;

    @FindBy(xpath = "//td[@colspan='2']//input[@type='submit' and @value='Save']")
    WebElement saveButton;


    public NewContactPage addNewContact(String firstname, String lastName, String company, String email) {
        firstNameElement.sendKeys(firstname);
        lastNameElement.sendKeys(lastName);
        companyElement.sendKeys(company);
        emailElement.sendKeys(email);
        saveButton.click();
        return this;
    }

    @DataProvider(name = "NewContact")
    public static Object[][] getContactInfo() {
        Object[][] data = Utils.getData("Info");
        return data;
    }
}