package Base;

import Browser.Browser;
import Informations.Info;
import Pages.LoginPage;
import Utilities.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class TestBase {
    WebDriver driver = Browser.driver;

    @BeforeMethod
    public void setUp() {
        driver = Browser.initialization();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Utils.PAGE_LOAD_TIMEOUT));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utils.IMPLICITLY_WAIT));
        driver.navigate().to(Info.URL);
    }

    @AfterMethod
    public void tearDown() {
        //driver.quit();
    }

    public LoginPage baseCRMProPage() {
        return PageFactory.initElements(driver, LoginPage.class);
    }
}
