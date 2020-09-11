package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HeaderPage extends BasePage {

    public static final By BURGER_MENU = By.cssSelector(".bm-burger-button");
    public static final By ABOUT = By.id("about_sidebar_link");
    public static final By LOGOUT = By.id("logout_sidebar_link");
    public static final By RESET_APP_STATE = By.id("reset_sidebar_link");
    public static final By ALL_ITEMS = By.id("inventory_sidebar_link");
    public static final By SHOPPING_CART = By.id("shopping_cart_container");
    public static final By NUMBER_OF_ITEM = By.cssSelector(".fa-layers-counter.shopping_cart_badge");
    public static final By CLOSE_BURGER_MENU = By.xpath("//button[text() = 'Close Menu']");

    public HeaderPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage clickLogout() {
        driver.findElement(LOGOUT).click();
        return new LoginPage(driver);
    }

    public ProductsPage clickAllItems() {
        driver.findElement(ALL_ITEMS).click();
        return new ProductsPage(driver);
    }

    public HeaderPage clickResetState() {
        driver.findElement(RESET_APP_STATE).click();
        return this;
    }

    public HeaderPage clickBurgerMenu() {
        driver.findElement(BURGER_MENU).click();
        return this;
    }

    public HeaderPage closeBurgerMenu() {
        driver.findElement(CLOSE_BURGER_MENU).click();
        return this;
    }

    public CartPage openCartByBadge() {
        driver.findElement(SHOPPING_CART).click();
        return new CartPage(driver);
    }

    public String getCountItemByShoppingCartBadge() {
        String number = driver.findElement(NUMBER_OF_ITEM).getText();
        return number;
    }

    @Override
    public HeaderPage isPageOpened() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(ABOUT));
        return this;
    }

    @Deprecated
    public HeaderPage openPage() {
        return null;
    }

}

