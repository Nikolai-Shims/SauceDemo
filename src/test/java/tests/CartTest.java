package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

@Listeners(TestListener.class)
public class CartTest extends BaseTest {

    @Test(description = "Login to the Cart")
    @Description("Login to the cart and check that 'Cart Page' was opened")
    @Issue("shim_nikolai")
    public void logInToCart() {
        loginSteps
                .login(USERNAME,PASSWORD);
        cartPage
                .openPage();
    }

    @Test(description = "Return back from Cart to Products Page")
    @Description("Login to the cart and return back to the 'Products Page'")
    @Issue("shim_nikolai")
    public void clickButtonContinue() {
        loginSteps
                .login(USERNAME,PASSWORD);
        cartPage
                .openPage()
                .clickContinueShopping()
                .isPageOpened();
    }

    @Test(description = "Add item to the Cart")
    @Description("Add item to the Cart and validate that item was added")
    @Issue("shim_nikolai")
    public void addItemToCartAndValidate() {
        loginSteps
                .login(USERNAME,PASSWORD);
        productsPage
                .clickButtonAddToCart("Sauce Labs Bike Light")
                .clickButtonAddToCart("Sauce Labs Bolt T-Shirt");
        cartPage
                .openPage();
        assertEquals(cartPage.getCountItemInsideCart(), headerPage.getCountItemByShoppingCartBadge());
    }

}
