package demo;

import config.ConfigProperties;
import driver.BrowserDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;


public class RunClass {

    public static void main(String[] args) throws Exception {
        WebDriver driver;
        ConfigProperties cp = new ConfigProperties();
        BrowserDriverManager browserDriverManager = new BrowserDriverManager();
        driver = browserDriverManager.getDriver(cp);
        browserDriverManager.launchApp(driver, cp);
        browserDriverManager.closeDriver();


    }
}
