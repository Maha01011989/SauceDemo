import config.ConfigProperties;
import driver.BrowserDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import pages.LoginButton;
import pages.LoginPage;
import pages.ProductsPage;

import java.io.IOException;

public class BaseTest {

    WebDriver driver;
    ConfigProperties configProp;
    BrowserDriverManager browserDriverManager;

    LoginPage loginPage;

    LoginPage loginPage1;

    ProductsPage proPage;

    @BeforeTest
    public void init() throws Exception {
        configProp = new ConfigProperties();
        browserDriverManager = new BrowserDriverManager();
        driver = browserDriverManager.getDriver(configProp);
        driver.manage().window().maximize();
        browserDriverManager.launchApp(driver, configProp);
        loginPage = new LoginPage(driver);
        loginPage1 = new LoginButton(driver);

    }


    @AfterTest
    public void teardown() throws Exception {
        browserDriverManager.closeDriver();
    }


}
