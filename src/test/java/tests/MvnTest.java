package tests;

import io.qameta.allure.Issue;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestListener.class)
public class MvnTest extends BaseTest{

    @Test
    @Issue("shim_nikolai")
    public void maven() {
        if (System.getProperty("browser") == "chrome") {
            new ChromeDriver();
        } else if (System.getProperty("browser") == "opera") {
            new OperaDriver();
        }
       loginPage.openPage();
       loginPage.login(System.getProperty("user","standard_user"),System.getProperty("password","secret_sauce"));

    }
}
