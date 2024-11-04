import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class ProductPageTest extends BaseTest {

    @BeforeClass
    @Parameters({"name", "pass"})
    public void login(String username, String password) {
        proPage = loginPage.login(username, password);

    }

    @Test
    public void VerifyProductsPageTitle() {
        String productTitle = proPage.getProdTitle();
        Assert.assertEquals(productTitle, "Products", "Login is not successful");
    }

}
