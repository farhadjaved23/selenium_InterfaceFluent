package testcases;

import base.baseTest;
import config.Config;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AccountPage;
import pages.LoginPage;
import pages.ProductPage;

public class TC04_Account extends baseTest {

    private static String title = "Account – AskOmDch";
    private static String successMsgText = "Address changed successfully.";
    String username = "askqa@mailinator.com ";
    String password = "askqa123";

    @Test(priority = 3)
    public void getSecondWindowTitle() throws Exception {
        driver.get(new Config().getBaseUrl());
        new AccountPage(driver).openAccountFromRightClick();
        new AccountPage(driver).changeWindows();
        System.out.println(driver.getTitle()                    );
        Assert.assertEquals(new AccountPage(driver).getTitle(), title);
    }

    @Test(priority = 1)
    public void verifyCountryThroughHashMap() throws Exception {
        driver.get(new Config().getBillingUrl());
        new LoginPage(driver).enterUserName(username).enterPassword(password).clickLoginButton();
        Assert.assertTrue(new AccountPage(driver).getCountry());
    }

    @Test(priority = 3)
    public void updateUserInfo() throws Exception {
        driver.get(new Config().getBillingUrl());
        new LoginPage(driver).enterUserName(username).enterPassword(password).clickLoginButton();
        new AccountPage(driver).updateCompanyInfo().updatePhoneInfo().clickSaveAddress();
        Assert.assertEquals(new AccountPage(driver).getSuccessMessage(),successMsgText);
    }
}
