package tests;
import helpers.DriverHelper;
import pages.Constants;
import pages.HomePage;
import pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class homePageTest {

    @BeforeTest
    public void startTest() {

    }

    @Test
    public void signInLinkIsDisplayedTest(){
        DriverHelper.INSTANCE.startFirefoxDriver(Constants.HOME_PAGE_URL);
        HomePage homePage = new HomePage();
        Assert.assertTrue(homePage.isSignInLinkDisplayed(), "The Sign In Link is not displayed");
    }
    @Test
    public void createAccountLinkIsDisplayedTest(){
        DriverHelper.INSTANCE.startFirefoxDriver(Constants.HOME_PAGE_URL);
        HomePage homePage = new HomePage();
        Assert.assertTrue(homePage.isCreateAccountLinkDisplayed(), "The Create Account Link is not displayed");
    }
    @Test
    public void signInPageRedirectTest(){
        DriverHelper.INSTANCE.startFirefoxDriver(Constants.HOME_PAGE_URL);
        HomePage homePage = new HomePage();
        homePage.clickOnSignInLink();
        LoginPage loginPage = new LoginPage();
        Assert.assertTrue(loginPage.isLoginTitleDisplayed(), "Login Page is not displayed");
    }

    @AfterTest
    public void tearDown() {
        DriverHelper.INSTANCE.closeFirefoxDriver();
    }
}
