package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class OverviewPage extends BasePage {

    public static final By FINISH_BUTTON = By.cssSelector(".btn_action.cart_button");
    public static final By CANCEL_BUTTON = By.cssSelector(".cart_cancel_link.btn_secondary");
    public static final By CONFIRMATION_TEXT = By.cssSelector(".complete-header");

    public OverviewPage(WebDriver driver) {
        super(driver);
    }

    @Step("Finish order")
    public void clickFinish() {
        driver.findElement(FINISH_BUTTON).click();
    }

    @Step("Cancel order")
    public ProductsPage clickCancel() {
        driver.findElement(CANCEL_BUTTON).click();
        return new ProductsPage(driver);
    }

    @Step("Get text that order was done")
    public String validateOrderCompletion() {
        String text = driver.findElement(CONFIRMATION_TEXT).getText();
        return text;
    }

    @Deprecated
    public OverviewPage openPage() {
        return null;
    }

    @Override
    @Step("Check that 'Overview Page' was opened")
    public OverviewPage isPageOpened() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(FINISH_BUTTON));
        return this;
    }

}

