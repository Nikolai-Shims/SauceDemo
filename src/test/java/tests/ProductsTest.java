package tests;

import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class ProductsTest extends BaseTest {


    @Test
    public void selectItemByName() {
        loginPage
                .openPage()
                .login(USERNAME, PASSWORD)
                .isPageOpened()
                .goToItemByLink("Sauce Labs Bolt T-Shirt")
                .isPageOpened();
    }

    @Test
    public void selectItemByImage() {
        loginPage
                .openPage()
                .login(USERNAME, PASSWORD)
                .isPageOpened()
                .goToItemByImage("Sauce Labs Bolt T-Shirt")
                .isPageOpened();
    }

    @Test
    public void changeSorting() {
        loginPage
                .openPage()
                .login(USERNAME, PASSWORD)
                .isPageOpened()
                .sortMenu("Price (high to low)")
                .isPageOpened();
    }

    @Test
    public void AddItemToCartAndRemoveIt() {
        loginPage
                .openPage()
                .login(USERNAME, PASSWORD)
                .isPageOpened()
                .clickButtonAddToCart("Sauce Labs Bolt T-Shirt");
        String getCountItem = cartPage
                .openPage()
                .getCountItemInsideCart();
        assertEquals(getCountItem, "1");
        productsPage
                .openPage()
                .clickButtonRemoveFromCart("Sauce Labs Bolt T-Shirt");
        String countItem = cartPage
                .openPage()
                .getCountItemInsideCart();
        assertEquals(countItem, "0");
    }


}

