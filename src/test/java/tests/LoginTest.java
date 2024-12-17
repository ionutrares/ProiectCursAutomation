package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Constants;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductPage;
import sharedData.Hooks;

public class LoginTest extends Hooks {
    HomePage homePage;
    LoginPage loginPage;
    ProductPage productPage;

    @Test
    public void signInPageRedirectTest(){
        homePage = new HomePage(getDriver());
        loginPage = new LoginPage(getDriver());

        homePage.clickOnSignInLink();
        Assert.assertTrue(loginPage.isLoginTitleDisplayed(),"Login Page is not displayed");
    }

    @Test
    public void signInWithValidCredentialsTest() {
        homePage = new HomePage(getDriver());
        loginPage = new LoginPage(getDriver());

        homePage.clickOnSignInLink();
        loginPage.fillLoginForm(Constants.EMAIL, Constants.PASSWORD);
        loginPage.clickOnSignInButton();
        Assert.assertTrue(homePage.checkLoginState(), "Customer is not logged in!");
    }
}
