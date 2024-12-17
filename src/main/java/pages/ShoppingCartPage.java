package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends BasePage{

    @FindBy(css = "a.action:nth-child(3)")
    private WebElement trashButton;

    @FindBy(className = "cart-empty")
    private WebElement emptyCartMessage;

    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }

}
