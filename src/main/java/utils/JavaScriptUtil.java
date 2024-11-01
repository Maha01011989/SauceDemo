package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.html5.LocalStorage;

import java.util.Set;

public class JavaScriptUtil {

    WebDriver driver;

    public JavaScriptUtil(WebDriver driver) {
        this.driver = driver;
    }

    public void setItemFromLocalStorage(String key, String value) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("localStorage.setItem(arguments[0],arguments[1])", key, value);
    }


    public String getItemFromLocalStorage(String key) {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        return (String) js.executeScript(String.format(
                "return window.localStorage.getItem('%s');", key));
    }

}

