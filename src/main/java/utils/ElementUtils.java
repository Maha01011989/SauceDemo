package utils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ElementUtils {

    Select select;

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

    public void selectByValue(WebElement element, String value) {
        select = new Select(element);
        select.selectByValue(value);
    }

}
