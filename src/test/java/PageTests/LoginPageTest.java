package PageTests;

import Base.TestBase;
import Utilities.Utils;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(Utils.class)
public class LoginPageTest extends TestBase {

    @Test(priority = 1)
    public void TitleTest() {
        baseCRMProPage().validateTitle();
    }

    @Test(priority = 2)
    public void brokenLinkTest() {
        baseCRMProPage().validateBrokenLink();
    }
}