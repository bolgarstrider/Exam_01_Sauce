package tests;

import base.TestUtil;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class CheckoutStepTwoTests extends TestUtil {

    @Test
    public void checkOutStepTwo() {
        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = loginPage.login("standard_user", "secret_sauce");

        productsPage.addItemToCart("sauce-labs-onesie");
        productsPage.addItemToCart("sauce-labs-fleece-jacket");
        ShoppingCartPage shoppingCartPage = productsPage.checkShoppingCart();

        CheckoutStepOnePage checkoutStepOnePage = shoppingCartPage.checkOut();

        CheckoutPageTwoPage checkoutPageTwoPage = checkoutStepOnePage.StepOneContinue("John", "Black", "1000");

        CheckoutCompletePage checkoutCompletePage = checkoutPageTwoPage.FinishShopping();

        Assert.assertTrue(checkoutCompletePage.isPonyDisplayed());
    }
}
