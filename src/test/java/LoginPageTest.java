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
    public void TestLoginPageTitle() throws IOException {
        String loginTitle = loginPage.getPageTitle();
        Assert.assertEquals(loginTitle, "Swag Labs", "Application is not launched.Title is not displayed as expected");

    }


    //2,3.Overriding and application
    @Test(priority = 2)
    public void TestOverriding() throws IOException {
        String[] text = loginPage.getText().split(",");
        String loginLogo = text[0];
        String loginButton = text[1];
        Assert.assertEquals(loginLogo, "Swag Labs", "Logo text is not displayed as expected");
        Assert.assertEquals(loginButton, "Login", "Login Button text is not displayed as expected");
    }


    @Test(dataProvider = "getValidUserData", priority = 2)
    public void TestLoginPageFunctionality(String username, String password) throws InterruptedException {
        proPage = loginPage.login(username, password);
        String productTitle = proPage.getProdTitle();
        Assert.assertEquals(productTitle, "Products", "Login is not successful");
        proPage.clickMenu();
        Thread.sleep(3000);
        proPage.clickLogOut();
        Thread.sleep(3000);
        String loginTitle = loginPage.getPageTitle();
        Thread.sleep(3000);
        Assert.assertEquals(loginTitle, "Swag Labs", "Logout is not successful");
    }

    @Test(dataProvider = "getInvalidUserData", priority = 3)
    public void TestLoginInvalidUser(String username, String password, String expErrorMessage) {
        loginPage.login(username, password);
        String actError = loginPage.getErrorText();
        Assert.assertEquals(actError, expErrorMessage, "Error message is not displayed as expected");
    }

//    @Test(dataProvider = "getValidUserData", priority = 4)
//    public void TestLoginUserStorage(String username, String password) throws InterruptedException {
//        proPage = loginPage.login(username, password);
//        // loginPage.setLocalStorage("session-username", username);
//        System.out.println(loginPage.getLocalStorage("session-username"));
//        Thread.sleep(3000);
//        proPage.clickMenu();
//        Thread.sleep(3000);
//        proPage.clickLogOut();
//        Thread.sleep(3000);
//    }
}
