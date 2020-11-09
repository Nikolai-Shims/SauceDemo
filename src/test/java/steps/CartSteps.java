package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.CartPage;

import static org.testng.Assert.assertEquals;

public class CartSteps {

    CartPage cartPage;

    public CartSteps (WebDriver driver){
        cartPage = new CartPage(driver);
    }

    @Step("Open cart, get count item inside cert and validate that")
    public CartSteps validateCountItemInsideCart(String count){
        cartPage
                .openPage()
                .isPageOpened();
        assertEquals(cartPage.getCountItemInsideCart(),count);
    return this;
    }

}
