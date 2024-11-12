package testcases;

import base.baseTest;
import config.Config;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.CheckoutPage;
import pages.LoginPage;
import utils.Utility;

import java.util.Collections;

public class TC02_Cart extends baseTest {


    @Test(priority = 1)
    public void selectRandomProductInCart() throws Exception {
        driver.get(new Config().getStoreUrl());
        int getRandomValue = Utility.getRandomNumber(1,7);
        new CartPage(driver).addProductInCart(Collections.singletonList(getRandomValue));
        Assert.assertTrue(new CartPage(driver).getCartCount());
        System.out.println(getRandomValue);
    }

    @Test(priority = 2)
    public void verifyTotalPrice() throws Exception {
        int prodCount = 2;
        double expectedPrice = 0.0, actualPrice = 0.0;
        driver.get(new Config().getStoreUrl());
        int getRandomValue = Utility.getRandomNumber(1,7);
        new CartPage(driver).addDynamicProd(prodCount, getRandomValue);
        new CartPage(driver).clickButton();
        new CartPage(driver).isDisplayedElement(prodCount);
        expectedPrice = new CartPage(driver).getTotalPrice(prodCount);
        new CartPage(driver).clickCheckoutButton();
        actualPrice = new CheckoutPage(driver).getTotalPrice();
        Assert.assertEquals(expectedPrice,actualPrice);
    }
}
