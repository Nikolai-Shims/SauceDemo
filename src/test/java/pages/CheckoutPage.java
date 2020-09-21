package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CheckoutPage extends BasePage {

    public static final By FIRST_NAME_CHECKOUT = By.id("first-name");
    public static final By LAST_NAME_CHECKOUT = By.id("last-name");
    public static final By ZIP_CODE_CHECKOUT = By.id("postal-code");
    public static final By CANCEL_BUTTON = By.cssSelector(".cart_cancel_link.btn_secondary");
    public static final By CONTINUE_BUTTON = By.cssSelector(".btn_primary.cart_button");
    public static final By ERROR_MESSAGE = By.cssSelector("[data-test=error]");


    public CheckoutPage(WebDriver driver) {
        super(driver);
    }


    public CartPage clickCancel() {
        driver.findElement(CANCEL_BUTTON).click();
        return new CartPage(driver);
    }

    public OverviewPage clickContinue() {
        driver.findElement(CONTINUE_BUTTON).click();
        return new OverviewPage(driver);
    }

    public CheckoutPage fillCheckoutInformation(String firstName, String lastName, String zipCode) {
        driver.findElement(FIRST_NAME_CHECKOUT).sendKeys(firstName);
        driver.findElement(LAST_NAME_CHECKOUT).sendKeys(lastName);
        driver.findElement(ZIP_CODE_CHECKOUT).sendKeys(zipCode);
        return this;
    }

    public String validateErrorMessage() {
        return driver.findElement(ERROR_MESSAGE).getText();
    }


    @Override
    public CheckoutPage isPageOpened() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(CANCEL_BUTTON));
        return this;
    }

    @Override
    public CheckoutPage openPage() {
        driver.get("https://www.saucedemo.com/checkout-step-one.html");
        isPageOpened();
        return this;
    }

}
