package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage {
    protected WebDriver driver;

    public ProductsPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
