package PageTests;

import Base.TestBase;
import Utilities.Utils;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(Utils.class)
public class CompanyPageTest extends TestBase {

    @Test(priority = 1)
    public void companyPageNameTest(){
        baseCRMProPage()
                .navigateToHomePage()
                .navigateToCompanyPage()
                .searchCompanyName("Amazon")
                .validateCompanyName("Amazon");

    }

    @Test(priority = 2)
    public void companyPagePhoneTest(){
        baseCRMProPage()
                .navigateToHomePage()
                .navigateToCompanyPage()
                .searchCompanyName("Amazon")
                .validateCompaniesPhone("123456789 ");
    }

    @Test(priority = 3)
    public void companyPageEmailTest(){
        baseCRMProPage()
                .navigateToHomePage()
                .navigateToCompanyPage()
                .searchCompanyName("Amazon")
                .validateCompanyEmail("a@amazon.com ");
    }
}