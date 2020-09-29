package steps;

import org.openqa.selenium.WebDriver;
import pages.CartPage;
import pages.CheckoutPage;
import pages.OverviewPage;

import static org.testng.Assert.assertEquals;

public class CheckoutSteps {
    WebDriver driver;
    CartPage cart;
    CheckoutPage checkoutPage;
    OverviewPage overviewPage;

    public CheckoutSteps(WebDriver driver){
        cart = new CartPage(driver);
        checkoutPage = new CheckoutPage(driver);
        overviewPage = new OverviewPage(driver);
    }

    public CheckoutSteps validateCheckout(String firstName, String lastName, String zipCode){
        cart
                .openPage()
                .isPageOpened()
                .clickCheckout()
                .fillCheckoutInformation(firstName, lastName, zipCode)
                .clickContinue();
    return this;
    }

    public CheckoutSteps validateErrorMessage(String errorMessage){
        assertEquals(checkoutPage.validateErrorMessage(),errorMessage);
        return this;
    }

    public CheckoutSteps correctCheckout(String firstName, String lastName, String zipCode){
        validateCheckout(firstName, lastName, zipCode);
        overviewPage
                .isPageOpened();
        return this;
    }
}
