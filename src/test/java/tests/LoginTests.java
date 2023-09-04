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
public class LoginTests extends TestUtil {



    @DataProvider(name = "csvCredentials")
    public static Object[][] readCredentialsFromCsvFile() throws IOException, CsvException {
        return CSVHelper.readCsvFile("src/test/resources/credentials.csv");
    }

    @DataProvider(name = "csvWrongCredentials")
    public static Object[][] readWrongCredentialsFromCsvFile() throws IOException, CsvException {
        return CSVHelper.readCsvFile("src/test/resources/WrongCredentials.csv");
    }


    @Test(dataProvider = "csvCredentials")
    public void successfulLogin(String username, String password){
        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = loginPage.login(username, password);
        Assert.assertTrue(driver.getCurrentUrl().equals("https://www.saucedemo.com/inventory.html"));
    }

    @Test(dataProvider =  "csvWrongCredentials")
    public void unsuccessfulLogin(String username, String password){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.tryToLogin(username, password);
        Assert.assertTrue(loginPage.isErrorMsgDisplayed());
    }

}
