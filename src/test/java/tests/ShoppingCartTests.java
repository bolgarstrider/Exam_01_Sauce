package tests;

import base.TestUtil;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductsPage;
import pages.ShoppingCartPage;

public class ShoppingCartTests extends TestUtil {

    //log in, add products, see shopping cart and start checkout
    @Test
    public void checkOut(){
        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = loginPage.login("standard_user", "secret_sauce");

        productsPage.addItemToCart("sauce-labs-onesie");
        productsPage.addItemToCart("sauce-labs-fleece-jacket");
        ShoppingCartPage shoppingCartPage = productsPage.checkShoppingCart();

        shoppingCartPage.checkOut();

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/checkout-step-one.html");
    }
}
