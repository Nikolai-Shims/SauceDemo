package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class LoginTest extends BaseTest {


    @Test
    public void correctLogin() {
        loginPage.openPage();
        loginPage.login(USERNAME, PASSWORD);
        productsPage.isPageOpened();

    }

    @Test
    public void emptyLogin() {
        loginPage.openPage();
        loginPage.login("", PASSWORD);
        assertEquals(loginPage.getErrorMessage(), "Epic sadface: Username is required");
    }

    @Test
    public void emptyPassword() {
        loginPage.openPage();
        loginPage.login(USERNAME, "");
        assertEquals(loginPage.getErrorMessage(), "Epic sadface: Password is required");
    }

    @Test
    public void uncorectlyLogin() {
        loginPage.openPage();
        loginPage.login("saddas", "141esdsa");
        assertEquals(loginPage.getErrorMessage(), "Epic sadface: Username and password do not match any user in this service");
    }
}

