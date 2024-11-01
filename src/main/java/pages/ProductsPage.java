package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.ElementUtils;
import utils.JavaScriptUtil;

public class ProductsPage {

    WebDriver driver;
    ElementUtils ele;

    @FindBy(className = "title")
    private WebElement productsTitle;

    @FindBy(xpath = "//button[@id='react-burger-menu-btn']")
    private WebElement hamburgerMenu;

    @FindBy(id = "logout_sidebar_link")
    private WebElement logOut;


    public ProductsPage(WebDriver driver) {
        this.driver = driver;
        ele = new ElementUtils();

    }

    public String getProdTitle() {
        return ele.getText(productsTitle);
    }




    public void clickMenu() {
        ele.click(hamburgerMenu);
    }

    public void clickLogOut() {
        ele.click(logOut);
    }
}
