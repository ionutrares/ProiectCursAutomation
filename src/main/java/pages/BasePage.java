package pages;

import helpers.ElementMethods;
import helpers.LoggerUtility;
import helpers.WaitMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    public WebDriver driver;
    public LoggerUtility loggerUtility;
    public ElementMethods elementMethods;
    public WaitMethods waitMethods;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        loggerUtility = new LoggerUtility();
        elementMethods = new ElementMethods(this.driver);
        waitMethods = new WaitMethods(this.driver);
        PageFactory.initElements(this.driver, this);
    }
}
