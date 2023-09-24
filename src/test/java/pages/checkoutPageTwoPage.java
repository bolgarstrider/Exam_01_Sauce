package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class checkoutPageTwoPage {

    protected WebDriver driver;

    @FindBy(xpath = "//button[@name='finish']")
    private WebElement finishButton;

    public checkoutPageTwoPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //finish the check out and continue to last page
    public checkoutCompletePage FinishShopping() {
        finishButton.click();
        return new checkoutCompletePage(driver);
    }
}
