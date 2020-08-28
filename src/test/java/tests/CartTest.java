package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTest extends BaseTest {

    @Test
    public void logInToCart() {
        loginPage.openPage();
        loginPage.login(USERNAME, PASSWORD);
        productsPage.isPageOpened();
        cartPage.openPage();
        cartPage.isPageOpened();
    }

    @Test
    public void clickButtonContinue() {
        loginPage.openPage();
        loginPage.login(USERNAME, PASSWORD);
        productsPage.isPageOpened();
        cartPage.openPage();
        cartPage.clickContinueShopping();
        productsPage.isPageOpened();
    }

    @Test
    public void addItemToCartAndValidate() {
        loginPage.openPage();
        loginPage.login(USERNAME, PASSWORD);
        productsPage.isPageOpened();
        productsPage.clickAddToCart("Sauce Labs Bike Light");
        productsPage.clickAddToCart("Sauce Labs Bolt T-Shirt");
        cartPage.openPage();
        cartPage.isPageOpened();
        Assert.assertEquals(cartPage.getCountItemInsideCart(), cartPage.getCountItemByShoppingCartBadge());
    }

    @Test
    public void dfsfwefew(){
        loginPage.openPage();
        loginPage.login(USERNAME,PASSWORD);
        cartPage.openPage();
        System.out.println(cartPage.getCountItemInsideCart());


    }

}
