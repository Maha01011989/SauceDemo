import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


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
                {"locked_out_user", "secret_sauce", "Epic sadface: Sorry, this user has been locked out."},
                {"error_user", "secret_sauce1", "Epic sadface: Username and password do not match any user in this service"},
        };
    }

    @Test
    public void TestLoginPageTitle() {
        String loginTitle = loginPage.getPageTitle();
        Assert.assertEquals(loginTitle, "Swag Labs", "Application is not launched.Title is not displayed as expected");
    }


    @Test(dataProvider = "getValidUserData")
    public void TestLoginPageFunctionality(String username, String password) throws InterruptedException {
        proPage = loginPage.login(username, password);
        String productTitle = proPage.getProdTitle();
        Assert.assertEquals(productTitle, "Products", "Login is not successful");
        Thread.sleep(3000);
        proPage.clickMenu();
        Thread.sleep(3000);
        proPage.clickLogOut();
        Thread.sleep(3000);
        String loginTitle = loginPage.getPageTitle();
        Thread.sleep(3000);
        Assert.assertEquals(loginTitle, "Swag Labs", "Logout is not successful");
    }

    @Test(dataProvider = "getInvalidUserData")
    public void TestLoginInvalidUser(String username, String password, String expErrorMessage) {
        loginPage.login(username, password);
        String actError = loginPage.getErrorText();
        Assert.assertEquals(actError, expErrorMessage, "Error message is not displayed as expected");
    }

    @Test(dataProvider = "getValidUserData")
    public void TestLoginUserStorage(String username, String password) throws InterruptedException {
        loginPage.login(username, password);
        loginPage.setLocalStorage("session-username", username);
        System.out.println(loginPage.getLocalStorage("session-username"));
        Thread.sleep(3000);
        proPage.clickMenu();
        Thread.sleep(3000);
        proPage.clickLogOut();
        Thread.sleep(3000);

    }
}
