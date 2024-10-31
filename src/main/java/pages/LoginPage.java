package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.ElementUtils;

public class LoginPage {

    WebDriver driver;
    ElementUtils ele;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        ele = new ElementUtils();
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "login_logo")
    private WebElement loginPageLogo;

    @FindBy(id = "user-name")
    private WebElement userName;

    @FindBy(id = "password")
    private WebElement passWord;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    @FindBy(xpath = " //h3[@data-test='error']")
    private WebElement lockedUserError;


    public String getLogoText() {
        return ele.getText(loginPageLogo);
    }

    public String getErrorText() {
        return ele.getText(lockedUserError);
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }


    public ProductsPage login(String username, String password) {
        ele.enterValue(userName, username);
        ele.enterValue(passWord, password);
        ele.click(loginButton);
        return PageFactory.initElements(driver, ProductsPage.class);
    }

}
