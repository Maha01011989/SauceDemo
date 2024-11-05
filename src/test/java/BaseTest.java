import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.Markup;
import config.ConfigProperties;
import driver.BrowserDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.CartPage;
import pages.LoginPage;
import pages.ProductsPage;
import utils.ExtentReportManager;
import utils.ScreenshotUtil;
import utils.WaitUtil;

import java.io.IOException;

public class BaseTest {

    WebDriver driver;
    ConfigProperties configProp;
    BrowserDriverManager browserDriverManager;
    LoginPage loginPage;
    ProductsPage proPage;

    CartPage cartPage;
    ScreenshotUtil ss;

    ExtentReportManager extentReportManager;

    ExtentTest logger;

    String ssPath;
    ExtentReports reports;


    @BeforeTest
    public void init() throws Exception {
        configProp = new ConfigProperties();
        browserDriverManager = new BrowserDriverManager();
        driver = browserDriverManager.getDriver(configProp);
        driver.manage().window().maximize();
        browserDriverManager.launchApp(driver, configProp);
        loginPage = new LoginPage(driver);
        ss = new ScreenshotUtil(driver);
        extentReportManager = new ExtentReportManager();
        reports = extentReportManager.startReport();


    }

    @AfterMethod
    public void tearDown(ITestResult result) throws IOException {
        String methodName = result.getName();
        ssPath = ss.getScreenshot(methodName);
        logger = extentReportManager.getExtentTest(result.getName());

    }

    @AfterMethod
    public void testResult(ITestResult result) throws IOException {

        if (result.getStatus() == ITestResult.SUCCESS) {
            logger.log(Status.PASS, "Test Case Passed");
        } else if (result.getStatus() == ITestResult.FAILURE) {
            logger.log(Status.FAIL, "Test Case Failed");
            //logger.fail("Test Case Failed.Snapshot is " + logger.addScreenCaptureFromPath(ssPath));
        }
    }


    @AfterTest
    public void teardown() {
        browserDriverManager.closeDriver();

    }

    @AfterSuite
    public void closeReport() {
        extentReportManager.endReport();

    }

}
