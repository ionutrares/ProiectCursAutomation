package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ProductPage;
import sharedData.Hooks;

public class HomePageTest extends Hooks {

    HomePage homePage;
    ProductPage productPage;

    @Test
    public void signInLinkIsDisplayedTest() {
        homePage = new HomePage(getDriver());
        productPage = new ProductPage(getDriver());
        Assert.assertTrue(homePage.isSignInLinkDisplayed(), "Sign in Link is not displayed!");
    }

    @Test
    public void createAccountLinkIsDisplayedTest() {
        homePage = new HomePage(getDriver());
        Assert.assertTrue(homePage.isCreateAccountLinkDisplayed(), "Sign in Link is not displayed!");
    }
}
