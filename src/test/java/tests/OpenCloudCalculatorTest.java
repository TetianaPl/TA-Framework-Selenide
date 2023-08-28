package tests;

import org.testng.annotations.Test;
import pages.CloudGooglePage;

import static org.testng.Assert.assertEquals;

public class OpenCloudCalculatorTest extends TestSetup {
    @Test
    public static void openCloudCalculatorTest() {
        driver.get("https://cloud.google.com/");
        CloudGooglePage cloudGooglePage = new CloudGooglePage(driver);

        cloudGooglePage.clickSearch();
        cloudGooglePage.enterSearchQuery("Google Cloud Platform Pricing Calculator");
        cloudGooglePage.findInSearchResults("Google Cloud Pricing Calculator");

        assertEquals(driver.getCurrentUrl(), "https://cloud.google.com/products/calculator");
    }
}
