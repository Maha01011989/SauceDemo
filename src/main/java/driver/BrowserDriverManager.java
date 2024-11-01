package driver;

import config.ConfigProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.IOException;


public class BrowserDriverManager {
    WebDriver driver;

    public WebDriver getDriver(ConfigProperties cp) throws Exception {
        switch (cp.getBrowser()) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                break;
            default:
                throw new Exception("Please pass a valid browser parameter.Entered value is " + cp.getBrowser());
        }
        return driver;
    }

    public void launchApp(WebDriver driver, ConfigProperties cp) {
        driver.get(cp.getURL());
    }

    public void closeDriver() {
        if (driver != null)
            driver.close();
    }

}
