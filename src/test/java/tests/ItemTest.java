package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;


@Listeners(TestListener.class)
public class ItemTest extends BaseTest {


    @Test(description = "Return back to 'Products page'")
    @Description("Transition from 'Item Page' to 'Products Page'")
    @Issue("shim_nikolai")
    public void validateButtonBack() {
        loginSteps
                .login(USERNAME,PASSWORD);
        productsPage
                .goToItemByLink("Sauce Labs Bolt T-Shirt")
                .clickBack()
                .isPageOpened();
    }

    @Test(description = "Add and remove item")
    @Description("Validate that item can be add and remove from 'Item Page'")
    @Issue("shim_nikolai")
    public void addAndRemoveItem() {
        productsPage
                .openPage()
                .isPageOpened()
                .goToItemByImage("Sauce Labs Bolt T-Shirt")
                .clickAddToCartButton();
        cartSteps
                .validateCountItemInsideCart("1");
        productsPage
                .openPage()
                .isPageOpened()
                .goToItemByLink("Sauce Labs Bolt T-Shirt")
                .clickRemoveButton();
        cartSteps
                .validateCountItemInsideCart("0");

    }
}
