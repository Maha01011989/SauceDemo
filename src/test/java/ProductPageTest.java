import constants.AppConstants;
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

    @Test(priority = 1)
    public void VerifyProductsPageTitle() {
        String productTitle = proPage.getProdTitle();
        Assert.assertEquals(productTitle, AppConstants.PRODUCT_PAGE_TITLE);
    }

    @Test(priority = 2)
    public void VerifyAddToCart() {
        proPage.clickAddToCart();
        String count = proPage.getItemCountInCart();
        Assert.assertEquals(count, "1");
    }

    @Test(priority = 3)
    public void VerifyRemoveFromCart() {
        proPage.clickRemove();
        String count = proPage.getItemCountInCart();
        Assert.assertEquals(count, "0");
    }

    @Test(priority = 4)
    public void VerifyCartLinkPageLoad() {
        proPage.clickAddToCart();
        cartPage = proPage.clickShoppingCartLink();
        String cartTitle = proPage.getProdTitle();
        Assert.assertEquals(cartTitle, AppConstants.CART_PAGE_TITLE);
    }

}
