package helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class WaitMethods {

    public WebDriver driver;
    public WaitMethods(WebDriver driver) {
        this.driver = driver;
    }

    public void waitVisibleElement(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitVisibleList(List<WebElement> list) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        for (WebElement element : list) {
            wait.until(ExpectedConditions.visibilityOf(element));
        }
    }

    public void waitUntilClickable(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitVisibleText(WebElement element, String value) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.textToBePresentInElement(element, value));
    }
}
