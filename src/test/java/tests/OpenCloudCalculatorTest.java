package tests;

import org.testng.annotations.Test;
import pages.CloudGooglePage;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static com.codeborne.selenide.WebDriverRunner.url;
import static org.testng.Assert.assertEquals;
import static utils.SaveScreenshotRP.saveScreenshotRP;

public class OpenCloudCalculatorTest extends TestSetup {
    @Test
    public void openCloudCalculatorTest() {
        String expectedURL = "https://cloud.google.com/products/calculator1";
        logger.info("The 'openCloudCalculatorTest' test started.");
        CloudGooglePage cloudGooglePage = open("https://cloud.google.com/", CloudGooglePage.class);
        getWebDriver().manage().window().maximize();
        cloudGooglePage.enterSearchQuery("Google Cloud Platform Pricing Calculator");
        cloudGooglePage.findInSearchResults("Google Cloud Pricing Calculator");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if (!url().equals(expectedURL)) {
            logger.error("Assertion failed.\nExpected URL is " + expectedURL + "\nBut current URL is " + url());
            saveScreenshotRP("Screenshot saved.");
        }
        assertEquals(url(), expectedURL);

        logger.info("The 'openCloudCalculatorTest' test completed.");
    }

}
