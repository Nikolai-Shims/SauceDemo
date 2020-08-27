package tests;

import org.testng.annotations.Test;

public class CheckoutTest extends BaseTest{

    @Test
    public void checkoutButton(){
        loginPage.login(USERNAME,PASSWORD);
        cartPage.openCart();
        checkoutPage.buttonCheckout();
    }

    @Test
    public void cancelButton(){
        loginPage.login(USERNAME,PASSWORD);
        cartPage.openCart();
        checkoutPage.buttonCheckout();
        checkoutPage.buttonCancel();
    }

    @Test
    public void buttonContinue(){
        loginPage.login(USERNAME,PASSWORD);
        cartPage.openCart();
        checkoutPage.buttonCheckout();
        checkoutPage.buttonContinue();
    }

    @Test
    public void logInToCheckout(){
        loginPage.login(USERNAME,PASSWORD);
        cartPage.openCart();
        checkoutPage.buttonCheckout();
        checkoutPage.logInToCheckout("kolia","shims","1234");
        checkoutPage.buttonContinue();
    }

    @Test
    public void getErrorWithEmptyField(){
        loginPage.login(USERNAME,PASSWORD);
        cartPage.openCart();
        checkoutPage.buttonCheckout();
        checkoutPage.logInToCheckout("","","");
        checkoutPage.buttonContinue();
        checkoutPage.errorMessageEmptyField();
    }
    @Test
    public void getErrorWithEmptyFirstName(){
        loginPage.login(USERNAME,PASSWORD);
        cartPage.openCart();
        checkoutPage.buttonCheckout();
        checkoutPage.logInToCheckout("",LAST_NAME,ZIP_CODE);
        checkoutPage.buttonContinue();
        checkoutPage.errorMessageEmptyField();
    }

    @Test
    public void getErrorWithEmptyLastName(){
        loginPage.login(USERNAME,PASSWORD);
        cartPage.openCart();
        checkoutPage.buttonCheckout();
        checkoutPage.logInToCheckout(FIRST_NAME,"",ZIP_CODE);
        checkoutPage.buttonContinue();
        checkoutPage.errorMessageEmptyLastName();
    }

    @Test
    public void getErrorWithEmptyZipCode(){
        loginPage.login(USERNAME,PASSWORD);
        cartPage.openCart();
        checkoutPage.buttonCheckout();
        checkoutPage.logInToCheckout(FIRST_NAME,LAST_NAME,"");
        checkoutPage.buttonContinue();
        checkoutPage.errorMessageEmptyZipCode();
    }


    @Test
    public void completeOrder(){
        loginPage.login(USERNAME,PASSWORD);
        productsPage.buttonAddToCart("Sauce Labs Bike Light");
        productsPage.buttonAddToCart("Sauce Labs Bolt T-Shirt");
        cartPage.openCart();
        cartPage.getCountItemInToCart();
        checkoutPage.buttonCheckout();
        checkoutPage.logInToCheckout(FIRST_NAME,LAST_NAME,ZIP_CODE);
        checkoutPage.buttonContinue();
        checkoutPage.buttonFinish();
        checkoutPage.finish();

    }

}
