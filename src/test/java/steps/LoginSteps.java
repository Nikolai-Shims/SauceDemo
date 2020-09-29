package steps;

import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import pages.ProductsPage;

import static org.testng.Assert.assertEquals;

public class LoginSteps {

    WebDriver driver;
    LoginPage loginPage;
    ProductsPage productsPage;

    public LoginSteps(WebDriver driver) {
        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
    }

    public LoginSteps login(String username, String password) {
        loginPage
                .openPage()
                .isPageOpened()
                .login(username, password)
                .isPageOpened();
        return this;
    }

    public LoginSteps validateLogin(String username,String password){
        loginPage
                .openPage()
                .isPageOpened()
                .login(username,password);
    return this;
    }

    public LoginSteps validateErrorMessage(String errorMessage) {
        assertEquals(loginPage.getErrorMessage(),errorMessage,"Text doesn't same");
        return this;
    }
}
