package helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ElementMethods {

    public WebDriver driver;
    public WaitMethods waitMethods;

    public ElementMethods(WebDriver driver) {
        this.driver = driver;
        this.waitMethods = new WaitMethods(driver);
    }

    public void clickElement(WebElement element) {
        waitMethods.waitVisibleElement(element);
        element.click();
    }

    public boolean isDisplayedElement(WebElement element) {
        waitMethods.waitVisibleElement(element);
        return element.isDisplayed();
    }

    public void fillElement(WebElement element, String value) {
        waitMethods.waitVisibleElement(element);
        element.sendKeys(value);
    }

    public void clickElementFromList(List<WebElement> list) {
        waitMethods.waitVisibleList(list);
        List<WebElement> sizeOptions = new ArrayList<>(list);
        for (WebElement element : sizeOptions) {
            waitMethods.waitUntilClickable(element);
            if (!element.getAttribute("aria-checked").equals("true")) {
                element.click();
                break;
            }
        }
    }

//    public void selectDropdownElement(WebElement element, String text) {
//        waitVisibleElement(element);
//        Select select = new Select(element);
//        select.selectByVisibleText(text);
//    }

    public void clearInputElement(WebElement element, Integer value) {
        waitMethods.waitVisibleElement(element);
        element.clear();
        element.sendKeys(value.toString());
    }

    public String getTextElement(WebElement element) {
        return element.getText();
    }
}