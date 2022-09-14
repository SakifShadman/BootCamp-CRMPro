package Pages;

import Browser.Browser;
import Utilities.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    WebDriver driver = Browser.driver;

    @FindBy(css = "a[title='Contacts']")
    WebElement contactLink;

    @FindBy(css = "a[title='New Contact']")
    WebElement newContactLink;

    @FindBy(css = "a[title='Contacts']")
    WebElement contactsElement;

    @FindBy(css ="a[title='Calendar']")
    WebElement calendarElement;

    public ContactsPage navigateToContactsPage(){
        Utils.switchFrame();
        contactsElement.click();
        return PageFactory.initElements(driver,ContactsPage.class);
    }

    public CalendarPage navigateToCalendarPage(){
        Utils.switchFrame();
        calendarElement.click();
        return PageFactory.initElements(driver,CalendarPage.class);
    }

    public NewContactPage navigateToNewContactPage() {
        Utils.switchFrame();
        Actions action = new Actions(driver);
        action.moveToElement(contactLink).build().perform();
        newContactLink.click();
        return PageFactory.initElements(driver, NewContactPage.class);
    }
}
