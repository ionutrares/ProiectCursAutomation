package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Constants;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductPage;
import sharedData.Hooks;

public class AddToCartTest extends Hooks {
    HomePage homePage;
    LoginPage loginPage;
    ProductPage productPage;

    @Test
    public void loggedInUserSuccessfulAddToCartTest() {
        homePage = new HomePage(getDriver());
        loginPage = new LoginPage(getDriver());
        productPage = new ProductPage(getDriver());

        homePage.clickOnSignInLink();
        loginPage.fillLoginForm(Constants.EMAIL, Constants.PASSWORD);
        loginPage.clickOnSignInButton();

        productPage.driver.navigate().to(Constants.PRODUCT_URL);
        Assert.assertTrue(productPage.isProductTitleDisplayed(),"User is not the product page!");

        productPage.chooseSize();
        productPage.chooseColor();
        productPage.setQuantity(2);
        productPage.clickAddToCart();
        Assert.assertTrue(productPage.successfullyAddedToCartMessage(), "Failed add to cart!");
    }

    //    @Test
//    public void add100ItemsToCartAsGuestTest(){
//        DriverHelper.INSTANCE.startFirefoxDriver(Constants.PRODUCT_URL);
//        ProductPage productPage = new ProductPage();
//        Assert.assertTrue(productPage.isProductTitleDisplayed(),"Wrong product page!");
//        productPage.chooseSize();
//        productPage.chooseColor();
//        productPage.setQuantity(100);
//        productPage.clickAddToCart();
//        Assert.assertTrue(productPage.successfullyAddedToCartMessage(),"Failed add to cart!");
//    }

}