package tests;

import org.testng.annotations.Test;
import pages.CloudGooglePage;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static com.codeborne.selenide.WebDriverRunner.url;
import static org.testng.Assert.assertEquals;

public class OpenCloudCalculatorTest extends TestSetup {
    @Test
    public void openCloudCalculatorTest() {
        String expectedURL = "https://cloud.google.com/products/calculator";
        logger.trace("The 'openCloudCalculatorTest' test started.");
        CloudGooglePage cloudGooglePage = open("https://cloud.google.com/", CloudGooglePage.class);
        getWebDriver().manage().window().maximize();
        cloudGooglePage.enterSearchQuery("Google Cloud Platform Pricing Calculator");
        cloudGooglePage.findInSearchResults("Google Cloud Pricing Calculator");

        if (!url().equals(expectedURL)) {
            logger.error("Assertion failed.\nExpected URL is " + expectedURL + "\nBut current URL is " + url());
        }
        assertEquals(url(), expectedURL);

        logger.trace("The 'openCloudCalculatorTest' test completed.");
    }
}
