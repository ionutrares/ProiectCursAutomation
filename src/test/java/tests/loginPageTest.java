package tests;
import helpers.DriverHelper;
import pages.Constants;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductPage;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class loginPageTest {

    @BeforeTest
    public void startTest() {

    }

    @Test
    public void signInWithValidCredentialsTest(){
        DriverHelper.INSTANCE.startFirefoxDriver(Constants.LOGIN_PAGE_URL);
        LoginPage loginPage = new LoginPage();
        loginPage.fillLoginForm(Constants.EMAIL, Constants.PASSWORD);
        loginPage.clickOnSignInButton();
        HomePage homePage = new HomePage();
        Assert.assertTrue(homePage.checkLoginState(), "Customer is not logged in");
    }

    @Test
    public void loggedInUserSuccessfulAddToCartTest(){
        DriverHelper.INSTANCE.startFirefoxDriver(Constants.LOGIN_PAGE_URL);
        LoginPage loginPage = new LoginPage();
        loginPage.fillLoginForm(Constants.EMAIL, Constants.PASSWORD);
        loginPage.clickOnSignInButton();

        HomePage homePage = new HomePage();
        Assert.assertTrue(homePage.checkLoginState(),"Login failed!");

        DriverHelper.INSTANCE.getFirefoxDriver().navigate().to(Constants.PRODUCT_URL);
        ProductPage productPage = new ProductPage();
        Assert.assertTrue(productPage.isProductTitleDisplayed(),"Wrong product page!");
        productPage.chooseSize();
        productPage.chooseColor();
        productPage.setQuantity(2);
        productPage.clickAddToCart();
        Assert.assertTrue(productPage.successfullyAddedToCartMessage(),"Failed add to cart!");
    }

    @Test
    public void add100ItemsToCartAsGuestTest(){
        DriverHelper.INSTANCE.startFirefoxDriver(Constants.PRODUCT_URL);
        ProductPage productPage = new ProductPage();
        Assert.assertTrue(productPage.isProductTitleDisplayed(),"Wrong product page!");
        productPage.chooseSize();
        productPage.chooseColor();
        productPage.setQuantity(100);
        productPage.clickAddToCart();
        Assert.assertTrue(productPage.successfullyAddedToCartMessage(),"Failed add to cart!");
    }
    @AfterTest
    public void tearDown() {
        DriverHelper.INSTANCE.closeFirefoxDriver();
    }
}
