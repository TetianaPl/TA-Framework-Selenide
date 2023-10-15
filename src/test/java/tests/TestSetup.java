package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.epam.reportportal.selenide.ReportPortalSelenideEventListener;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.logging.LogType;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import utils.TestListener;

import java.util.logging.Level;

@Listeners({TestListener.class})
public class TestSetup {
    public static Logger logger = LogManager.getRootLogger();

    @BeforeSuite
    public void testSetup() {
        Configuration.browser = System.getProperty("browser");
        Configuration.timeout = 15000;
        Configuration.screenshots = true;
    }

    static {
        SelenideLogger.addListener("Report Portal logger",
                new ReportPortalSelenideEventListener().enableSeleniumLogs(LogType.BROWSER, Level.FINER));
    }
}
