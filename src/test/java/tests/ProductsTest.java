package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

@Listeners(TestListener.class)
public class ProductsTest extends BaseTest {


    @Test(description = "Select item")
    @Description("Select item by name and transition to 'Item Page'")
    @Issue("shim_nikolai")
    public void selectItemByName() {
        loginSteps
                .login(USERNAME,PASSWORD);
        productsPage
                .goToItemByLink("Sauce Labs Bolt T-Shirt")
                .isPageOpened();
    }

    @Test(description = "Select item")
    @Description("Select item by image and transition to 'Item Page'")
    @Issue("shim_nikolai")
    public void selectItemByImage() {
        loginSteps
                .login(USERNAME,PASSWORD);
        productsPage
                .goToItemByImage("Sauce Labs Bolt T-Shirt")
                .isPageOpened();
    }

    @Test(description = "Change sorting on 'Products Page'")
    @Description("Change sorting to 'Products Page'")
    @Issue("shim_nikolai")
    public void changeSorting() {
        loginSteps
                .login(USERNAME,PASSWORD);
        productsPage
                .sortMenu("Price (high to low)")
                .isPageOpened();
    }

    @Test(description = "Add and remove item")
    @Description("Add item and remove ite from 'Products Page'")
    @Issue("shim_nikolai")
    public void AddItemToCartAndRemoveIt() {
        loginSteps
                .login(USERNAME,PASSWORD);
        productsPage
                .clickButtonAddToCart("Sauce Labs Bolt T-Shirt");
        cartSteps
                .validateCountItemInsideCart("1");
        productsPage
                .openPage()
                .clickButtonRemoveFromCart("Sauce Labs Bolt T-Shirt");
        cartSteps
                .validateCountItemInsideCart("0");
    }


}

