package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class ProductsPage extends BasePage {
    String addButton = "//*[contains(text(),'%s')]/ancestor::div[@class='inventory_item']//*[text()='ADD TO CART']";
    String removeButton = "//*[contains(text(),'%s')]/ancestor::div[@class='inventory_item']//*[text()='%s']";
    String goToItemBylink = "//*[contains(text(),'%s')]/ancestor::a[@href]";


    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public void Burger() {
        driver.findElement(BURGER_MENU).click();
        driver.findElement(By.id("inventory_sidebar_link")).click();
        driver.findElement(BURGER_MENU).click();
        driver.findElement(By.id("about_sidebar_link")).click();
        driver.navigate().back();
        driver.findElement(BURGER_MENU).click();
        driver.findElement(By.id("reset_sidebar_link")).click();
        driver.findElement(By.id("logout_sidebar_link")).click();
    }

    public void goToItemByLink(String nameItem) {
        driver.findElement(By.xpath(String.format(goToItemBylink, nameItem))).click();
    }

    public void imageItem() {
        driver.findElement(By.cssSelector("[src='./img/red-tatt-1200x1500.jpg']")).click();
    }

    public void buttonBack() {
        driver.findElement(By.cssSelector(".inventory_details_back_button")).click();
    }

    public void dropDown() {
        Select select = new Select(driver.findElement(By.cssSelector(".product_sort_container")));
        select.selectByValue("az");
    }

    public void buttonAddToCart(String productName) {
        driver.findElement(By.xpath(String.format(addButton, productName))).click();
    }

    public void checkButtonRemoveWithProductPage(String productName, String nameButton) {
        driver.findElement(By.xpath(String.format(removeButton, productName, nameButton))).click();
    }


}

