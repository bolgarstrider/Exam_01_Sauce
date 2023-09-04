package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    protected WebDriver driver;

    @FindBy(xpath = "//input[@placeholder='Username']")
    private WebElement userNameInput;

    @FindBy(xpath = "//input[@placeholder='Password']")
    private WebElement passwordInput;

    @FindBy(xpath = "//input[@value='Login']")
    private WebElement loginButton;

    @FindBy(xpath = "//button[@class='error-button']")
    private WebElement errorMsg;

    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void tryToLogin(String username, String password) {
        userNameInput.click();
        userNameInput.clear();
        userNameInput.sendKeys(username);
        passwordInput.click();
        passwordInput.clear();
        passwordInput.sendKeys(password);
        loginButton.click();
    }

    public ProductsPage login(String username, String password) {
        tryToLogin(username, password);
        return new ProductsPage(driver);
    }

    public boolean isErrorMsgDisplayed(){
        if (errorMsg.isDisplayed()) {
            return true;
        } else {
            return false;
        }
    }




}
