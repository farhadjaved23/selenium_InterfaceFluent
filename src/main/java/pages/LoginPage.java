package pages;

import actions.CustomDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    private final By USERNAME_TEXT= By.xpath("//*[@id=\"username\"]");
    private final By PASSWORD_TEXT= By.xpath("//*[@id=\"password\"]");
    private final By LOGIN_BUTTON= By.xpath("//*[@id=\"customer_login\"]/div[1]/form/p[3]/button");

    public LoginPage enterUserName(String username){

        new CustomDecorator(driver,USERNAME_TEXT,0).sendKeys(username);
        return this;
    }
    public LoginPage enterPassword(String password){
        new CustomDecorator(driver,PASSWORD_TEXT,1000).sendKeys(password);

        return this;
    }
    public LoginPage clickLoginButton(){
        new CustomDecorator(driver,LOGIN_BUTTON,4000).click();

        return this;
    }

    public String GetCurrentTitle() { return driver.getTitle();}
}
