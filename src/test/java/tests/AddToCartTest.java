package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import sharedData.Hooks;

public class AddToCartTest extends Hooks {
    HomePage homePage;
    LoginPage loginPage;
    ProductPage productPage;
    ShoppingCartPage cartPage;

    @Test
    public void guestSuccessfulAddToCartTest() {
        homePage = new HomePage(getDriver());
        loginPage = new LoginPage(getDriver());
        productPage = new ProductPage(getDriver());

        productPage.driver.navigate().to(Constants.PRODUCT_URL);
        Assert.assertTrue(productPage.isProductTitleDisplayed(), "User is not the product page!");
        Assert.assertEquals(productPage.checkSkuNumber(),Constants.PRODUCT_SKU,"This is not the expected product page!");

        productPage.chooseSize();
        productPage.chooseColor();
        productPage.setQuantity(2);
        productPage.clickAddToCart();
        Assert.assertTrue(productPage.successfullyAddedToCartMessage(), "Failed add to cart!");
        Assert.assertFalse(productPage.cartIsEmpty(), "Shopping cart is empty!");
        Assert.assertEquals(2, productPage.getCartQuantity(), "Qty is different than expected!");
    }

    @Test
    public void addOverStockLimitTest() {
        homePage = new HomePage(getDriver());
        loginPage = new LoginPage(getDriver());
        productPage = new ProductPage(getDriver());

        productPage.driver.navigate().to(Constants.PRODUCT_URL);
        Assert.assertTrue(productPage.isProductTitleDisplayed(), "User is not the product page!");
        Assert.assertEquals(productPage.checkSkuNumber(),Constants.PRODUCT_SKU,"This is not the expected product page!");

        productPage.chooseSize();
        productPage.chooseColor();
        productPage.setQuantity(101);
        productPage.clickAddToCart();
        Assert.assertTrue(productPage.failedAddToCartMessage(), "Successful add to cart!");
    }
}