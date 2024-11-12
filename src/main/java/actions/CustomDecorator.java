package actions;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CustomDecorator implements WebElement {
    private By element;
    private WebDriver driver;
    private int waitTime;

    public CustomDecorator(WebDriver driver, By element, int waitTime) {
        this.driver = driver;
        this.element = element;
        this.waitTime = waitTime;
    }

    private WebElement waitForElement() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    @Override
    public void click() {
        System.out.println("Clicking on element: " + element.toString());
        WebElement el = waitForElement();
        el.click();
    }

    @Override
    public void submit() {
        System.out.println("Submitting element: " + element.toString());
        WebElement el = waitForElement();
        el.submit();
    }

    @Override
    public void sendKeys(CharSequence... keysToSend) {
        System.out.println("Typing: " + keysToSend.toString() + " on element: " + element.toString());
        WebElement el = waitForElement();
        el.sendKeys(keysToSend);
    }

    @Override
    public void clear() {
        System.out.println("Clearing element: " + element.toString());
        WebElement el = waitForElement();
        el.clear();
    }

    @Override
    public String getTagName() {
        System.out.println("Getting tag name of element: " + element.toString());
        WebElement el = waitForElement();
        return el.getTagName();
    }

    @Override
    public @Nullable String getDomProperty(String name) {
        System.out.println("Getting DOM property '" + name + "' for element: " + element.toString());
        WebElement el = waitForElement();
        return el.getDomProperty(name);
    }

    @Override
    public @Nullable String getDomAttribute(String name) {
        System.out.println("Getting DOM attribute '" + name + "' for element: " + element.toString());
        WebElement el = waitForElement();
        return el.getDomAttribute(name);
    }

    @Override
    public @Nullable String getAttribute(String name) {
        System.out.println("Getting attribute '" + name + "' for element: " + element.toString());
        WebElement el = waitForElement();
        return el.getAttribute(name);
    }

    @Override
    public @Nullable String getAriaRole() {
        System.out.println("Getting ARIA role for element: " + element.toString());
        WebElement el = waitForElement();
        return el.getAriaRole();
    }

    @Override
    public @Nullable String getAccessibleName() {
        System.out.println("Getting accessible name for element: " + element.toString());
        WebElement el = waitForElement();
        return el.getAccessibleName();
    }

    @Override
    public boolean isSelected() {
        System.out.println("Checking if element is selected: " + element.toString());
        WebElement el = waitForElement();
        return el.isSelected();
    }

    @Override
    public boolean isEnabled() {
        System.out.println("Checking if element is enabled: " + element.toString());
        WebElement el = waitForElement();
        return el.isEnabled();
    }

    @Override
    public String getText() {
        System.out.println("Getting text from element: " + element.toString());
        WebElement el = waitForElement();
        return el.getText();
    }

    @Override
    public List<WebElement> findElements(By by) {
        System.out.println("Finding elements by: " + by.toString());
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
    }

    @Override
    public WebElement findElement(By by) {
        System.out.println("Finding element by: " + by.toString());
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    @Override
    public SearchContext getShadowRoot() {
        System.out.println("Getting shadow root for element: " + element.toString());
        WebElement el = waitForElement();
        return el.getShadowRoot();
    }

    @Override
    public boolean isDisplayed() {
        System.out.println("Checking if element is displayed: " + element.toString());
        WebElement el = waitForElement();
        return el.isDisplayed();
    }

    @Override
    public Point getLocation() {
        System.out.println("Getting location of element: " + element.toString());
        WebElement el = waitForElement();
        return el.getLocation();
    }

    @Override
    public Dimension getSize() {
        System.out.println("Getting size of element: " + element.toString());
        WebElement el = waitForElement();
        return el.getSize();
    }

    @Override
    public Rectangle getRect() {
        System.out.println("Getting rectangle of element: " + element.toString());
        WebElement el = waitForElement();
        return el.getRect();
    }

    @Override
    public String getCssValue(String propertyName) {
        System.out.println("Getting CSS value of property '" + propertyName + "' for element: " + element.toString());
        WebElement el = waitForElement();
        return el.getCssValue(propertyName);
    }

    @Override
    public <X> X getScreenshotAs(OutputType<X> target) throws WebDriverException {
        System.out.println("Taking screenshot for element: " + element.toString());
        WebElement el = waitForElement();
        return el.getScreenshotAs(target);
    }
}
