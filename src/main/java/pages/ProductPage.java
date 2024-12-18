package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductPage extends BasePage {

    @FindBy(css = ".swatch-option.text")
    private List<WebElement> sizeList;

    @FindBy(css = ".swatch-option.color")
    private List<WebElement> colorList;

    @FindBy(id = "qty")
    private WebElement quantityInputField;

    @FindBy(id = "product-addtocart-button")
    private WebElement addToCartButton;

    @FindBy(className = "base")
    private WebElement pageTitle;

    @FindBy(css = ".message-success > div:nth-child(1)")
    private WebElement successAddMessage;

    @FindBy(css = ".message-error > div:nth-child(1)")
    private WebElement errorAddMessage;

    @FindBy(className = "counter-number")
    private WebElement cartCounter;

    @FindBy(css = "div.value:nth-child(2)")
    private WebElement sku;


    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public boolean isProductTitleDisplayed() {
        String actualText = elementMethods.getTextElement(pageTitle);
        waitMethods.waitVisibleElement(pageTitle);
        return actualText.equals(Constants.PRODUCT_NAME);
    }

    public void chooseSize() {
        elementMethods.clickElementFromList(sizeList);
    }

    public void chooseColor() {
        elementMethods.clickElementFromList(colorList);
    }

    public void setQuantity(Integer value) {
        elementMethods.clearInputElement(quantityInputField, value);

    }

    public String checkSkuNumber(){
        waitMethods.waitVisibleElement(sku);
        return elementMethods.getTextElement(sku);
    }

    public void clickAddToCart() {
        elementMethods.clickElement(addToCartButton);
    }

    public boolean successfullyAddedToCartMessage(){
        String displayedText = Constants.SUCCESSFUL_ADD_TO_CART_MESSAGE;
        waitMethods.waitVisibleText(successAddMessage, displayedText);
        String actualText = elementMethods.getTextElement(successAddMessage);
        waitMethods.waitVisibleText(successAddMessage, displayedText);
        return actualText.equals(displayedText);
    }

    public boolean failedAddToCartMessage(){
        String displayedText = Constants.FAILED_ADD_TO_CART_MESSAGE;
        waitMethods.waitVisibleText(errorAddMessage, displayedText);
        String actualText = elementMethods.getTextElement(errorAddMessage);
        waitMethods.waitVisibleText(errorAddMessage, displayedText);
        return actualText.equals(displayedText);
    }

    public int getCartQuantity(){
       return elementMethods.getIntElement(cartCounter);
    }

    public boolean cartIsEmpty(){
        int cartQty = elementMethods.getIntElement(cartCounter);
        return cartQty == 0;
    }
}
