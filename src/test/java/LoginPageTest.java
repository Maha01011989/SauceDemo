import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class LoginPageTest extends BaseTest {


    @DataProvider
    public Object[][] getLoginData() {
        return new Object[][]{
                {"standard_user", "secret_sauce"},
                {"visual_user", "secret_sauce"},

        };
    }

    @Test
    public void TestLoginPageTitle() {
        String loginTitle = loginPage.getPageTitle();
        Assert.assertEquals(loginTitle, "Swag Labs", "Application is not launched.Title is not displayed as expected");
    }


    @Test(dataProvider = "getLoginData")
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

}
