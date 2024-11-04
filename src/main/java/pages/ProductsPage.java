package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.ElementUtils;
import utils.JavaScriptUtil;
import utils.WaitUtil;

import java.util.List;

public class ProductsPage {

    WebDriver driver;
    ElementUtils ele;

    WaitUtil waitUtil;

    @FindBy(className = "title")
    private WebElement productsTitle;

    @FindBy(xpath = "//button[@id='react-burger-menu-btn']")
    private WebElement hamburgerMenu;

//    @FindBy(className = "inventory_item_name ")
//    private List<WebElement> productNames;

    @FindBy(className = "product_sort_container")
    private WebElement productSortDdl;

    @FindBy(xpath = "//button[text()='Remove']")
    private WebElement removeButton;

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    private WebElement addToCartButton;

    @FindBy(id = "logout_sidebar_link")
    private WebElement logOut;

    @FindBy(className = "shopping_cart_link")
    private WebElement cartLink;

    @FindBy(className = "shopping_cart_badge")
    private WebElement cartBadge;

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
        ele = new ElementUtils();
        waitUtil = new WaitUtil(driver);
    }

    public String getProdTitle() {
        return ele.getText(productsTitle);
    }

    public void clickMenu() {
        waitUtil.clickWhenReady(hamburgerMenu, 5);
    }

    public void clickLogOut() {
        waitUtil.clickWhenReady(logOut, 5);
    }

//    public void clickProductName(String productName) {
//        for (WebElement name : productNames) {
//            if (ele.getText(name).equalsIgnoreCase(productName)) {
//                ele.click(name);
//            }
//        }
//    }

    public void clickAddToCart() {
        ele.click(addToCartButton);

    }

    public void clickRemove() {
        ele.click(removeButton);

    }


    public String getItemCountInCart() {
        try {
            return cartBadge.getText();
        } catch (NoSuchElementException e) {
            return "0";
        }
    }
}
