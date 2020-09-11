package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class CheckoutTest extends BaseTest {
    public final static String FIRST_NAME = "Ivan";
    public final static String LAST_NAME = "Ivanov";
    public final static String ZIP_CODE = "1234";

    @Test
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

    @Test
    public void cancelButton() {
        cartPage
                .openPage()
                .clickCheckout()
                .isPageOpened()
                .clickCancel()
                .isPageOpened();
    }


    @Test
    public void fillCheckoutInformation() {
        cartPage
                .openPage()
                .clickCheckout()
                .isPageOpened()
                .fillCheckoutInformation(FIRST_NAME, LAST_NAME, ZIP_CODE)
                .clickContinue()
                .isPageOpened();
    }

    @Test
    public void validateErrorWithEmptyField() {
        cartPage
                .openPage()
                .clickCheckout()
                .fillCheckoutInformation("", "", "")
                .clickContinue();
        assertEquals(checkoutPage.validateErrorMessage(), "Error: First Name is required");
    }

    @Test
    public void validateErrorWithEmptyLastName() {
        cartPage
                .openPage()
                .clickCheckout()
                .fillCheckoutInformation(FIRST_NAME, "", ZIP_CODE)
                .clickContinue();
        assertEquals(checkoutPage.validateErrorMessage(), "Error: Last Name is required");
    }

    @Test
    public void validateErrorWithEmptyZipCode() {
        cartPage
                .openPage()
                .clickCheckout()
                .fillCheckoutInformation(FIRST_NAME, LAST_NAME, "")
                .clickContinue();
        assertEquals(checkoutPage.validateErrorMessage(), "Error: Postal Code is required");
    }

    @Test
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
