import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailPage {

    @FindBy(className = "inventory_details_name large_size")
    private WebElement productName;

    @FindBy(className = "inventory_details_desc large_size")
    private WebElement productDesc;

    @FindBy(className = "inventory_details_price")
    private WebElement productPrice;

    @FindBy(className = "inventory_details_img")
    private WebElement productImage;

    @FindBy(id = "add-to-cart")
    private WebElement addToCart;


}
