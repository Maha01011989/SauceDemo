package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.ElementUtils;
import utils.JavaScriptUtil;
import utils.WaitUtil;

import java.util.List;

public class LoginPage implements WebElement {

    WebDriver driver;
    ElementUtils ele;
    JavaScriptUtil js;




    public LoginPage(WebDriver driver) {
        this.driver = driver;
        ele = new ElementUtils();
        js = new JavaScriptUtil(driver);
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
        if (!userName.getAttribute("value").isEmpty()) {
            ele.clearValue(userName);
        }
        ele.enterValue(userName, username);
        if (!passWord.getAttribute("value").isEmpty()) {
            ele.clearValue(passWord);
        }
        ele.enterValue(passWord, password);
        ele.click(loginButton);
        return PageFactory.initElements(driver, ProductsPage.class);
    }

    public void setLocalStorage(String key, String value) {
        js.setItemFromLocalStorage(key, value);
    }

    public String getLocalStorage(String key) {
        return js.getItemFromLocalStorage(key);
    }

    @Override
    public String getText() {
        return loginPageLogo.getText() + "," + loginButton.getAttribute("value");
    }


    @Override
    public void click() {

    }

    @Override
    public void submit() {

    }

    @Override
    public void sendKeys(CharSequence... keysToSend) {

    }

    @Override
    public void clear() {

    }

    @Override
    public String getTagName() {
        return null;
    }

    @Override
    public String getAttribute(String name) {
        return null;
    }

    @Override
    public boolean isSelected() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }


    @Override
    public List<WebElement> findElements(By by) {
        return null;
    }

    @Override
    public WebElement findElement(By by) {
        return null;
    }

    @Override
    public boolean isDisplayed() {
        return false;
    }

    @Override
    public Point getLocation() {
        return null;
    }

    @Override
    public Dimension getSize() {
        return null;
    }

    @Override
    public Rectangle getRect() {
        return null;
    }

    @Override
    public String getCssValue(String propertyName) {
        return null;
    }

    @Override
    public <X> X getScreenshotAs(OutputType<X> target) throws WebDriverException {
        return null;
    }
}
