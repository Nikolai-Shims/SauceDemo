package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

@Listeners(TestListener.class)
public class HeaderTest extends BaseTest {

    @Test(description = "Validate Burger Menu")
    @Description("Check all function in Burger Menu")
    @Issue("shim_nikolai")
    public void validateBurgerMenu(){
        loginPage
                .openPage()
                .isPageOpened()
                .login(USERNAME, PASSWORD)
                .isPageOpened()
                .clickButtonAddToCart("Test.allTheThings() T-Shirt (Red)");
        assertEquals(headerPage.getCountItemByShoppingCartBadge(), "1");
        headerPage
                .clickBurgerMenu()
                .clickResetState()
                .closeBurgerMenu()
                .openCartByBadge()
                .isPageOpened();
        assertEquals(cartPage.getCountItemInsideCart(), "0");
        headerPage
                .clickBurgerMenu()
                .clickAllItems()
                .isPageOpened();
        headerPage
                .clickBurgerMenu()
                .clickLogout()
                .isPageOpened();
    }

}
