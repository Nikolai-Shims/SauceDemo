package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutTest extends BaseTest {
    public final static String FIRST_NAME = "Ivan";
    public final static String LAST_NAME = "Ivanov";
    public final static String ZIP_CODE = "1234";

    @Test
    public void checkoutButton() {
        loginPage.openPage();
        loginPage.login(USERNAME, PASSWORD);
        cartPage.openPage();
        cartPage.isPageOpened();
        checkoutPage.clickCheckout();
        checkoutPage.isCheckoutPageOpened();
    }

    @Test
    public void cancelButton() {
        loginPage.openPage();
        loginPage.login(USERNAME, PASSWORD);
        cartPage.openPage();
        cartPage.isPageOpened();
        checkoutPage.clickCheckout();
        checkoutPage.isCheckoutPageOpened();
        checkoutPage.clickCancel();
        cartPage.isPageOpened();
    }

    @Test
    public void continueButton() {
        loginPage.openPage();
        loginPage.login(USERNAME, PASSWORD);
        cartPage.openPage();
        cartPage.isPageOpened();
        checkoutPage.clickCheckout();
        checkoutPage.isCheckoutPageOpened();
        checkoutPage.clickContinue();
    }

    @Test
    public void fillCheckoutInformation() {
        loginPage.openPage();
        loginPage.login(USERNAME, PASSWORD);
        cartPage.openPage();
        cartPage.isPageOpened();
        checkoutPage.clickCheckout();
        checkoutPage.isCheckoutPageOpened();
        checkoutPage.fillCheckoutInformation(FIRST_NAME, LAST_NAME, ZIP_CODE);
        checkoutPage.clickContinue();
        checkoutPage.isCheckoutOverviewOpened();
    }

    @Test
    public void validateErrorWithEmptyField() {
        loginPage.openPage();
        loginPage.login(USERNAME, PASSWORD);
        cartPage.openPage();
        cartPage.isPageOpened();
        checkoutPage.clickCheckout();
        checkoutPage.isCheckoutPageOpened();
        checkoutPage.fillCheckoutInformation("", "", "");
        checkoutPage.clickContinue();
        Assert.assertEquals(checkoutPage.validateErrorMessage(), "Error: First Name is required");
    }

    @Test
    public void validateErrorWithEmptyLastName() {
        loginPage.openPage();
        loginPage.login(USERNAME, PASSWORD);
        cartPage.openPage();
        cartPage.isPageOpened();
        checkoutPage.clickCheckout();
        checkoutPage.isCheckoutPageOpened();
        checkoutPage.fillCheckoutInformation(FIRST_NAME, "", ZIP_CODE);
        checkoutPage.clickContinue();
        Assert.assertEquals(checkoutPage.validateErrorMessage(), "Error: Last Name is required");
    }

    @Test
    public void validateErrorWithEmptyZipCode() {
        loginPage.openPage();
        loginPage.login(USERNAME, PASSWORD);
        cartPage.openPage();
        cartPage.isPageOpened();
        checkoutPage.clickCheckout();
        checkoutPage.isCheckoutPageOpened();
        checkoutPage.fillCheckoutInformation(FIRST_NAME, LAST_NAME, "");
        checkoutPage.clickContinue();
        Assert.assertEquals(checkoutPage.validateErrorMessage(), "Error: Postal Code is required");
    }

    @Test
    public void validateCompleteOrder() {
        loginPage.openPage();
        loginPage.login(USERNAME, PASSWORD);
        productsPage.isPageOpened();
        productsPage.clickAddToCart("Sauce Labs Bike Light");
        productsPage.clickAddToCart("Sauce Labs Bolt T-Shirt");
        headerPage.openCart();
        cartPage.isPageOpened();
        Assert.assertEquals(cartPage.getCountItemInsideCart(), "2");
        checkoutPage.clickCheckout();
        checkoutPage.isCheckoutPageOpened();
        checkoutPage.fillCheckoutInformation(FIRST_NAME, LAST_NAME, ZIP_CODE);
        checkoutPage.clickContinue();
        checkoutPage.isCheckoutOverviewOpened();
        checkoutPage.clickFinish();
        Assert.assertEquals(checkoutPage.validateOrderCompletion(), "THANK YOU FOR YOUR ORDER");

    }

}
