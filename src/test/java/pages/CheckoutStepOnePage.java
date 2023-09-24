package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutStepOnePage {
    protected WebDriver driver;

    @FindBy(xpath = "//input[@name='firstName']")
    private WebElement firstName;

    @FindBy(xpath = "//input[@name='lastName']")
    private WebElement lastName;

    @FindBy(xpath = "//input[@name='postalCode']")
    private WebElement postalCode;
    @FindBy(xpath = "//input[@name='continue']")
    private WebElement continueButton;

    public CheckoutStepOnePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

public CheckoutPageTwoPage StepOneContinue(String fName, String lName, String pCode) {
        firstName.click();
        firstName.clear();
        firstName.sendKeys(fName);
        lastName.click();
        lastName.clear();
        lastName.sendKeys(lName);
        postalCode.click();
        postalCode.clear();
        postalCode.sendKeys(pCode);

        continueButton.click();

        return new CheckoutPageTwoPage(driver);
}


}
