import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.Markup;
import config.ConfigProperties;
import driver.BrowserDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import pages.LoginPage;
import pages.ProductsPage;
import utils.ExtentReportManager;
import utils.ScreenshotUtil;

import java.io.IOException;

public class BaseTest {

    WebDriver driver;
    ConfigProperties configProp;
    BrowserDriverManager browserDriverManager;
    LoginPage loginPage;
    ProductsPage proPage;
    ScreenshotUtil ss;

    ExtentReportManager extentReportManager;

    ExtentTest logger;

    String ssPath;

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
        extentReportManager.startReport();


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
    public void teardown() throws Exception {
        browserDriverManager.closeDriver();
        extentReportManager.endReport();
    }


}
