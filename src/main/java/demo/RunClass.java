package demo;

import config.ConfigProperties;
import driver.BrowserDriverManager;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;

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

        browserDriverManager.closeDriver();
    }
}
