package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class CartPage extends BasePage {

    public static final By BUTTON_CONTINUE_SHOPPING = By.cssSelector(".btn_secondary");
    public static final By ITEM_BY_CART = By.cssSelector(".cart_item");
    public static final By CHECKOUT_BUTTON = By.cssSelector(".btn_action.checkout_button");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    @Step("Get all elements inside cart")
    public String getCountItemInsideCart() {
        List<WebElement> item = driver.findElements(ITEM_BY_CART);
        String countItem = String.valueOf(item.size());
        return countItem;
    }

    @Step("Go to 'Checkout Page'")
    public CheckoutPage clickCheckout() {
        driver.findElement(CHECKOUT_BUTTON).click();
        return new CheckoutPage(driver);
    }

    @Step("Return from 'Cart' on the 'Products Page'")
    public ProductsPage clickContinueShopping() {
        driver.findElement(BUTTON_CONTINUE_SHOPPING).click();
        return new ProductsPage(driver);
    }

    @Override
    @Step("Check that 'Cart Page' was opened")
    public CartPage isPageOpened() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(BUTTON_CONTINUE_SHOPPING));
        return this;
    }

    @Override
    @Step("Open 'Cart Page'")
    public CartPage openPage() {
        driver.get("https://www.saucedemo.com/cart.html");
        isPageOpened();
        return this;
    }

}
