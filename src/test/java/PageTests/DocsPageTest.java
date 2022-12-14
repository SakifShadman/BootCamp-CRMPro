package PageTests;

import Base.TestBase;
import Utilities.Utils;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(Utils.class)
public class DocsPageTest extends TestBase {

    @Test
    public void filePresenceTest() {
        baseCRMProPage()
                .navigateToHomePage()
                .navigateToDocsPage()
                .validateFilePresence();
    }
}