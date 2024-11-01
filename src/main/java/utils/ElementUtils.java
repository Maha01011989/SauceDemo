package utils;

import org.openqa.selenium.WebElement;

public class ElementUtils {

    public String getText(WebElement element) {
        return element.getText();
    }

    public void clearValue(WebElement element) {
        element.clear();
    }

    public void enterValue(WebElement element, String text) {
        element.sendKeys(text);
    }

    public void click(WebElement element) {
        element.click();
    }

}
