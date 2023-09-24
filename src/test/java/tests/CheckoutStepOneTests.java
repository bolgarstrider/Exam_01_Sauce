package tests;

import base.TestUtil;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CheckoutStepOnePage;
import pages.LoginPage;
import pages.ProductsPage;
import pages.ShoppingCartPage;

public class CheckoutStepOneTests extends TestUtil {


   @Test
   public void checkOut() {
      LoginPage loginPage = new LoginPage(driver);
      ProductsPage productsPage = loginPage.login("standard_user", "secret_sauce");

      productsPage.addItemToCart("sauce-labs-onesie");
      productsPage.addItemToCart("sauce-labs-fleece-jacket");
      ShoppingCartPage shoppingCartPage = productsPage.checkShoppingCart();

      CheckoutStepOnePage checkoutStepOnePage = shoppingCartPage.checkOut();

      checkoutStepOnePage.StepOneContinue("John", "Black", "1000");

      Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/checkout-step-two.html");


   }
}
