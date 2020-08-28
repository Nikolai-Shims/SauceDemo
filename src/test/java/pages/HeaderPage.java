package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HeaderPage extends BasePage {
    public static final By BURGER_MENU = By.cssSelector(".bm-burger-button");
    public static final By ABOUT = By.id("about_sidebar_link");
    public static final By LOGOUT = By.id("logout_sidebar_link");
    public static final By RESET_APP_STATE = By.id("reset_sidebar_link");
    public static final By ALL_ITEMS = By.id("inventory_sidebar_link");
    public static final By SHOPPING_CART = By.id("shopping_cart_container");

    public HeaderPage(WebDriver driver) {
        super(driver);
    }

    public void clickLogout() {
        driver.findElement(LOGOUT).click();
    }

    public void clickAllItems() {
        driver.findElement(ALL_ITEMS).click();
    }

    public void clickResetState() {
        driver.findElement(RESET_APP_STATE).click();
    }

    public void clickAbout() {
        driver.findElement(ABOUT).click();
    }

    public void clickBurgerMenu() {
        driver.findElement(BURGER_MENU).click();
    }

    public void openCart() {
        driver.findElement(SHOPPING_CART).click();
    }

}
