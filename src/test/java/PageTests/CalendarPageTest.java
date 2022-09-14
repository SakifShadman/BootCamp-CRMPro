package PageTests;

import Base.TestBase;
import org.testng.annotations.Test;

public class CalendarPageTest extends TestBase {

    @Test
    public void verifyFirstEventT(){
        baseCRMProPage()
                .navigateToHomePage()
                .navigateToCalendarPage()
                .navigateToFirstEvent()
                .validateFirstEvent("Boot Camp ");
    }
    @Test
    public void VerifyThirdEvent(){
        baseCRMProPage()
                .navigateToHomePage()
                .navigateToCalendarPage()
                .navigateToThirdEvent()
                .validateThirdEvent();
    }

}
