package PageTests;

import Base.TestBase;
import Utilities.Utils;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(Utils.class)
public class CasesPageTest extends TestBase {

    @Test
    public void casesTitleTest(){
        baseCRMProPage()
                .navigateToHomePage()
                .navigateToCasesPage()
                .verifyCasesTitle("Missing Mail ");
    }
}