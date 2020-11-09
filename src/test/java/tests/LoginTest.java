package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.qameta.allure.Link;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

@Listeners(TestListener.class)
public class LoginTest extends BaseTest {

    @Test(description = "Tест на логин")
    @Description("Логин использует стандартные имя юзера и пароль")
    @Issue("shim_nikolai")
    @Link("https://www.saucedemo.com/")
    public void correctLogin() {
        loginSteps
                .login(USERNAME,PASSWORD);
    }

    @Test(description = "Test on login with empty 'Login'")
    @Description("Login havn't 'Username' data")
    @Issue("shim_nikolai")
    @Link("https://www.saucedemo.com/")
    public void emptyLogin() {
        loginSteps
                .validateLogin("",PASSWORD)
                .validateErrorMessage("Epic sadface: Username is required");
    }

    @Test(description = "Test on login without password")
    @Description("Login haven't 'Password' data")
    @Issue("shim_nikolai")
    @Link("https://www.saucedemo.com/")
    public void emptyPassword() {
        loginSteps
                .validateLogin(USERNAME,"")
                .validateErrorMessage("Epic sadface: Password is required");
    }

    @Test(description = "Test on login with uncorrectly data")
    @Description("Login have wrong 'Username' and 'Password' data")
    @Issue("shim_nikolai")
    @Link("https://www.saucedemo.com/")
    public void uncorectlyLogin() {
        loginSteps
                .validateLogin("sadasd","12432dasas")
                .validateErrorMessage("Epic sadface: Username and password do not match any user in this service");
    }
}

