package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(className = "base")
    private WebElement loginTitle;

    @FindBy(id = "email")
    private WebElement emailInputField;

    @FindBy(css = "div.field:nth-child(3) > div:nth-child(2) > input:nth-child(1)")
    private WebElement passwordField;

    @FindBy(css = "button.login")
    private WebElement signInButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public boolean isLoginTitleDisplayed() {
        return elementMethods.isDisplayedElement(loginTitle);
    }

    public void fillLoginForm(String email, String password) {
        elementMethods.fillElement(emailInputField, email);
        elementMethods.fillElement(passwordField, password);
    }

    public void clickOnSignInButton() {
        elementMethods.clickElement(signInButton);
    }

}