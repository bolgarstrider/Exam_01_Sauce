package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage {
    protected WebDriver driver;

    private static final String ADD_TO_CART = "//button[@id='add-to-cart-%s']";
    private static final String REMOVE_FROM_CART = "//button[@id='remove-%s']";

   @FindBy(xpath = "//span[@class='shopping_cart_badge']")
    private WebElement shoppingCartBadge;


    public ProductsPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void addItemToCart (String itemName){
        String itemXpath = String.format(ADD_TO_CART, itemName);
        WebElement addToCartButton = driver.findElement(By.xpath(itemXpath));
        addToCartButton.click();
    }

    public void removeItemFromCart (String itemName){
        String itemXpath = String.format(REMOVE_FROM_CART, itemName);
        WebElement removeFromCartButton = driver.findElement(By.xpath(itemXpath));
        if (removeFromCartButton.isDisplayed()) {
            removeFromCartButton.click();
        } else {
            throw new NoSuchElementException("No such element");
        }
    }

    public int getNumberOfItemsInTheCart() {
        return Integer.parseInt(shoppingCartBadge.getText());
    }

}
