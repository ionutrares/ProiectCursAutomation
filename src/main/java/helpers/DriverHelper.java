package helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public enum DriverHelper {

    INSTANCE;

    private FirefoxDriver firefoxDriver;

    public void startFirefoxDriver(String url) {
        firefoxDriver = new FirefoxDriver();
        firefoxDriver.get(url);
        firefoxDriver.manage().window().maximize();
    }

    public FirefoxDriver getFirefoxDriver() {
        return firefoxDriver;
    }

    public void closeFirefoxDriver() {
        firefoxDriver.quit();
    }
}
