package demo;

import config.ConfigProperties;
import driver.BrowserDriverManager;
import org.openqa.selenium.WebDriver;
import pages.LoginButton;
import pages.LoginPage;
import pages.ProductsPage;

public class RunClass {

    public static void main(String[] args) throws Exception {
        WebDriver driver;
        ConfigProperties cp = new ConfigProperties();
        BrowserDriverManager browserDriverManager = new BrowserDriverManager();
        driver = browserDriverManager.getDriver(cp);
        driver.manage().window().maximize();
        browserDriverManager.launchApp(driver, cp);
        LoginPage lp = new LoginPage(driver);
        System.out.println(lp.getText());
        LoginPage lp1 = new LoginButton(driver);
        System.out.println(lp1.getText());
        browserDriverManager.closeDriver();
    }
}
