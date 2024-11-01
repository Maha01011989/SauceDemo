package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginButton extends LoginPage {


    public LoginButton(WebDriver driver) {
        super(driver);
    }

    public String getText() {
        WebElement element = driver.findElement(By.id("login-button"));
        return element.getAttribute("value");
    }
}
