package Utilities;

import Browser.Browser;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

public class Utils extends TestListenerAdapter {
    public static final int PAGE_LOAD_TIMEOUT = 20;
    public static final int IMPLICITLY_WAIT = 15;

    public static final int EXPLICIT_WAIT = 15;
    public static final String TEST_DATA_SHEET = "src/main/java/TestData/ContactInfo.xlsx";
    static Workbook book;
    static Sheet sheet;

    public static void switchFrame() {
        Browser.driver.switchTo().frame("mainpanel");
    }

    public static WebElement explicitWait(WebElement locator) {
        WebDriverWait wait = new WebDriverWait(Browser.driver, Duration.ofSeconds(EXPLICIT_WAIT));
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void onTestFailure(ITestResult testResult) {
        String path = "src/main/java/Screenshots/";

        File screenShot = ((TakesScreenshot)Browser.driver).getScreenshotAs(OutputType.FILE);
        File destFile = new File(path + testResult.getName() + System.currentTimeMillis() + ".png");

        try {
            FileUtils.copyFile(screenShot, destFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Object[][] getData(String sheetName) {
        try {
            FileInputStream file = new FileInputStream(TEST_DATA_SHEET);
            book = WorkbookFactory.create(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        sheet = book.getSheet(sheetName);

        Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];

        for (int i=0; i<sheet.getLastRowNum(); i++) {
            for (int j=0; j<sheet.getRow(0).getLastCellNum(); j++) {
                data[i][j] = sheet.getRow(i+1).getCell(j).toString();
            }
        }
        return data;
    }
}