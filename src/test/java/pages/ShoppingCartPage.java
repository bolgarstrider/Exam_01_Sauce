package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartPage {
    protected WebDriver driver;


    @FindBy(xpath = "//button[@name='checkout']")
    private WebElement checkOutButton;

    public ShoppingCartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //continue to first step of check out
    public CheckoutStepOnePage checkOut() {
        checkOutButton.click();
        return new CheckoutStepOnePage(driver);
    }


}
