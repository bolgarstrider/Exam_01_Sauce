package pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class checkoutCompletePage {

    protected WebDriver driver;

    @FindBy(xpath = "//img[@class='pony_express']")
    private WebElement ponyExpress;

    public checkoutCompletePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

//check if the image for successful order is displayed
    public boolean isPonyDisplayed() {
        try {
            ponyExpress.isDisplayed();
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
