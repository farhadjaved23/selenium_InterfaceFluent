package pages;

import actions.CustomDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CheckoutPage {
    WebDriver driver;

    public CheckoutPage(WebDriver driver){ this.driver = driver; }

    private final By totalPriceElement =By.xpath("//*[@id=\"order_review\"]/table/tfoot/tr[1]/td");

    public double getTotalPrice(){
        double totalPrice = 0.0;
        totalPrice = Double.parseDouble(new CustomDecorator(driver, totalPriceElement, 1000).getText()
                .replace("$","").trim());
        return totalPrice;
    }
}
