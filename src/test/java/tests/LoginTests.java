package tests;
import base.TestUtil;
import com.opencsv.exceptions.CsvException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductsPage;
import utils.CSVHelper;
import java.io.IOException;
import java.time.Duration;
import java.util.Collections;
import java.util.NoSuchElementException;

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

        String currentUrl = driver.getCurrentUrl();

        FluentWait fluentWait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(5))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoreAll(Collections.singleton(NoSuchElementException.class));

        fluentWait.until(ExpectedConditions.urlToBe(currentUrl));

        Assert.assertTrue(currentUrl.equals("https://www.saucedemo.com/inventory.html"));
    }

    @Test(dataProvider =  "csvWrongCredentials")
    public void unsuccessfulLogin(String username, String password){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.tryToLogin(username, password);

        Assert.assertTrue(loginPage.isErrorMsgDisplayed());
    }

}
