package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

@Listeners(TestListener.class)
public class LoginTest extends BaseTest {

    @Test(description = "Tест на логин")
    @Description("Логин использует стандартные имя юзера и пароль")
    @Issue("shim_nikolai")
    public void correctLogin() {
        loginPage
                .openPage()
                .login(USERNAME, PASSWORD)
                .isPageOpened();
    }

    @Test(description = "Test on login with empty 'Login'")
    @Description("Login havn't 'Username' data")
    @Issue("shim_nikolai")
    public void emptyLogin() {
        String str = loginPage
                .openPage()
                .loginWithoutRedirect("", PASSWORD)
                .getErrorMessage();
        Assert.assertEquals(str, "Epic sadface: Username is required");
    }

    @Test(description = "Test on login without password")
    @Description("Login haven't 'Password' data")
    @Issue("shim_nikolai")
    public void emptyPassword() {
        String gotText = loginPage
                .openPage()
                .loginWithoutRedirect(USERNAME, "")
                .getErrorMessage();
        assertEquals(gotText, "Epic sadface: Password is required");
    }

    @Test(description = "Test on login with uncorrectly data")
    @Description("Login have wrong 'Username' and 'Password' data")
    @Issue("shim_nikolai")
    public void uncorectlyLogin() {
        String gotText = loginPage
                .openPage()
                .loginWithoutRedirect("saddas", "141esdsa")
                .getErrorMessage();
        assertEquals(gotText, "Epic sadface: Username and password do not match any user in this service");
    }
}

