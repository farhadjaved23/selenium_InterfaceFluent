package utils;

import com.github.javafaker.Faker;
import jdk.jshell.execution.Util;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;

public class Utility {

    WebDriver driver;
    private static Faker faker = new Faker();

    @DataProvider(name = "credentialsProvider")
    public static Object[][] getCredentials() {
        return new Object[][] {
                { "askqa@mailinator.com", "askqa123", true },
                { "invalid@mailinator.com", "Invalid123", false }
        };
    }

    public static int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    public static String companyName(){ return faker.company().name(); }

    public static String phoneNumber(){ return faker.number().digits(9); }
}
