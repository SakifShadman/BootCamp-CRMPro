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
                .validateFirstEvent();
    }
    @Test
    public void VerifyThirdEvent(){
        baseCRMProPage()
                .navigateToHomePage()
                .navigateToCalendarPage()
                .navigateToThirdEvent()
                .validateThirdEvent();
    }
    @Test
    public void verifyToEvent2023(){
        baseCRMProPage()
                .navigateToHomePage()
                .navigateToCalendarPage()
                .navigateToEvent2023()
                .validateEvent2023();
    }

}
