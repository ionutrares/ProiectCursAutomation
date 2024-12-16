package pages;


import helpers.DriverHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LoginPage {
    private final FirefoxDriver firefoxDriver = DriverHelper.INSTANCE.getFirefoxDriver();
    private final static By loginTitle = By.className("base");

    private final static By emailInputField = By.id("email");

    private final static By passwordField = By.cssSelector("div.field:nth-child(3) > div:nth-child(2) > input:nth-child(1)");

    private final static By signInButton = By.cssSelector("button.login");

    public boolean isLoginTitleDisplayed(){
        WebElement loginTitleElem = firefoxDriver.findElement(loginTitle);
        return loginTitleElem.isDisplayed();
    }

    public void fillLoginForm(String email, String password){
        WebElement emailElem = firefoxDriver.findElement(emailInputField);
        WebElement passwordElem = firefoxDriver.findElement(passwordField);
        emailElem.sendKeys(email);
        passwordElem.sendKeys(password);
    }

    public void clickOnSignInButton(){
        WebElement signInButtonElem = firefoxDriver.findElement(signInButton);
        signInButtonElem.click();
    }

}
