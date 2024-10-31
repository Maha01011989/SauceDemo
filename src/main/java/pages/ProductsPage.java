package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.ElementUtils;

public class ProductsPage {

    WebDriver driver;
    ElementUtils ele;
    @FindBy(className = "title")
    private WebElement productsTitle;

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
        ele = new ElementUtils();
    }

    public String getProdTitle() {
        return ele.getText(productsTitle);
    }
}
