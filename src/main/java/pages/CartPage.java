package pages;

import actions.CustomDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Utility;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class CartPage {
    WebDriver driver;

    public CartPage(WebDriver driver){ this.driver = driver; }

    private final By itemsVisible =By.xpath("//*[@id=\"main\"]/div");
    private final By cartText =By.xpath("(//span[@class=\"count\"])[1]");
    private final By viewCartLink = By.linkText("View cart");
    private final By productCount = By.xpath("//table[@class=\"shop_table shop_table_responsive cart woocommerce-cart-form__contents\"]//tbody//following-sibling::tr[@class=\"woocommerce-cart-form__cart-item cart_item\"]");
    private final By checkoutBtn = By.xpath("//*[@id=\"post-1220\"]/div/div/div/div/div[2]/div/div/a");

    public CartPage addProductInCart(List<Integer> productNum){

        for(int prodNum: productNum) {
            String RandomProduct = "(//*[@id=\"main\"]/div//div[@class=\"star-rating\"]//following-sibling::a)["+prodNum+"]";
            driver.findElement(By.xpath(RandomProduct)).click();
            driver.findElement(By.xpath("(//ul[@class=\"products columns-4\"]//li)["+RandomProduct+"]")).click();
        }
        return this;
    }

    public boolean getCartCount() throws InterruptedException {
        int cartValue = 0;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(cartText));
        Thread.sleep(2000);
        cartValue = Integer.parseInt(new CustomDecorator(driver,cartText,10000).getText());
        if(cartValue > 0){
            return true;
        }
        else {
            return false;
        }
    }

    public CartPage addDynamicProd(int count, int randValue){
        for (int i=0; i<count; i++){
            String RandomProduct = "(//*[@id=\"main\"]/div//div[@class=\"star-rating\"]//following-sibling::a)["+randValue+"]";
            driver.findElement(By.xpath(RandomProduct)).click();
            randValue++;
        }
        return this;
    }

    public CartPage clickButton(){
        new CustomDecorator(driver,viewCartLink,1000).click();
        return this;
    }

    public CartPage isDisplayedElement(int count){
        for (int i=1; i<= count; i++) {
            driver.findElement(By.xpath("(//table[@class=\"shop_table shop_table_responsive cart woocommerce-cart-form__contents\"]//tbody//following-sibling::tr[@class=\"woocommerce-cart-form__cart-item cart_item\"])[" + i + "]")).isDisplayed();
            return this;
        }
        return null;
    }

    public double getTotalPrice(int count) {
        double totalSum = 0;

        for (int i = 1; i <= count; i++) {
            String priceText = new CustomDecorator(driver,
                    By.xpath("(//table[@class=\"shop_table shop_table_responsive cart woocommerce-cart-form__contents\"]//tbody//following-sibling::tr[@class=\"woocommerce-cart-form__cart-item cart_item\"]//td[@class=\"product-subtotal\"])[" + i + "]"),
                    1000).getText().replace("$", "").trim();

                double totalPrice = Double.parseDouble(priceText);
                totalSum += totalPrice;
        }
        return totalSum;
    }

    public CartPage clickCheckoutButton(){
        new CustomDecorator(driver,checkoutBtn,1000).click();
        return this;
    }
}
