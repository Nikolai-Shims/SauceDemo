package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class ProductsPage extends BasePage {

    public static final By SORT_MENU = By.cssSelector(".product_sort_container");
    String addButton = "//*[contains(text(),'%s')]/ancestor::div[@class='inventory_item']//*[text()='ADD TO CART']";
    String removeButton = "//*[contains(text(),'%s')]/ancestor::div[@class='inventory_item']//*[text()='REMOVE']";
    String goToItemByLink = "//*[contains(text(),'%s')]/ancestor::a[@href]";
    String goToItemByImage = "//*[contains(text(), '%s')]/ancestor::div[@class='inventory_item']//img[@src]";

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    @Step("Go to 'Item Page' by link")
    public ItemPage goToItemByLink(String nameItem) {
        driver.findElement(By.xpath(String.format(goToItemByLink, nameItem))).click();
        return new ItemPage(driver);
    }

    @Step("Go to 'Item page' by image")
    public ItemPage goToItemByImage(String nameItem) {
        driver.findElement(By.xpath(String.format(goToItemByImage, nameItem))).click();
        return new ItemPage(driver);
    }

    @Step("Choose Sort Menu")
    public ProductsPage sortMenu(String sortByText) {
        Select select = new Select(driver.findElement(SORT_MENU));
        select.selectByVisibleText(sortByText);
        return this;
    }

    @Step("Add to Cart")
    public ProductsPage clickButtonAddToCart(String productName) {
        driver.findElement(By.xpath(String.format(addButton, productName))).click();
        return this;
    }

    @Step("Remove from Cart")
    public ProductsPage clickButtonRemoveFromCart(String productName) {
        driver.findElement(By.xpath(String.format(removeButton, productName))).click();
        return this;
    }

    @Override
    @Step("Check that 'Products Page' was opened")
    public ProductsPage isPageOpened() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(SORT_MENU));
        return this;
    }

    @Override
    @Step("Open 'Products Page'")
    public ProductsPage openPage() {
        driver.get("https://www.saucedemo.com/inventory.html");
        isPageOpened();
        return this;
    }

}

