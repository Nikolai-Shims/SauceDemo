package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class CartPage extends BasePage {

    public static final By BUTTON_CONTINUE_SHOPPING = By.cssSelector(".btn_secondary");
    public static final By NUMBER_OF_ITEM = By.cssSelector(".fa-layers-counter.shopping_cart_badge");
    public static final By ITEM_BY_CART = By.cssSelector(".cart_item");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void openPage() {
        driver.get("https://www.saucedemo.com/cart.html");
    }

    public String getCountItemInsideCart() {
        List<WebElement> item = driver.findElements(ITEM_BY_CART);
        String countItem = String.valueOf(item.size());
        return countItem;
    }

    public String getCountItemByShoppingCartBadge() {
        String number = driver.findElement(NUMBER_OF_ITEM).getText();
        return number;
    }

    public void clickContinueShopping() {
        driver.findElement(BUTTON_CONTINUE_SHOPPING).click();
    }

    public void isPageOpened() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(BUTTON_CONTINUE_SHOPPING));
    }
}
