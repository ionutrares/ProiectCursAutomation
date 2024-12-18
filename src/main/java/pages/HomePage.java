package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(css = "ul.header:nth-child(3) > li:nth-child(2) > a:nth-child(1)")
    private WebElement signInLink;
    @FindBy(id = "idDSGazqV0")
    private WebElement createAccountLink;
    @FindBy(css = "ul.header:nth-child(3) > li:nth-child(1) > span:nth-child(1)")
    private WebElement loggedInName;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public boolean isSignInLinkDisplayed() {
        return elementMethods.isDisplayedElement(signInLink);
    }

    public boolean isCreateAccountLinkDisplayed() {
        return elementMethods.isDisplayedElement(createAccountLink);
    }

    public void clickOnSignInLink() {
        elementMethods.clickElement(signInLink);
    }

    public void clickOnCreateAccountLink() {
        elementMethods.clickElement(createAccountLink);
    }

    public boolean checkLoginState() {
        String welcomeText = Constants.WELCOME_MESSAGE;
        waitMethods.waitVisibleText(loggedInName, welcomeText);
        String actualText = elementMethods.getTextElement(loggedInName);
        waitMethods.waitVisibleText(loggedInName, welcomeText);
        return actualText.equals(welcomeText);
    }
}
