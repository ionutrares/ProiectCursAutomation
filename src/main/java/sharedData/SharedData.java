package sharedData;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import sharedData.ChromeService;
import sharedData.EdgeService;

import java.time.Duration;
import java.util.Objects;

public class SharedData {

    private WebDriver driver;

    public void setUpDriver(){
        String browser = System.getProperty("browser");
        //System.out.println("Browser property value: " + browser);

        if (browser == null || browser.isEmpty()) {
            System.out.println("No browser specified. Defaulting to Chrome.");
        }

        switch (Objects.requireNonNull(browser)){
            case "chrome":
                ChromeService chromeService = new ChromeService();
                chromeService.openBrowser();
                driver = chromeService.getDriver();
                break;
            case "edge":
                EdgeService edgeService = new EdgeService();
                edgeService.openBrowser();
                driver = edgeService.getDriver();
                break;
            default:
                throw new RuntimeException("Unsupported browser: " + browser);
        }
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void quitDriver()
    {
        driver.quit();
    }
}