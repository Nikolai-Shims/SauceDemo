package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CheckoutPage extends BasePage {

    public static final By FIRST_NAME_CHECKOUT = By.id("first-name");
    public static final By LAST_NAME_CHECKOUT = By.id("last-name");
    public static final By ZIP_CODE_CHECKOUT = By.id("postal-code");
    public static final By CHECKOUT_BUTTON = By.cssSelector(".btn_action.checkout_button");
    public static final By CANCEL_BUTTON = By.cssSelector(".cart_cancel_link.btn_secondary");
    public static final By CONTINUE_BUTTON = By.cssSelector(".btn_primary.cart_button");
    public static final By FINISH_BUTTON = By.cssSelector(".btn_action.cart_button");
    public static final By ERROR_MESSAGE = By.cssSelector("[data-test=error]");
    public static final By CONFIRMATION_TEXT = By.cssSelector(".complete-header");

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public void clickCheckout() {
        driver.findElement(CHECKOUT_BUTTON).click();
    }

    public void clickCancel() {
        driver.findElement(CANCEL_BUTTON).click();
    }

    public void clickFinish() {
        driver.findElement(FINISH_BUTTON).click();
    }

    public void clickContinue() {
        driver.findElement(CONTINUE_BUTTON).click();
    }

    public void fillCheckoutInformation(String firstName, String lastName, String zipCode) {
        driver.findElement(FIRST_NAME_CHECKOUT).sendKeys(firstName);
        driver.findElement(LAST_NAME_CHECKOUT).sendKeys(lastName);
        driver.findElement(ZIP_CODE_CHECKOUT).sendKeys(zipCode);
    }

    public String validateErrorMessage() {
        return driver.findElement(ERROR_MESSAGE).getText();
    }

    public String validateOrderCompletion() {
        String text = driver.findElement(CONFIRMATION_TEXT).getText();
        return text;
    }

    public void isCheckoutPageOpened() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(CONTINUE_BUTTON));
    }

    public void isCheckoutOverviewOpened() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(FINISH_BUTTON));
    }

}
