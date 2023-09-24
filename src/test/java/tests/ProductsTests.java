package tests;

import base.TestUtil;
import com.opencsv.exceptions.CsvException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductsPage;
import utils.CSVHelper;

import java.io.IOException;

public class ProductsTests extends TestUtil {

    @DataProvider(name = "productsToAdd")
    public static Object[] readProductsToAdd() throws IOException, CsvException {
        return CSVHelper.readCsvFile("src/test/resources/productsToAdd.csv");
    }

    @DataProvider(name = "productsToRemove")
    public static Object[] readProductsToRemove() throws IOException, CsvException {
        return CSVHelper.readCsvFile("src/test/resources/productsToRemove.csv");
    }

    //log in and add different products from a csv file
    @Test(dataProvider = "productsToAdd")
    public void addProductToCartTest(String itemName, String empty) {
        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = loginPage.login("standard_user", "secret_sauce");

        productsPage.addItemToCart(itemName);

        Assert.assertEquals(productsPage.getNumberOfItemsInTheCart(), 1);

    }

    //log in, add and remove a product from csv file
    @Test(dataProvider = "productsToRemove")
    public void removeProductFromCartTest(String itemName, String empty) {
        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = loginPage.login("standard_user", "secret_sauce");

        productsPage.addItemToCart(itemName);
        productsPage.removeItemFromCart(itemName);

        Assert.assertEquals(productsPage.getNumberOfItemsInTheCart(), 0);

    }

    //log in and add several products provided as parameters
    @Test
    public void addSeveralProducts() {
        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = loginPage.login("standard_user", "secret_sauce");

        productsPage.addItemToCart("sauce-labs-bolt-t-shirt");
        productsPage.addItemToCart("sauce-labs-fleece-jacket");
        productsPage.addItemToCart("test.allthethings()-t-shirt-(red)");

        Assert.assertEquals(productsPage.getNumberOfItemsInTheCart(), 3);
    }


}
