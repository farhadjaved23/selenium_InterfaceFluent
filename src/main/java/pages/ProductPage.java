package pages;

import net.bytebuddy.implementation.bytecode.Throw;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class ProductPage {

    WebDriver driver;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By ddVisible = By.className("orderby");
    private final By productName = By.xpath("//p[contains(text(), 'Showing')]");

    public ProductPage selectDD(int ddSelection) {

        Select getDD = new Select(driver.findElement(ddVisible));
        getDD.selectByIndex(ddSelection);
        return this;
    }

    public boolean compareProductPrice() {

        double[] arr = new double[3];
        for (int i = 0; i < arr.length; i++) {
            String fText = "(//ul[@class=\"products columns-4\"]//li//span[@class=\"price\"])[" + (i + 1) + "]";
            double firstProdPrice = Double.parseDouble(driver.findElement(By.xpath(fText)).getText().replace("$", "").trim());
            arr[i] = firstProdPrice;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] >= arr[i + 1]) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    public boolean getText(){
        String text = driver.findElement(productName).getText().substring(12,13);
        List<WebElement> prodCard = driver.findElements(By.xpath("//div[@class=\"ast-woocommerce-container\"]//ul//li"));
        prodCard.size();
        if(!text.isEmpty()){
            if(text.equals(String.valueOf(prodCard.size()))){
                return true;
            }
        }
        else{
            return false;
        }
        return false;
    }

    public void checkDDWithSelect(){
        Select CategoryDD = new Select(driver.findElement(By.className("dropdown_product_cat")));
        CategoryDD.selectByIndex(2);
    }

    public void checkDDWithoutSelect() throws InterruptedException {
        List<WebElement> dd = driver.findElements(By.xpath("//select[@name=\"product_cat\"]//option"));
        System.out.println(dd.size());
        for(int i=0; i<dd.size(); i++){
            if(dd.get(i).getText().contains("Men")) {
                dd.get(2).click();
                break;
            }
        }
    }
}
