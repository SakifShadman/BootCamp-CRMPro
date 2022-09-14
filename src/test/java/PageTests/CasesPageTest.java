package PageTests;

import Base.TestBase;
import org.testng.annotations.Test;

public class CasesPageTest extends TestBase {
    @Test
    public void verifySearchCasesPageTitle(){
        baseCRMProPage()
                .navigateToHomePage()
                .navigateToCasesPage()
                .navigateToSearchCasesTitle("Missing Mail ");

    }

    }


