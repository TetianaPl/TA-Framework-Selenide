package tests;

import driver.DriverManagement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;

public class TestSetup {
    protected static WebDriver driver;
    protected static Wait<WebDriver> wait;

    @BeforeSuite
    public void testSetup() {
        driver = DriverManagement.getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    @AfterMethod
    public void cleanUp() {
        driver.manage().deleteAllCookies();
    }

    @AfterClass
    public void tearDown() {
//        DriverManagement.closeDriver();
    }
}