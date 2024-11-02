import config.ConfigProperties;
import driver.BrowserDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import pages.LoginPage;
import pages.ProductsPage;
import utils.ScreenshotUtil;

import java.io.IOException;

public class BaseTest {

    WebDriver driver;
    ConfigProperties configProp;
    BrowserDriverManager browserDriverManager;
    LoginPage loginPage;
    ProductsPage proPage;
    ScreenshotUtil ss;

    @BeforeTest
    public void init() throws Exception {
        configProp = new ConfigProperties();
        browserDriverManager = new BrowserDriverManager();
        driver = browserDriverManager.getDriver(configProp);
        driver.manage().window().maximize();
        browserDriverManager.launchApp(driver, configProp);
        loginPage = new LoginPage(driver);
        ss = new ScreenshotUtil(driver);

    }

    @AfterMethod
    public void tearDown(ITestResult result) throws IOException {
        String methodName = result.getName();
        ss.takeScreenshot(methodName);
    }


    @AfterTest
    public void teardown() throws Exception {
        browserDriverManager.closeDriver();
    }


}
