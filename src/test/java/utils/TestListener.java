package utils;

import com.codeborne.selenide.Configuration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {
    private final Logger logger = LogManager.getRootLogger();

    public void onTestFailure(ITestResult iTestResult) {
        logger.error("Test failed. Screenshot saved in " + Configuration.reportsFolder);
    }
}
