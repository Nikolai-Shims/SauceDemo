package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class ProductsPage extends BasePage {

    public static final By BACK_BUTTON = By.cssSelector(".inventory_details_back_button");
    public static final By SORT_MENU = By.cssSelector(".product_sort_container");

    String addButton = "//*[contains(text(),'%s')]/ancestor::div[@class='inventory_item']//*[text()='ADD TO CART']";
    String removeButton = "//*[contains(text(),'%s')]/ancestor::div[@class='inventory_item']//*[text()='%s']";
    String goToItemByLink = "//*[contains(text(),'%s')]/ancestor::a[@href]";
    String goToItemByImage = "//*[contains(text(), '%s')]/ancestor::div[@class='inventory_item']//img[@src]";


    public ProductsPage(WebDriver driver) {
        super(driver);
    }


    public void goToItemByLink(String nameItem) {
        driver.findElement(By.xpath(String.format(goToItemByLink, nameItem))).click();
    }

    public void goToItemByImage(String nameItem) {
        driver.findElement(By.xpath(String.format(goToItemByImage, nameItem))).click();
    }

    public void clickBack() {
        driver.findElement(BACK_BUTTON).click();
    }

    public void sortMenu(String sortByText) {
        Select select = new Select(driver.findElement(SORT_MENU));
        select.selectByVisibleText(sortByText);
    }

    public void clickAddToCart(String productName) {
        driver.findElement(By.xpath(String.format(addButton, productName))).click();
    }

    public void checkButtonRemoveWithProductPage(String productName, String nameButton) {
        driver.findElement(By.xpath(String.format(removeButton, productName, nameButton))).click();
    }

    public void isPageOpened() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(SORT_MENU));
    }


}

