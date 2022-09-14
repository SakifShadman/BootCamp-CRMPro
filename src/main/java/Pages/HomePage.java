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

    @FindBy(css = "a[onclick='addHomeBoxPanel();']")
    WebElement addBoxesElement;

    @FindBy(xpath = "//p[contains(text(),'All boxes are showing in your Home page.')]")
    WebElement addBoxesText;

    @FindBy(linkText = "Close")
    WebElement addHomeBoxCloseButton;

    @FindBy(css = "a[title='Contacts']")
    WebElement contactElement;

    @FindBy(css = "a[title='New Contact']")
    WebElement newContactElement;

    @FindBy(css ="a[title='Calendar']")
    WebElement calendarElement;

    @FindBy(css ="a[title='Docs']")
    WebElement docsElement;

    @FindBy(css ="a[title='Multi Doc Upload']")
    WebElement multiDocUploadElement;

    @FindBy(css = "a[title='Cases']")
    WebElement casesElement;

    @FindBy (css = "a[title='Companies']")
    WebElement companyElement;

    public HomePage validateDisplay() {
        Utils.switchFrame();
        Assert.assertTrue(contactElement.isDisplayed(), "Contact Element is not displayed");
        Assert.assertTrue(calendarElement.isDisplayed(), "Calender Element is not displayed");
        Assert.assertTrue(addBoxesElement.isDisplayed(), "Add Boxes Element is not displayed");
        Assert.assertTrue(docsElement.isDisplayed(), "Docs Element is not displayed");
        Assert.assertTrue(casesElement.isDisplayed(), "Cases Element is not displayed");
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

    public NewContactPage navigateToNewContactPage() {
        Utils.switchFrame();
        Actions action = new Actions(driver);
        action.moveToElement(contactElement).build().perform();
        newContactElement.click();
        return PageFactory.initElements(driver, NewContactPage.class);
    }

    public MultiDocUploadPage navigateToMultiDocUploadPage() {
        Utils.switchFrame();
        Actions action = new Actions(driver);
        action.moveToElement(docsElement).build().perform();
        multiDocUploadElement.click();
        return PageFactory.initElements(driver, MultiDocUploadPage.class);
    }

    public DocsPage navigateToDocsPage(){
        Utils.switchFrame();
        docsElement.click();
        return PageFactory.initElements(driver, DocsPage.class);
    }

    public ContactPage navigateToContactPage(){
        Utils.switchFrame();
        contactElement.click();
        return PageFactory.initElements(driver, ContactPage.class);
    }

    public CalendarPage navigateToCalendarPage(){
        Utils.switchFrame();
        calendarElement.click();
        return PageFactory.initElements(driver,CalendarPage.class);
    }

    public CasesPage navigateToCasesPage(){
        Utils.switchFrame();
        casesElement.click();
        return PageFactory.initElements(driver, CasesPage.class);
    }

    public CompanyPage navigateToCompanyPage(){
        Utils.switchFrame();
        companyElement.click();
        return PageFactory.initElements(driver, CompanyPage.class);
    }
}