package tests;

import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class HeaderTest extends BaseTest {

    @Test()
    public void validateBurgerMenu() throws InterruptedException {
        loginPage
                .openPage()
                .isPageOpened()
                .login(USERNAME, PASSWORD)
                .isPageOpened()
                .clickButtonAddToCart("Test.allTheThings() T-Shirt (Red)");
        assertEquals(headerPage.getCountItemByShoppingCartBadge(), "1");
        headerPage
                .clickBurgerMenu()
                .clickResetState()
                .closeBurgerMenu()
                .openCartByBadge()
                .isPageOpened();
        assertEquals(cartPage.getCountItemInsideCart(), "0");
        headerPage
                .clickBurgerMenu()
                .clickAllItems()
                .isPageOpened();
        headerPage
                .clickBurgerMenu()
                .clickLogout()
                .isPageOpened();
    }

}
