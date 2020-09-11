package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class LoginTest extends BaseTest {

    @Test
    public void correctLogin() {
        loginPage
                .openPage()
                .login(USERNAME, PASSWORD)
                .isPageOpened();
    }

    @Test
    public void emptyLogin() {
        String str = loginPage
                .openPage()
                .loginWithoutRedirect("", PASSWORD)
                .getErrorMessage();
        Assert.assertEquals(str, "Epic sadface: Username is required");
    }

    @Test
    public void emptyPassword() {
        String gotText = loginPage
                .openPage()
                .loginWithoutRedirect(USERNAME, "")
                .getErrorMessage();
        assertEquals(gotText, "Epic sadface: Password is required");
    }

    @Test
    public void uncorectlyLogin() {
        String gotText = loginPage
                .openPage()
                .loginWithoutRedirect("saddas", "141esdsa")
                .getErrorMessage();
        assertEquals(gotText, "Epic sadface: Username and password do not match any user in this service");
    }
}

