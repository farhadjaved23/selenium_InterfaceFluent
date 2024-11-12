package testcases;

import base.baseTest;
import config.Config;
import net.bytebuddy.implementation.bytecode.Throw;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.LoginPage;

public class TC01_Login extends baseTest {

    String currentTITLE = "Account – AskOmDch";
    String errorMessage = "Account – AskOmDch";

    @Test(dataProvider = "credentialsProvider", dataProviderClass = utils.Utility.class)
    public void loginWithUsernameAndPassword(String username, String password, boolean isValid) throws Exception {
        driver.get(new Config().getAccountUrl());
        new LoginPage(driver).enterUserName(username).enterPassword(password).clickLoginButton();
        if(isValid) {
            SoftAssert sAssert = new SoftAssert();
            sAssert.assertEquals(new LoginPage(driver).GetCurrentTitle(), currentTITLE);
            Assert.assertEquals(new LoginPage(driver).GetCurrentTitle(), currentTITLE);
            sAssert.assertAll();
        }
        else{
            throw new Exception("Password was not right");
        }
    }
}
