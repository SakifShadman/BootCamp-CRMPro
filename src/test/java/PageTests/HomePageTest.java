package PageTests;

import Base.TestBase;
import Utilities.Utils;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(Utils.class)
public class HomePageTest extends TestBase {

    @Test
    public void homePageTest() {
        baseCRMProPage().navigateToHomePage();
    }

    @Test
    public void verifynavigateToContactsPage(){
        baseCRMProPage()
                .navigateToHomePage()
                .navigateToContactsPage();
    }
    @Test
    public void verifyNavigateToCalenderPage(){
        baseCRMProPage()
                .navigateToHomePage()
                .navigateToCalendarPage();
    }
}
