package tests;

import org.testng.annotations.Test;
import pages.CloudGooglePage;

import static org.testng.Assert.assertEquals;

public class OpenCloudCalculatorTest extends TestSetup {
    @Test
    public void openCloudCalculatorTest() {
        String expectedURL = "https://cloud.google.com/products/calculator";
        logger.info("The 'openCloudCalculatorTest' test started.");
        driver.get("https://cloud.google.com/");
        CloudGooglePage cloudGooglePage = new CloudGooglePage(driver);

        cloudGooglePage.clickSearch();
        cloudGooglePage.enterSearchQuery("Google Cloud Platform Pricing Calculator");
        cloudGooglePage.findInSearchResults("Google Cloud Pricing Calculator");

//        wait.until(ExpectedConditions.urlToBe(expectedURL));
        if (!driver.getCurrentUrl().equals(expectedURL)) {
            logger.error("Assertion failed.\nExpected URL is " + expectedURL + "\nBut current URL is " + driver.getCurrentUrl());
        }
        assertEquals(driver.getCurrentUrl(), expectedURL);

        logger.info("The 'openCloudCalculatorTest' test completed.");
    }
}
