package utils;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class TestListener implements ITestListener {
    private final Logger logger = LogManager.getRootLogger();

    public void onTestFailure(ITestResult iTestResult) {
        logger.error("Test failed.");
        saveScreenshot();
    }

    private void saveScreenshot() {
        File screenCapture = ((TakesScreenshot)getWebDriver())
                .getScreenshotAs(OutputType.FILE);
        try {
            String pathName = ".//target/screenshots/"
                    + getCurrentTimeAsString() + ".png";
            FileUtils.copyFile(screenCapture, new File(pathName));
            logger.warn("Screenshot saved in " + pathName);
        } catch (IOException e) {
            logger.error("Failed to save screenshot: " + e.getLocalizedMessage());
        }
    }

    private String getCurrentTimeAsString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("uuuu-MM-dd_HH-mm-ss");
        return ZonedDateTime.now().format(formatter);
    }
}
