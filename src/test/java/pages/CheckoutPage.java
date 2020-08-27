package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CheckoutPage extends BasePage{
    public CheckoutPage(WebDriver driver){
        super(driver);
    }

    public void buttonCheckout(){
        driver.findElement(By.cssSelector(".btn_action.checkout_button")).click();
    }

    public void buttonCancel(){
        driver.findElement(By.cssSelector(".cart_cancel_link.btn_secondary")).click();
    }

    public void buttonContinue(){
        driver.findElement(By.cssSelector(".btn_primary.cart_button")).click();
    }

    public void logInToCheckout(String firstName,String lastName,String zipCode){
        driver.findElement(FIRST_NAME_CHECKOUT).sendKeys(firstName);
        driver.findElement(LAST_NAME_CHECKOUT).sendKeys(lastName);
        driver.findElement(ZIP_CODE_CHECKOUT).sendKeys(zipCode);
    }

    public void errorMessageEmptyField(){
        String errorText =  driver.findElement(By.cssSelector("[data-test=error]")).getText();
        Assert.assertEquals(errorText,"Error: First Name is required");
    }

    public void errorMessageEmptyLastName(){
        String errorText =  driver.findElement(By.cssSelector("[data-test=error]")).getText();
        Assert.assertEquals(errorText,"Error: Last Name is required");
    }

    public void errorMessageEmptyZipCode(){
        String errorText =  driver.findElement(By.cssSelector("[data-test=error]")).getText();
        Assert.assertEquals(errorText,"Error: Postal Code is required");
    }


    public void buttonFinish(){
        driver.findElement(By.cssSelector(".btn_action.cart_button")).click();
    }

    public void finish(){
        String text = driver.findElement(By.cssSelector(".complete-header")).getText();
        Assert.assertEquals(text,"THANK YOU FOR YOUR ORDER");
    }

}
