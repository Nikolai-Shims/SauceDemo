package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.*;
import utils.CapabilitiesGenerator;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    public static final String USERNAME = "standard_user";
    public static final String PASSWORD = "secret_sauce";
    WebDriver driver;
    LoginPage loginPage;
    ProductsPage productsPage;
    CartPage cartPage;
    CheckoutPage checkoutPage;
    HeaderPage headerPage;
    ItemPage itemPage;
    OverviewPage overviewPage;

    @BeforeMethod
    public void before(ITestContext context) {
      //System.setProperty("webdriver.chrome.driver", "src/test/resources/webdrivers/chromedriver");
      driver = new ChromeDriver(CapabilitiesGenerator.getChromeOptions());
        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        cartPage = new CartPage(driver);
        checkoutPage = new CheckoutPage(driver);
        headerPage = new HeaderPage(driver);
        itemPage = new ItemPage(driver);
        overviewPage = new OverviewPage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        context.setAttribute("driver",driver);
    }

    @AfterMethod(alwaysRun = true)
    public void after() {
        driver.quit();
    }
}
