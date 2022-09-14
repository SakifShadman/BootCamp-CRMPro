package Pages;

import Browser.Browser;
import Utilities.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HomePage {
    WebDriver driver = Browser.driver;

    String text = "All boxes are showing in your Home page.";

    @FindBy(css = "a[title='Contacts']")
    WebElement contactElement;

    @FindBy(css = "a[title='New Contact']")
    WebElement newContactLink;

    @FindBy(css ="a[title='Calendar']")
    WebElement calendarElement;

    @FindBy(css = "a[onclick='addHomeBoxPanel();']")
    WebElement addBoxesElement;

    @FindBy(xpath = "//p[contains(text(),'All boxes are showing in your Home page.')]")
    WebElement addBoxesText;

    @FindBy(linkText = "Close")
    WebElement addHomeBoxCloseButton;

    public HomePage validateDisplay() {
        Utils.switchFrame();
        Assert.assertTrue(contactElement.isDisplayed(), "Contact Element is not displayed");
        Assert.assertTrue(calendarElement.isDisplayed(), "Calender Element is not displayed");
        Assert.assertTrue(addBoxesElement.isDisplayed(), "Add Boxes Element is not displayed");
        return this;
    }

    public HomePage validateAddBoxesText() {
        Utils.switchFrame();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        addBoxesElement.click();
        Assert.assertEquals(addBoxesText.getText(), text, "Text are not matched.");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        addHomeBoxCloseButton.click();
        return this;
    }

    public ContactPage navigateToContactsPage(){
        Utils.switchFrame();
        contactElement.click();
        return PageFactory.initElements(driver, ContactPage.class);
    }

    public CalendarPage navigateToCalendarPage(){
        Utils.switchFrame();
        calendarElement.click();
        return PageFactory.initElements(driver,CalendarPage.class);
    }

    public NewContactPage navigateToNewContactPage() {
        Utils.switchFrame();
        Actions action = new Actions(driver);
        action.moveToElement(contactElement).build().perform();
        newContactLink.click();
        return PageFactory.initElements(driver, NewContactPage.class);
    }
}