package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {

    public static final By USERNAME_INPUT = By.id("user-name");
    public static final By PASSWORD_INPUT = By.id("password");
    public static final By LOGIN_BUTTON = By.id("login-button");
    public static final By ERROR_BUTTON = By.cssSelector("[data-test='error']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public LoginPage isPageOpened() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(LOGIN_BUTTON));
        return this;
    }

    @Override
    public LoginPage openPage() {
        driver.get("https://www.saucedemo.com/");
        isPageOpened();
        return this;
    }

    @Step("")
    public ProductsPage login(String username, String password) {
        loginWithoutRedirect(username, password);
        return new ProductsPage(driver);
    }

    public LoginPage loginWithoutRedirect(String username, String password) {
        driver.findElement(USERNAME_INPUT).sendKeys(username);
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();
        return this;
    }

    public String getErrorMessage() {
        return driver.findElement(ERROR_BUTTON).getText();
    }
}
