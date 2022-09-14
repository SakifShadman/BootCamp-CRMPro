package Pages;

import Browser.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class CalendarPage {
    WebDriver driver= Browser.driver;

    @FindBy(className = "calendarcellfullselected")
    WebElement firstEvent;

    @FindBy(id = "_eventselector_1115996")
    WebElement bootCampEvent;


    List<WebElement> thirdEvent=driver.findElements(By.className("calendarcellfull"));
    public CalendarPage navigateToFirstEvent(){
        Actions actions=new Actions(driver);
        actions.moveToElement(firstEvent).build().perform();
        firstEvent.click();
        bootCampEvent.click();
        return this;
    }

    public CalendarPage validateFirstEvent(String title){
        List<WebElement> list=driver.findElements(By.className("datafield"));
        Assert.assertEquals(list.get(0).getText(),title,"No Boot Camp");
        return this;
    }

    public CalendarPage navigateToThirdEvent(){
        Actions actions=new Actions(driver);
        actions.moveToElement(thirdEvent.get(1)).build().perform();
        thirdEvent.get(1).click();
        List<WebElement> list=driver.findElements(By.className("datafield"));
        list.get(0).click();
        return this;
    }
    public void validateThirdEvent(){
        List<WebElement> list=driver.findElements(By.xpath("//div[@id='vSummary']//table//tr[2]//td[2]"));
        Assert.assertEquals(list.get(0).getText(),"Missing Document ","No Missing Document");
    }


}
