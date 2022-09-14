package PageTests;

import Base.TestBase;
import Utilities.Utils;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(Utils.class)
public class HomePageTest extends TestBase {

    @Test(priority = 1)
    public void displayTest() {
        baseCRMProPage()
                .navigateToHomePage()
                .validateDisplay();
    }

    @Test(priority = 2)
    public void addBoxesTest() {
        baseCRMProPage()
                .navigateToHomePage()
                .validateAddBoxesText();
    }
}