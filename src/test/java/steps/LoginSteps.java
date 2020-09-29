package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import pages.ProductsPage;

import static org.testng.Assert.assertEquals;

public class LoginSteps {

    LoginPage loginPage;
    ProductsPage productsPage;

    public LoginSteps(WebDriver driver) {
        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
    }

    @Step("Open login page,fill login and check that products page was open")
    public LoginSteps login(String username, String password) {
        loginPage
                .openPage()
                .isPageOpened()
                .login(username, password)
                .isPageOpened();
        return this;
    }

    @Step("Open login page and fill login window ")
    public LoginSteps validateLogin(String username,String password){
        loginPage
                .openPage()
                .isPageOpened()
                .login(username,password);
    return this;
    }

    @Step("Validate error message, with incorrectly data")
    public LoginSteps validateErrorMessage(String errorMessage) {
        assertEquals(loginPage.getErrorMessage(),errorMessage,"Text doesn't same");
        return this;
    }
}
