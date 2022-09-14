package PageTests;

import Base.TestBase;
import org.testng.annotations.Test;

public class ContactPageTest extends TestBase {

    @Test(priority = 1)
    public void searchContactsNameTest(){
        baseCRMProPage()
                .navigateToHomePage()
                .navigateToContactsPage()
                .searchContactsName("Gurpreet Kaur");
    }
    @Test(priority = 2)
    public void verifyContactCompany(){
        baseCRMProPage()
                .navigateToHomePage()
                .navigateToContactsPage()
                .searchContactsName("Gurpreet Kaur")
                .validateContactCompany("Home Goods ");
    }
    @Test(priority = 3)
    public void verifyContactPhone(){
        baseCRMProPage()
                .navigateToHomePage()
                .navigateToContactsPage()
                .searchContactsName("Gurpreet Kaur")
                .validateContactPhone("951753852  ");
    }
    @Test(priority = 4)
    public void verifyContactEmail(){
        baseCRMProPage()
                .navigateToHomePage()
                .navigateToContactsPage()
                .searchContactsName("Gurpreet")
                .validateContactEmail("mnb@y.com ");
    }
}
