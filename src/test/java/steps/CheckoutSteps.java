package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.CartPage;
import pages.CheckoutPage;
import pages.OverviewPage;

import static org.testng.Assert.assertEquals;

public class CheckoutSteps {
    CartPage cart;
    CheckoutPage checkoutPage;
    OverviewPage overviewPage;

    public CheckoutSteps(WebDriver driver){
        cart = new CartPage(driver);
        checkoutPage = new CheckoutPage(driver);
        overviewPage = new OverviewPage(driver);
    }

    @Step("Fill checkout window")
    public CheckoutSteps validateCheckout(String firstName, String lastName, String zipCode){
        cart
                .openPage()
                .isPageOpened()
                .clickCheckout()
                .fillCheckoutInformation(firstName, lastName, zipCode)
                .clickContinue();
    return this;
    }

    @Step("Get error message and validate error message on checkout page")
    public CheckoutSteps validateErrorMessage(String errorMessage){
        assertEquals(checkoutPage.validateErrorMessage(),errorMessage);
        return this;
    }

    @Step("Fill checkout window correct data and check that overview page was opened ")
    public CheckoutSteps correctCheckout(String firstName, String lastName, String zipCode){
        validateCheckout(firstName, lastName, zipCode);
        overviewPage
                .isPageOpened();
        return this;
    }
}
