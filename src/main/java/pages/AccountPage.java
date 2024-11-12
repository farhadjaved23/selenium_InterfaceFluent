package pages;

import actions.CustomDecorator;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utils.Utility;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class AccountPage {
    WebDriver driver;

    public AccountPage(WebDriver driver){
        this.driver = driver;
    }

    private final By accountLink = By.linkText("Account");
    private final By companyField = By.name("billing_company");
    private final By phoneField = By.name("billing_phone");
    private final By continueBtn = By.xpath("//button[text()='Save address']");
    private final By successMsgText = By.xpath("//div[@class=\"woocommerce-message\"]");

    public void openAccountFromRightClick() throws AWTException {
        Actions actions = new Actions(driver);
        actions.contextClick(driver.findElement(accountLink)).perform();

        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_DOWN);
        robot.keyRelease(KeyEvent.VK_DOWN);

        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }

    public void changeWindows() {

        Set<String> handles = driver.getWindowHandles();
        Set<String> Child_id = driver.getWindowHandles();
        System.out.println(Child_id);
        for (String a : Child_id) {
            driver.switchTo().window(a);
        }
    }

    public String getTitle() throws InterruptedException {
        Thread.sleep(2000);
        String title = driver.getTitle();
        return title;
    }

    public boolean getCountry(){
        HashMap<String, List<String>> countryStatesMap = new HashMap<>();
        List<String> pakistanStates = List.of("Select an option…","Azad Kashmir","Balochistan","FATA","Gilgit Baltistan","Islamabad Capital Territory","Khyber Pakhtunkhwa","Punjab", "Sindh");
        countryStatesMap.put("Pakistan", pakistanStates);

        Select getDD = new Select(driver.findElement(By.xpath("//select[@name=\"billing_state\"]")));
        List<WebElement> countryy = getDD.getOptions();
        List<String> states = new ArrayList<>();

        for (WebElement option : countryy) {
            states.add(option.getText());
        }
            if(states.equals(countryStatesMap.get("Pakistan"))){
                return true;
            }
            else {
                return false;
            }
    }

    public AccountPage updateCompanyInfo(){
        new CustomDecorator(driver,companyField,1000).clear();
        new CustomDecorator(driver,companyField,1000).sendKeys(Utility.companyName());
        return this;
    }

    public AccountPage updatePhoneInfo(){
        new CustomDecorator(driver,phoneField,1000).clear();
        new CustomDecorator(driver,companyField,1000).sendKeys(Utility.phoneNumber());
        return this;
    }

    public AccountPage clickSaveAddress(){
        new CustomDecorator(driver,continueBtn,1000).click();
        return this;
    }

    public String getSuccessMessage(){
      return new CustomDecorator(driver,successMsgText,1000).getText();
    }
}
