package steps;

import org.openqa.selenium.WebDriver;
import pages.CartPage;

import static org.testng.Assert.assertEquals;

public class CartSteps {

    CartPage cartPage;

    public CartSteps (WebDriver driver){
        cartPage = new CartPage(driver);
    }


    public CartSteps validateCountItemInsideCart(String count){
        cartPage
                .openPage()
                .isPageOpened();
        assertEquals(cartPage.getCountItemInsideCart(),count);
    return this;
    }

}
