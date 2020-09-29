package tests;


import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.qameta.allure.Link;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

@Listeners(TestListener.class)
public class CheckoutTest extends BaseTest {

    public final static String FIRST_NAME = "Ivan";
    public final static String LAST_NAME = "Ivanov";
    public final static String ZIP_CODE = "1234";

    @Test(description = "Go to 'Checkout Page'")
    @Description("Go to 'Checkout Page' and validate that 'Checkout Page' was opened")
    @Issue("shim_nikolai")
    public void checkoutButton() {
        loginSteps
                .login(USERNAME, PASSWORD);
        cartPage
                .openPage()
                .clickCheckout()
                .isPageOpened();
    }

    @Test(description = "Go to 'Checkout Page' and return back to 'Cart page'")
    @Description("Go to 'Checkout Page' and return back to 'Cart page' and validate that 'Cart Page was opened'")
    @Issue("shim_nikolai")
    public void cancelButton() {
        cartPage
                .openPage()
                .clickCheckout()
                .isPageOpened()
                .clickCancel()
                .isPageOpened();
    }


    @Test(description = "Fill Checkout information")
    @Description("Fill Checkout information with correct data")
    @Issue("shim_nikolai")
    @Link("https://www.saucedemo.com/")
    public void fillCheckoutInformation() {
        checkoutSteps
                .correctCheckout(FIRST_NAME, LAST_NAME, ZIP_CODE);

    }

    @Test(description = "Fill checkout information")
    @Description("Fill Checkout information without data")
    @Issue("shim_nikolai")
    @Link("https://www.saucedemo.com/")
    public void validateErrorWithEmptyField() {
        checkoutSteps
                .validateCheckout("", "", "")
                .validateErrorMessage("Error: First Name is required");
    }

    @Test(description = "Fill checkout information")
    @Description("Fill Checkout information without 'Last Name' data")
    @Issue("shim_nikolai")
    @Link("https://www.saucedemo.com/")
    public void validateErrorWithEmptyLastName() {
        checkoutSteps
                .validateCheckout(FIRST_NAME, "", ZIP_CODE)
                .validateErrorMessage("Error: Last Name is required");
    }

    @Test(description = "Fill checkout information")
    @Description("Fill Checkout information without 'Zip Code' data")
    @Issue("shim_nikolai")
    @Link("https://www.saucedemo.com/")
    public void validateErrorWithEmptyZipCode() {
        checkoutSteps
                .validateCheckout(FIRST_NAME, LAST_NAME, "")
                .validateErrorMessage("Error: Postal Code is required");
    }

    @Test(description = "Complete order")
    @Description("Go to through all steps")
    @Issue("shim_nikolai")
    @Link("https://www.saucedemo.com/")
    public void validateCompleteOrder() {
        loginSteps
                .login(USERNAME, PASSWORD);
        productsPage
                .clickButtonAddToCart("Sauce Labs Bike Light")
                .clickButtonAddToCart("Sauce Labs Bolt T-Shirt");
        cartSteps
                .validateCountItemInsideCart("2");
        checkoutSteps
                .correctCheckout(FIRST_NAME, LAST_NAME, ZIP_CODE);
        overviewPage
                .clickFinish();
        assertEquals(overviewPage.validateOrderCompletion(), "THANK YOU FOR YOUR ORDER");

    }

}
