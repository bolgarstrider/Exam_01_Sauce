package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPageTwoPage {

    protected WebDriver driver;

    @FindBy(xpath = "//button[@name='finish']")
    private WebElement finishButton;

    public CheckoutPageTwoPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public CheckoutCompletePage FinishShopping() {
        finishButton.click();
        return new CheckoutCompletePage(driver);
    }
}
