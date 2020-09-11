package tests;

import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class ItemTest extends BaseTest {


    @Test
    public void validateButtonBack() {
        loginPage
                .openPage()
                .isPageOpened()
                .login(USERNAME, PASSWORD)
                .goToItemByLink("Sauce Labs Bolt T-Shirt")
                .clickBack()
                .isPageOpened();
    }

    @Test
    public void addAndRemoveItem() {
        productsPage
                .openPage()
                .isPageOpened()
                .goToItemByImage("Sauce Labs Bolt T-Shirt")
                .clickAddToCartButton();
        String getCountItem = cartPage
                .openPage()
                .isPageOpened()
                .getCountItemInsideCart();
        assertEquals(getCountItem, "1");
        productsPage
                .openPage()
                .isPageOpened()
                .goToItemByLink("Sauce Labs Bolt T-Shirt")
                .clickRemoveButton();
        String countItem = cartPage
                .openPage()
                .isPageOpened()
                .getCountItemInsideCart();
        assertEquals(countItem, "0");

    }
}
