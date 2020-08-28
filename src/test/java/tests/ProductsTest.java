package tests;

import org.testng.annotations.Test;

public class ProductsTest extends BaseTest {


    @Test
    public void selectItemByName() {
        loginPage.openPage();
        loginPage.login(USERNAME, PASSWORD);
        productsPage.isPageOpened();
        productsPage.goToItemByLink("Sauce Labs Bolt T-Shirt");
    }

    @Test
    public void selectItemByImage() {
        loginPage.openPage();
        loginPage.login(USERNAME, PASSWORD);
        productsPage.isPageOpened();
        productsPage.goToItemByImage("Sauce Labs Bolt T-Shirt");

    }

    @Test
    public void changeSorting() {
        loginPage.openPage();
        loginPage.login(USERNAME, PASSWORD);
        productsPage.isPageOpened();
        productsPage.sortMenu("Price (high to low)");
    }

    @Test
    public void buttonAddToCartRemove() {
        loginPage.openPage();
        loginPage.login(USERNAME, PASSWORD);
        productsPage.isPageOpened();
        productsPage.clickAddToCart("Sauce Labs Bolt T-Shirt");
        productsPage.checkButtonRemoveWithProductPage("Sauce Labs Bolt T-Shirt", "REMOVE");
    }

    @Test
    public void validateButtonBack() {
        loginPage.openPage();
        loginPage.login(USERNAME, PASSWORD);
        productsPage.isPageOpened();
        productsPage.goToItemByLink("Sauce Labs Bolt T-Shirt");
        productsPage.clickBack();
        productsPage.isPageOpened();
    }

}

