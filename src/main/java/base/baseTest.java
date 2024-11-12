package base;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.Browser;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class baseTest {
    public WebDriver driver;
    DesiredCapabilities capabilities = new DesiredCapabilities();

    @BeforeMethod
    @Parameters("Browser")
    public void setUp(String Browser) throws MalformedURLException {

        if(Browser.equals("chrome")) {
            capabilities.setPlatform(Platform.ANY);
            capabilities.setBrowserName("chrome");

            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless=new");
            options.merge(capabilities);
            driver = new RemoteWebDriver(new URL(" http://192.168.0.69:4444"),capabilities);
        }
        else if(Browser.equals("firefox")) {
            capabilities.setPlatform(Platform.ANY);
            capabilities.setBrowserName("firefox");

            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("--headless=new");
            options.merge(capabilities);
            driver = new RemoteWebDriver(new URL(" http://192.168.0.69:4444"),capabilities);
        }
        else if(Browser.equals("MicrosoftEdge")) {
            capabilities.setPlatform(Platform.ANY);
            capabilities.setBrowserName("MicrosoftEdge");

            EdgeOptions options = new EdgeOptions();
            options.addArguments("--headless=new");
            options.merge(capabilities);
            driver = new RemoteWebDriver(new URL(" http://192.168.0.69:4444"),capabilities);
        }
        //System.setProperty("webdriver.chrome.driver", "C:\\Users\\farha\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        //driver = new ChromeDriver();
        //driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // Use seconds, not milliseconds
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        if (driver != null) {
            Thread.sleep(5000);
            driver.quit();
        }
    }
}
