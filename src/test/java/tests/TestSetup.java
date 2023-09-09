package tests;

import com.codeborne.selenide.Configuration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import utils.TestListener;

@Listeners({TestListener.class})
public class TestSetup {
    protected static Logger logger = LogManager.getRootLogger();

    @BeforeSuite
    public void testSetup() {
        Configuration.browser = System.getProperty("browser");
        Configuration.timeout = 15000;
        Configuration.reportsFolder = "./target/screenshots/";
    }
}
