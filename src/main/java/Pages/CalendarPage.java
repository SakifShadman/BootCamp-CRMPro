package Pages;

import Browser.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

public class CalendarPage {

    WebDriver driver= Browser.driver;

    @FindBy(className = "calendarcellfullselected")
    WebElement firstEvent;

    @FindBy(id = "_eventselector_1115996")
    WebElement bootCampEvent;

    @FindBy(name = "slctMonth")
    WebElement selectMonth;

    @FindBy(name = "slctYear")
    WebElement selectYear;

    @FindBy(className= "calendarcellfull")
    WebElement event1Element;

    @FindBy(id = "_eventselector_1115690")
    WebElement newyearElement;

    List<WebElement> thirdEvent = driver.findElements(By.className("calendarcellfull"));

    public CalendarPage navigateToFirstEvent(){
        Actions actions = new Actions(driver);
        actions.moveToElement(firstEvent).build().perform();
        firstEvent.click();
        bootCampEvent.click();
        return this;
    }

    public CalendarPage validateFirstEvent(){
        List<WebElement> list = driver.findElements(By.className("datafield"));
        Assert.assertEquals(list.get(0).getText(),"Boot Camp ","No Boot Camp");
        return this;
    }

    public CalendarPage navigateToThirdEvent(){
        Actions actions = new Actions(driver);
        actions.moveToElement(thirdEvent.get(1)).build().perform();
        thirdEvent.get(1).click();

        List<WebElement> list = driver.findElements(By.className("datafield"));
        list.get(0).click();
        return this;
    }

    public void validateThirdEvent(){
        List<WebElement> list = driver.findElements(By.xpath("//div[@id='vSummary']//table//tr[2]//td[2]"));
        Assert.assertEquals(list.get(0).getText(),"Missing Document ","No Missing Document");
    }

    public CalendarPage navigateToEvent2023(){
        Select select = new Select(selectMonth);
        select.selectByVisibleText("January");

        Select select1 = new Select(selectYear);
        select1.selectByVisibleText("2023");

        event1Element.click();
        newyearElement.click();
        return this;
    }

    public CalendarPage validateEvent2023(){
        List<WebElement> list = driver.findElements(By.className("datafield"));
        Assert.assertEquals(list.get(0).getText(),"New Year's Day ","There is No Event");
        return this;
    }
}