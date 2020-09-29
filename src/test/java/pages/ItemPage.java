package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ItemPage extends BasePage {

    public static final By BACK_BUTTON = By.cssSelector(".inventory_details_back_button");
    public static final By ADD_BUTTON = By.xpath("//*[text() = 'ADD TO CART']");
    public static final By REMOVE_BUTTON = By.xpath("//*[text() = 'REMOVE']");

    public ItemPage(WebDriver driver) {
        super(driver);
    }

    @Step("Remove item from Cart")
    public ItemPage clickRemoveButton() {
        driver.findElement(REMOVE_BUTTON).click();
        return this;
    }

    @Step("Add item to cart")
    public ItemPage clickAddToCartButton() {
        driver.findElement(ADD_BUTTON).click();
        return this;
    }

    @Step("Return back to 'Products Page'")
    public ProductsPage clickBack() {
        driver.findElement(BACK_BUTTON).click();
        return new ProductsPage(driver);
    }

    @Override
    @Step("Check that 'Item Page' was opened")
    public ItemPage isPageOpened() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(BACK_BUTTON));
        return this;
    }

    @Deprecated
    public ItemPage openPage() {
        return null;
    }
}
