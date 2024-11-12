package testcases;

import base.baseTest;
import config.Config;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.ProductPage;
import utils.Utility;
import java.util.Collections;

public class TC03_Product extends baseTest {
    @Test(priority = 4, groups = {"compareProduct"})
    public void compareProduct() {
        driver.get(new Config().getStoreUrl());
        new ProductPage(driver).selectDD(5);
        Assert.assertTrue(new ProductPage(driver).compareProductPrice());
    }

    @Test(priority = 3, groups = {"verifyProductText"})
    public void verifyProductText() {
        driver.get(new Config().getMenUrl());
        Assert.assertTrue(new ProductPage(driver).getText());
    }

    @Test(priority = 2, groups = {"selectValueWithoutDD"})
    public void selectValueWithoutDD() throws Exception {
        driver.get(new Config().getStoreUrl());
        new ProductPage(driver).checkDDWithoutSelect();
    }

    @Test(priority = 1, groups = {"selectValueWithDD"})
    public void selectValueWithDD() {
        driver.get(new Config().getStoreUrl());
        new ProductPage(driver).checkDDWithSelect();
    }
}
