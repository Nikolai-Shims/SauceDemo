package tests;

import org.testng.annotations.Test;

public class CartTest extends BaseTest{

    @Test
    public void logInToTheCart(){
        loginPage.login(USERNAME,PASSWORD);
        cartPage.openCart();
    }

    @Test
    public void buttonContinue(){
        loginPage.login(USERNAME,PASSWORD);
        cartPage.openCart();
        cartPage.buttonContinueShopping();
    }

    @Test
    public void addItemByCartAndCheck(){
        loginPage.login(USERNAME,PASSWORD);
        productsPage.buttonAddToCart("Sauce Labs Bike Light");
        productsPage.buttonAddToCart("Sauce Labs Bolt T-Shirt");
        cartPage.openCart();
        cartPage.getCountItemInToCart();
    }

    @Test
    public void goToItemAndAddByCart(){
        loginPage.login(USERNAME,PASSWORD);
        productsPage.goToItemByLink("Sauce Labs Bolt T-Shirt");
        productsPage.buttonAddToCart("Sauce Labs Bolt T-Shirt");
        cartPage.openCart();
        cartPage.getCountItemInToCart();
    }


}
