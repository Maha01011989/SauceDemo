package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.ElementUtils;
import utils.WaitUtil;

public class CartPage {

    WebDriver driver;
    ElementUtils ele;

    WaitUtil waitUtil;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        ele = new ElementUtils();
        waitUtil = new WaitUtil(driver);
    }

    @FindBy(className = "title")
    private WebElement cartTitle;


    public String getCartTitle() {
        return ele.getText(cartTitle);
    }
}
