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

    @FindBy(css = "div[data-bind*='prepareMessageForHtml']")
    private WebElement addToCartMessage;

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

    public void clickAddToCart() {
        elementMethods.clickElement(addToCartButton);
    }

    public boolean successfullyAddedToCartMessage(){
        String displayedText = Constants.SUCCESSFULL_ADD_TO_CART_MESSAGE;
        waitMethods.waitVisibleText(addToCartMessage, displayedText);
        String actualText = elementMethods.getTextElement(addToCartMessage);
        waitMethods.waitVisibleText(addToCartMessage, displayedText);
        return actualText.equals(displayedText);
    }
}
