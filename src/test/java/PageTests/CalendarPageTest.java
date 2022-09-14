package PageTests;

import Base.TestBase;
import Utilities.Utils;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(Utils.class)
public class CalendarPageTest extends TestBase {

    @Test(priority = 1)
    public void firstEventTest(){
        baseCRMProPage()
                .navigateToHomePage()
                .navigateToCalendarPage()
                .navigateToFirstEvent()
                .validateFirstEvent();
    }

    @Test(priority = 2)
    public void thirdEventTest(){
        baseCRMProPage()
                .navigateToHomePage()
                .navigateToCalendarPage()
                .navigateToThirdEvent()
                .validateThirdEvent();
    }

    @Test(priority = 3)
    public void event2023Test(){
        baseCRMProPage()
                .navigateToHomePage()
                .navigateToCalendarPage()
                .navigateToEvent2023()
                .validateEvent2023();
    }
}