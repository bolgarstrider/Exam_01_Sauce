package tests;

import base.TestUtil;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductsPage;

public class ShoppingCartTests extends TestUtil {

    @Test
            public void addProductToCartTest() {
        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = loginPage.login("standard_user", "secret_sauce");

        productsPage.addItemToCart("sauce-labs-bike-light");

    }


}
