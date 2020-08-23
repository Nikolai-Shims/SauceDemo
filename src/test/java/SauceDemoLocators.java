import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SauceDemoLocators {
    WebDriver driver;

    @BeforeMethod
    public void start() {
        System.setProperty("webdriver.chrome.driver", "src//test//resources//chromedriver");
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/inventory.html");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void BurgerMenu() {
        driver.findElement(By.cssSelector(".bm-burger-button")).click();
        driver.findElement(By.xpath("//*[text() = 'Close Menu']"));
        driver.findElement(By.id("inventory_sidebar_link"));
        driver.findElement(By.id("about_sidebar_link"));
        driver.findElement(By.id("logout_sidebar_link"));
        driver.findElement(By.id("reset_sidebar_link"));
    }

    @Test
    public void Logo() {
        driver.findElement(By.cssSelector(".app_logo"));
    }

    @Test
    public void Cart() {
        driver.findElement(By.id("shopping_cart_container")).click();
        driver.findElement(By.cssSelector(".btn_secondary"));
        driver.findElement(By.cssSelector(".btn_action.checkout_button")).click();
        driver.findElement(By.id("first-name"));
        driver.findElement(By.id("last-name"));
        driver.findElement(By.id("postal-code"));
        driver.findElement(By.cssSelector(".cart_cancel_link.btn_secondary"));
        driver.findElement(By.cssSelector(".btn_primary.cart_button"));
    }

    @Test
    public void DropDown() {
        driver.findElement(By.cssSelector(".product_sort_container")).click();
        driver.findElement(By.cssSelector("[value=az]"));
        driver.findElement(By.cssSelector("[value=za]"));
        driver.findElement(By.cssSelector("[value=lohi]"));
        driver.findElement(By.cssSelector("[value=hilo]"));
    }

    @Test
    public void Inventory1() {
        driver.findElement(By.id("item_4_img_link"));
        driver.findElement(By.id("item_4_title_link"));
        driver.findElements(By.cssSelector(".btn_primary.btn_inventory")).get(0);
    }

    @Test
    public void Inventory2() {
        driver.findElement(By.id("item_0_img_link"));
        driver.findElement(By.id("item_0_title_link"));
        driver.findElements(By.cssSelector(".btn_primary.btn_inventory")).get(1);
    }

    @Test
    public void Inventory3() {
        driver.findElement(By.id("item_1_img_link"));
        driver.findElement(By.id("item_1_title_link"));
        driver.findElements(By.cssSelector(".btn_primary.btn_inventory")).get(2);
    }

    @Test
    public void Inventory4() {
        driver.findElement(By.id("item_5_img_link"));
        driver.findElement(By.id("item_5_title_link"));
        driver.findElements(By.cssSelector(".btn_primary.btn_inventory")).get(3);
    }

    @Test
    public void Inventory5() {
        driver.findElement(By.id("item_2_img_link"));
        driver.findElement(By.id("item_2_title_link"));
        driver.findElements(By.cssSelector(".btn_primary.btn_inventory")).get(4);
    }

    @Test
    public void Inventory6() {
        driver.findElement(By.id("item_2_img_link"));
        driver.findElement(By.id("item_2_title_link"));
        driver.findElements(By.cssSelector(".btn_primary.btn_inventory")).get(5);
    }

    @Test
    public void AddInventoryToCart() {
        driver.findElements(By.cssSelector(".btn_primary.btn_inventory")).get(3).click();
        driver.findElement(By.id("shopping_cart_container")).click();
        driver.findElement(By.cssSelector(".btn_secondary"));
        driver.findElement(By.cssSelector(".btn_action.checkout_button"));
        driver.findElement(By.id("item_5_title_link")).click();
        driver.findElement(By.xpath("//*[text() = 'REMOVE']"));
        driver.findElement(By.xpath("//*[text()= '<- Back']")).click();
        driver.findElement(By.xpath("//*[text() = 'REMOVE']"));

    }


    @AfterMethod(alwaysRun = true)
    public void close() {
        driver.quit();
    }

}
