package PageTests;

import Base.TestBase;
import org.testng.annotations.Test;

public class SignUpPageTest extends TestBase {

    @Test
    public void registerTest() {
        baseCRMProPage()
                .navigateToSignUpPage()
                .register();
    }
}
