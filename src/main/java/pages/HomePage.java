package pages;


import helpers.DriverHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.lang.model.element.Name;
import java.time.Duration;

public class HomePage {

    private final FirefoxDriver firefoxDriver = DriverHelper.INSTANCE.getFirefoxDriver();
    private final static By signInLink = By.cssSelector("ul.header:nth-child(3) > li:nth-child(2) > a:nth-child(1)");
    private final static By createAccountLink = By.id("idn8DArlnr");
    private final static By loggedInName = By.cssSelector("ul.header:nth-child(3) > li:nth-child(1) > span:nth-child(1)");

    public boolean isSignInLinkDisplayed(){
        WebElement signInLinkElem = firefoxDriver.findElement(signInLink);
        return signInLinkElem.isDisplayed();
    }
    public boolean isCreateAccountLinkDisplayed() {
        WebElement createAccountLinkElem = firefoxDriver.findElement(createAccountLink);
        return createAccountLinkElem.isDisplayed();
    }

    public void clickOnSignInLink(){
        WebElement signInLinkElem = firefoxDriver.findElement(signInLink);
        signInLinkElem.click();
    }

    public void clickOnCreateAccountLink(){
        WebElement createAccountLinkElem = firefoxDriver.findElement(createAccountLink);
        createAccountLinkElem.click();
    }

    public boolean checkLoginState(){
        WebDriverWait wait = new WebDriverWait(firefoxDriver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(loggedInName, "Welcome,"));

        WebElement loggedInElem = firefoxDriver.findElement(loggedInName);
        String welcomeText = "Welcome, Veronica Costello!";
        String actualText = loggedInElem.getText();
        return actualText.equals(welcomeText);
    }


}
