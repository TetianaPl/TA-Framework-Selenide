package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import utils.PropertiesReader;

import java.time.Duration;

public class DriverManagement {
    private static WebDriver driver = null;
//    private static final String RESOURCES_PATH = "\\src\\test\\resources\\";

    public DriverManagement() {
    }

    public static WebDriver getDriver() {

        if (driver == null) {
            String browserName = PropertiesReader.get("browser");
            switch (PropertiesReader.get("browser")) {
                case "chrome" -> {
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.addArguments("--disable-notifications");
                    driver = new ChromeDriver(chromeOptions);
                }
                case "edge" -> {
                    WebDriverManager.edgedriver().setup();
                    EdgeOptions edgeOptions = new EdgeOptions();
                    edgeOptions.addArguments("--disable-notifications");
                    driver = new EdgeDriver(edgeOptions);
                }
                case "firefox" -> {
                    WebDriverManager.firefoxdriver().setup();
                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    firefoxOptions.addPreference("dom.webnotifications.enabled", false);
                    driver = new FirefoxDriver(firefoxOptions);
                }
                default ->
                        throw new IllegalArgumentException("Invalid browser name in properties file: " + browserName);
            }
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        }
        return driver;
    }

    public static void closeDriver() {
        driver.quit();
        driver = null;
    }
}
