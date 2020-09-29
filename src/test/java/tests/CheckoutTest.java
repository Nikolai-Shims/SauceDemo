package tests;


import io.qameta.allure.Description;
import io.qameta.allure.Issue;
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
        loginPage
                .openPage()
                .login(USERNAME, PASSWORD)
                .isPageOpened();
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
    public void fillCheckoutInformation() {
        cartPage
                .openPage()
                .clickCheckout()
                .isPageOpened()
                .fillCheckoutInformation(FIRST_NAME, LAST_NAME, ZIP_CODE)
                .clickContinue()
                .isPageOpened();
    }

    @Test(description = "Fill checkout information")
    @Description("Fill Checkout information without data")
    @Issue("shim_nikolai")
    public void validateErrorWithEmptyField() {
        cartPage
                .openPage()
                .clickCheckout()
                .fillCheckoutInformation("", "", "")
                .clickContinue();
        assertEquals(checkoutPage.validateErrorMessage(), "Error: First Name is required");
    }

    @Test(description = "Fill checkout information")
    @Description("Fill Checkout information without 'Last Name' data")
    @Issue("shim_nikolai")
    public void validateErrorWithEmptyLastName() {
        cartPage
                .openPage()
                .clickCheckout()
                .fillCheckoutInformation(FIRST_NAME, "", ZIP_CODE)
                .clickContinue();
        assertEquals(checkoutPage.validateErrorMessage(), "Error: Last Name is required");
    }

    @Test(description = "Fill checkout information")
    @Description("Fill Checkout information without 'Zip Code' data")
    @Issue("shim_nikolai")
    public void validateErrorWithEmptyZipCode() {
        cartPage
                .openPage()
                .clickCheckout()
                .fillCheckoutInformation(FIRST_NAME, LAST_NAME, "")
                .clickContinue();
        assertEquals(checkoutPage.validateErrorMessage(), "Error: Postal Code is required");
    }

    @Test(description = "Complete order")
    @Description("Go to through all steps")
    @Issue("shim_nikolai")
    public void validateCompleteOrder() {
        loginPage
                .openPage()
                .login(USERNAME, PASSWORD)
                .isPageOpened()
                .clickButtonAddToCart("Sauce Labs Bike Light")
                .clickButtonAddToCart("Sauce Labs Bolt T-Shirt");
        cartPage
                .openPage();
        assertEquals(cartPage.getCountItemInsideCart(), "2");
        cartPage
                .clickCheckout()
                .fillCheckoutInformation(FIRST_NAME, LAST_NAME, ZIP_CODE)
                .clickContinue()
                .isPageOpened()
                .clickFinish();
        assertEquals(overviewPage.validateOrderCompletion(), "THANK YOU FOR YOUR ORDER");

    }

}
