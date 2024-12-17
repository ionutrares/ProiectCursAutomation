package tests;
import pages.HomePage;
import pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import sharedData.Hooks;

public class HomePageTest extends Hooks {

    HomePage homePage;

    @Test
    public void signInLinkIsDisplayedTest(){
        homePage = new HomePage(getDriver());
        Assert.assertTrue(homePage.isSignInLinkDisplayed(),"Sign in Link is not displayed!");
    }

    @Test
    public void createAccountLinkIsDisplayedTest(){
        homePage = new HomePage(getDriver());
        Assert.assertTrue(homePage.isCreateAccountLinkDisplayed(),"Sign in Link is not displayed!");
    }
}
