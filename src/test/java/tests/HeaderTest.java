package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

@Listeners(TestListener.class)
public class HeaderTest extends BaseTest {

    @Test(description = "Validate Burger Menu",retryAnalyzer = Retry.class)
    @Description("Check all function in Burger Menu")
    @Issue("shim_nikolai")
    public void validateBurgerMenu() {
        loginSteps
                .login(USERNAME,PASSWORD);
        productsPage
                .clickButtonAddToCart("Test.allTheThings() T-Shirt (Red)");
        assertEquals(headerPage.getCountItemByShoppingCartBadge(), "1");
        headerPage
                .clickBurgerMenu()
                .isPageOpened()
                .clickResetState()
                .closeBurgerMenu()
                .isPageOpened();
        cartSteps
                .validateCountItemInsideCart("0");
    }

    @Test(description = "Go to all items",retryAnalyzer = Retry.class)
    @Description("Go to 'Products page' from cart by 'Burger menu'")
    @Issue("shim_nikolai")
    public void switchingAllItem() {
    cartPage
            .openPage()
            .isPageOpened();
        headerPage
                .clickBurgerMenu()
                .isPageOpened()
                .clickAllItems()
                .isPageOpened();
    }


    @Test(description = "Logout",retryAnalyzer = Retry.class)
    @Description("Login and Log out")
    @Issue("shim_nikolai")
    public void logOut() {
        loginSteps
                .login(USERNAME,PASSWORD);
        headerPage
                .clickBurgerMenu()
                .isPageOpened()
                .clickLogout()
                .isPageOpened();
    }
}
