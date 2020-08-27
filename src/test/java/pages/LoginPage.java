package pages;

import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{

    public LoginPage(WebDriver driver){
        super(driver);
    }


    public void openPage(){
        driver.get("https://www.saucedemo.com/");
    }


    public void login(String username, String password){
        driver.findElement(USERNAME_INPUT).sendKeys(username);
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();
    }


    public String getErrorMessage(){
        return driver.findElement(ERROR_BUTTON).getText();
    }
}

