package PageTests;

import Base.TestBase;
import Pages.NewContactPage;
import Utilities.Utils;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(Utils.class)
public class NewContactPageTest extends TestBase {

    @Test(dataProvider = "NewContact", dataProviderClass = NewContactPage.class)
    public void addNewContact(String firstname, String lastName, String company, String email) {
        baseCRMProPage()
                .navigateToHomePage()
                .navigateToNewContactPage()
                .addNewContact(firstname, lastName, company, email);
    }
}