import com.aventstack.extentreports.Status;
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
        ss.takeScreenshot(methodName);

    }

    @AfterMethod
    public void testResult(ITestResult result) throws IOException {
        if (result.getStatus() == ITestResult.SUCCESS) {
            extentReportManager.getExtentTest(result.getName()).log(Status.PASS, "Test Case Passed");
        } else if (result.getStatus() == ITestResult.FAILURE) {
            extentReportManager.getExtentTest(result.getName()).log(Status.FAIL, "Test Case Failed");
        }
    }


    @AfterTest
    public void teardown() throws Exception {
        browserDriverManager.closeDriver();
        extentReportManager.endReport();
    }


}
