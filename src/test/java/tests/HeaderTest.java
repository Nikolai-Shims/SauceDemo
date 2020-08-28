package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HeaderTest extends BaseTest {

    @Test
    public void validateBurgerMenu() {
        loginPage.openPage();
        loginPage.login(USERNAME, PASSWORD);
        productsPage.isPageOpened();
        productsPage.clickAddToCart("Test.allTheThings() T-Shirt (Red)");
        headerPage.clickBurgerMenu();
        headerPage.clickResetState();
        cartPage.openPage();
        cartPage.isPageOpened();
        Assert.assertEquals(cartPage.getCountItemInsideCart(), "0");
        headerPage.clickBurgerMenu();
        headerPage.clickAllItems();
        productsPage.isPageOpened();
        headerPage.clickBurgerMenu();
        headerPage.clickAbout();
        headerPage.navigateBack();
        headerPage.clickBurgerMenu();
        headerPage.clickLogout();

    }

}
