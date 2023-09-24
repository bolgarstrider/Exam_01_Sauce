package tests;

import base.TestUtil;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class CheckoutStepTwoTests extends TestUtil {


    //Successfull scenario - log in, add products, complete the checkout process
    @Test
    public void checkOutStepTwo() {
        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = loginPage.login("standard_user", "secret_sauce");

        productsPage.addItemToCart("sauce-labs-onesie");
        productsPage.addItemToCart("sauce-labs-fleece-jacket");
        ShoppingCartPage shoppingCartPage = productsPage.checkShoppingCart();

        CheckoutStepOnePage checkoutStepOnePage = shoppingCartPage.checkOut();

        checkoutPageTwoPage checkoutPageTwoPage = checkoutStepOnePage.stepOneContinue("John", "Black", "1000");

        checkoutCompletePage checkoutCompletePage = checkoutPageTwoPage.FinishShopping();

        Assert.assertTrue(checkoutCompletePage.isPonyDisplayed());
    }
}
