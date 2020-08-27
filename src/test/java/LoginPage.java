import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginPage {
    WebDriver driver;

    @BeforeMethod
    public void start(){
        System.setProperty("webdriver.chrome.driver", "src//test//resources//chromedriver");
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/index.html");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void LoginUserName(){
        driver.findElement(By.id("user-name"));
    }

    @Test
    public void LoginPassword(){
        driver.findElement(By.id("password"));
    }

    @Test
    public void LoginButton(){
        driver.findElement(By.id("login-button"));
    }

    @Test
    public void LoginImage(){
        driver.findElement(By.cssSelector("img[src='img/Login_Bot_graphic.png']"));
    }

    @Test
    public void LoginLogo(){
        driver.findElement(By.cssSelector(".login_logo"));
    }

    @Test
    public void LoginErrorButton(){
        driver.findElement(By.id("user-name")).sendKeys("Nikolay91");
        driver.findElement(By.id("password")).sendKeys("1234qwer");
        driver.findElement(By.id("login-button")).click();
        driver.findElement(By.cssSelector(".error-button"));
    }

    @AfterMethod(alwaysRun = true)
    public void close(){
        driver.quit();
    }
}
