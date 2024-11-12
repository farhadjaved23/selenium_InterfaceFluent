package config;

import org.openqa.selenium.WebDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Config {
    private Properties properties;
    private final String propertyFilePath = "src/main/resources/config.properties";

    public Config() {
        properties = new Properties();
        try (FileInputStream inputStream = new FileInputStream(propertyFilePath)) {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getBaseUrl() { return properties.getProperty("base.url");}

    public String getAccountUrl() { return properties.getProperty("account.url");}

    public String getStoreUrl() { return properties.getProperty("store.url");}

    public String getMenUrl() { return properties.getProperty("men.url");}

    public String getBillingUrl() { return properties.getProperty("billing.url");}
}
