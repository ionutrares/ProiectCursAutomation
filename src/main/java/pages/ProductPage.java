package pages;


import dev.failsafe.internal.util.Assert;
import helpers.DriverHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;


public class ProductPage {

    private final FirefoxDriver firefoxDriver = DriverHelper.INSTANCE.getFirefoxDriver();

    private final static By sizeList = By.cssSelector(".swatch-option.text");
    private final static By colorList = By.cssSelector(".swatch-option.color");
    private final static By quantityInputField = By.id("qty");
    private final static By addToCartButton = By.id("product-addtocart-button");
    private final static By pageTitle = By.className("base");
    private final static By message = By.cssSelector("div[data-bind*='prepareMessageForHtml']");

    public boolean isProductTitleDisplayed(){
        WebElement menTitleElem = firefoxDriver.findElement(pageTitle);
        return menTitleElem.isDisplayed();
    }

    public void chooseSize(){
        WebDriverWait wait = new WebDriverWait(firefoxDriver, Duration.ofSeconds(10));
        List<WebElement> sizeOptions = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(sizeList));
        for (WebElement size: sizeOptions){
            wait.until(ExpectedConditions.elementToBeClickable(size));
            if (!size.getAttribute("aria-checked").equals("true")){
                size.click();
                break;
            }
        }
    }
    public void chooseColor(){
        List<WebElement> colorOptions = firefoxDriver.findElements(colorList);
        for (WebElement color : colorOptions) {
            if (!color.getAttribute("aria-checked").equals("true")){
                color.click();
                break;
            }
        }
    }

    public void setQuantity(Integer value){
        WebElement qtyElem = firefoxDriver.findElement(quantityInputField);
        qtyElem.clear();
        qtyElem.sendKeys(value.toString());
    }
    public void clickAddToCart(){
        WebDriverWait wait = new WebDriverWait(firefoxDriver, Duration.ofSeconds(10));
        WebElement addToCartElem = wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));
        addToCartElem.click();
    }

    public boolean successfullyAddedToCartMessage(){
        WebDriverWait wait = new WebDriverWait(firefoxDriver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(message, "You added"));

        WebElement messageElem = firefoxDriver.findElement(message);
        String displayedText = Constants.SUCCESSFULL_ADD_TO_CART_MESSAGE;
        String actualText = messageElem.getText();
        return actualText.equals(displayedText);
    }
}
