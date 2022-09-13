package PageTests;

import Base.TestBase;
import org.testng.annotations.Test;

public class LoginPageTests extends TestBase {

    @Test
    public void TitleTest() {
        baseCRMProPage().validateTitle()
                .navigateToHomePage();
    }
}
