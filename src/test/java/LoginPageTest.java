import constants.AppConstants;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;


public class LoginPageTest extends BaseTest {

    @DataProvider
    public Object[][] getValidUserData() {
        return new Object[][]{
                {"standard_user", "secret_sauce"},
                {"visual_user", "secret_sauce"},
        };
    }

    @DataProvider
    public Object[][] getInvalidUserData() {
        return new Object[][]{
                {"error_user", "secret_sauce1", "Epic sadface: Username and password do not match any user in this service"},
                {"locked_out_user", "secret_sauce", "Epic sadface: Sorry, this user has been locked out."},
        };
    }

    @Test(priority = 1)
    public void VerifyLoginPageTitle() throws IOException {
        String loginTitle = loginPage.getPageTitle();
        Assert.assertEquals(loginTitle, AppConstants.LOGIN_PAGE_TITLE);
    }


    //2,3.Overriding and application
    @Test(priority = 2)
    public void TestOverriding() throws IOException {
        String[] text = loginPage.getText().split(",");
        String loginLogo = text[0];
        String loginButton = text[1];
        Assert.assertEquals(loginLogo, AppConstants.LOGIN_PAGE_TITLE );
        Assert.assertEquals(loginButton, AppConstants.LOGIN_BUTTON_TEXT);
    }


    //1.Local Storage Check
    @Test(dataProvider = "getValidUserData", priority = 3)
    public void TestLoginPageFunctionality(String username, String password) {
        proPage = loginPage.login(username, password);
        loginPage.setLocalStorage("session-username", username);
        String productTitle = proPage.getProdTitle();
        Assert.assertEquals(productTitle, AppConstants.PRODUCT_PAGE_TITLE);
        Assert.assertEquals(username, loginPage.getLocalStorage("session-username"));
        proPage.clickMenu();
        proPage.clickLogOut();
        String loginTitle = loginPage.getPageTitle();
        Assert.assertEquals(loginTitle, AppConstants.LOGIN_PAGE_TITLE);
    }

    //Negative Scenario
    @Test(dataProvider = "getInvalidUserData", priority = 4)
    public void TestLoginInvalidUser(String username, String password, String expErrorMessage) {
        loginPage.login(username, password);
        String actError = loginPage.getErrorText();
        Assert.assertEquals(actError, expErrorMessage);
    }
}
