package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtil {

    WebDriver driver;

    WebDriverWait wait;

    public WaitUtil(WebDriver driver) {
        this.driver = driver;

    }

    public void clickWhenReady(WebElement element, int timeOut) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
        element = wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }


    public WebElement waitForElementPresence(By locator, int timeOut) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        return element;
    }


    public WebElement waitForElementVisible(By locator, int timeOut) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return element;
    }

    public WebElement waitForElementVisible(By locator, int timeOut, int intervalTime) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut), Duration.ofSeconds(intervalTime));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return element;
    }
}
