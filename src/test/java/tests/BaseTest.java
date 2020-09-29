package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.*;
import steps.CartSteps;
import steps.CheckoutSteps;
import steps.LoginSteps;
import utils.CapabilitiesGenerator;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    public static final String USERNAME = "standard_user";
    public static final String PASSWORD = "secret_sauce";
    WebDriver driver;
    ProductsPage productsPage;
    CartPage cartPage;
    CheckoutPage checkoutPage;
    HeaderPage headerPage;
    ItemPage itemPage;
    OverviewPage overviewPage;
    LoginSteps loginSteps;
    CheckoutSteps checkoutSteps;
    CartSteps cartSteps;
    LoginPage loginPage;

    @BeforeMethod
    public void before(ITestContext context) {
     driver = new ChromeDriver(CapabilitiesGenerator.getChromeOptions());
        loginSteps = new LoginSteps(driver);
        productsPage = new ProductsPage(driver);
        cartPage = new CartPage(driver);
        checkoutPage = new CheckoutPage(driver);
        headerPage = new HeaderPage(driver);
        itemPage = new ItemPage(driver);
        loginPage = new LoginPage(driver);
        overviewPage = new OverviewPage(driver);
        checkoutSteps = new CheckoutSteps(driver);
        cartSteps = new CartSteps(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        context.setAttribute("driver",driver);
    }

    @AfterMethod(alwaysRun = true)
    public void after() {
        driver.quit();
    }
}
