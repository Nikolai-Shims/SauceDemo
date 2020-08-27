package tests;

import org.testng.annotations.Test;

public class ProductsTest extends BaseTest{

    @Test
    public void burgerMenu(){
        loginPage.login(USERNAME,PASSWORD);
        productsPage.Burger();
    }

    @Test
    public void selectItemByName(){
        loginPage.login(USERNAME,PASSWORD);
        productsPage.goToItemByLink("Sauce Labs Bolt T-Shirt");
    }

    @Test
    public void selectItemByImage(){
        loginPage.login(USERNAME,PASSWORD);
        productsPage.imageItem();

    }

    @Test
    public void dropDownMenu(){
        loginPage.login(USERNAME,PASSWORD);
        productsPage.dropDown();
    }

    @Test
    public void buttonAddToCartRemove(){
        loginPage.login(USERNAME,PASSWORD);
        productsPage.buttonAddToCart("Sauce Labs Bolt T-Shirt");
        productsPage.checkButtonRemoveWithProductPage("Sauce Labs Bolt T-Shirt","REMOVE");
    }

    @Test
    public void checkButtonBack(){
        loginPage.login(USERNAME,PASSWORD);
        productsPage.goToItemByLink("Sauce Labs Bolt T-Shirt");
        productsPage.buttonBack();
    }

}

