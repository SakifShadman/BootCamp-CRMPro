package PageTests;

import Base.TestBase;
import Utilities.Utils;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(Utils.class)
public class SignUpPageTest extends TestBase {

    @Test
    public void registerTest() {
        baseCRMProPage()
                .navigateToSignUpPage()
                .register();
    }
}
