package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

public class baseTest {
    public WebDriver driver;

    @BeforeMethod
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\farha\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // Use seconds, not milliseconds
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        if (driver != null) {
            Thread.sleep(5000);
            driver.quit();
        }
    }
}
