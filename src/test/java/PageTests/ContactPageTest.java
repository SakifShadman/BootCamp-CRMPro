package PageTests;

import Base.TestBase;
import org.testng.annotations.Test;

public class ContactPageTest extends TestBase {

    @Test(priority = 1)
    public void searchContactNameTest(){
        baseCRMProPage()
                .navigateToHomePage()
                .navigateToContactPage()
                .searchContactName("Gurpreet Kaur");
    }

    @Test(priority = 2)
    public void contactCompanyTest(){
        baseCRMProPage()
                .navigateToHomePage()
                .navigateToContactPage()
                .searchContactName("Gurpreet Kaur")
                .validateContactCompany("Home Goods ");
    }

    @Test(priority = 3)
    public void contactPhoneTest(){
        baseCRMProPage()
                .navigateToHomePage()
                .navigateToContactPage()
                .searchContactName("Gurpreet Kaur")
                .validateContactPhone("951753852  ");
    }

    @Test(priority = 4)
    public void contactEmailTest(){
        baseCRMProPage()
                .navigateToHomePage()
                .navigateToContactPage()
                .searchContactName("Gurpreet")
                .validateContactEmail("mnb@y.com ");
    }
}