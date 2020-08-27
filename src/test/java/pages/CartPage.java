package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class CartPage extends BasePage{
    public CartPage(WebDriver driver){
        super(driver);
    }

    public void openCart(){
        driver.findElement(By.id("shopping_cart_container")).click();
    }

    public void getCountItemInToCart(){
        List<WebElement> item=  driver.findElements(By.cssSelector(".cart_item"));
        String countItem = String.valueOf(item.size());


        String number = driver.findElement(By.cssSelector(".fa-layers-counter.shopping_cart_badge")).getText();
        Assert.assertEquals(number,countItem);

    }

    public void buttonContinueShopping(){
        driver.findElement(By.cssSelector(".btn_secondary")).click();
    }
}
