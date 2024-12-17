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
//        DriverHelper.INSTANCE.startFirefoxDriver(Constants.HOME_PAGE_URL);
//        HomePage homePage = new HomePage();
//        Assert.assertTrue(homePage.isCreateAccountLinkDisplayed(), "The Create Account Link is not displayed");
    }

}
