package tests;

import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class CartTest extends BaseTest {

    @Test
    public void logInToCart() {
        loginPage
                .openPage()
                .login(USERNAME, PASSWORD)
                .isPageOpened();
        cartPage
                .openPage();
    }

    @Test
    public void clickButtonContinue() {
        loginPage
                .openPage()
                .login(USERNAME, PASSWORD)
                .isPageOpened();
        cartPage
                .openPage()
                .clickContinueShopping()
                .isPageOpened();
    }

    @Test
    public void addItemToCartAndValidate() {
        loginPage
                .openPage()
                .login(USERNAME, PASSWORD)
                .isPageOpened()
                .clickButtonAddToCart("Sauce Labs Bike Light")
                .clickButtonAddToCart("Sauce Labs Bolt T-Shirt");
        cartPage
                .openPage();
        assertEquals(cartPage.getCountItemInsideCart(), headerPage.getCountItemByShoppingCartBadge());
    }

}
