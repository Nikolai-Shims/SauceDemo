package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasePage {
    WebDriver driver;

    public static final By USERNAME_INPUT = By.id("user-name");
    public static final By PASSWORD_INPUT = By.id("password");
    public static final By LOGIN_BUTTON = By.id("login-button");
    public static final By ERROR_BUTTON = By.cssSelector("[data-test='error']");
    public static final By BURGER_MENU = By.cssSelector(".bm-burger-button");
    public static final By FIRST_NAME_CHECKOUT = By.id("first-name");
    public static final By LAST_NAME_CHECKOUT = By.id("last-name");
    public static final By ZIP_CODE_CHECKOUT = By.id("postal-code");


    public BasePage(WebDriver driver){
        this.driver = driver;
    }
}
