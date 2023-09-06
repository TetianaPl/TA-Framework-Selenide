package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.ComputeEnginePricingCalculatorPage;
import pages.EmailYourEstimateModalForm;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.testng.Assert.assertEquals;
import static utils.CreatingEmailAddress.createEmailAddress;
import static utils.ReadResult.readResult;
import static utils.SendCalculation.sendCalculation;
import static utils.SwitchToNestedFrame.switchToNestedFrame;
import static utils.SwitchToNewWindow.openAndSwitchToNewWindow;

public class SendingCalculationByEmailTest extends TestSetup {
    @Test
    public void sendResultsByEmailTest() {
        logger.trace("The 'sendResultsByEmailTest' test started.");
        ComputeEnginePricingCalculatorPage computeEngineCalculatorPage = open("https://cloud.google.com/products/calculator#id=acb50003-b82f-4780-a931-6fbc240c3588", ComputeEnginePricingCalculatorPage.class);
        getWebDriver().manage().window().maximize();
        String originalWindow = getWebDriver().getWindowHandle();
        switchToNestedFrame();

        double resultFromCalculatorPage = readResult("calculatorForm");
        logger.debug("resultFromCalculatorPage = " + resultFromCalculatorPage);

        EmailYourEstimateModalForm modalWindow = computeEngineCalculatorPage.clickEmailEstimate();

        String newWindow = openAndSwitchToNewWindow();

        String emailAddress = createEmailAddress();
        logger.debug("Email address created: " + emailAddress);

        switchTo().window(originalWindow);
        switchTo().defaultContent();
        switchToNestedFrame();

        sendCalculation(modalWindow, emailAddress);

        switchTo().window(newWindow);
        Selenide.executeJavaScript("window.scrollBy(0,document.body.scrollHeight)");
        Selenide.executeJavaScript("window.scrollBy(0,-300)");

        $(By.partialLinkText("Google Cloud Price Estimate")).shouldBe(Condition.appear).click();

        double resultFromEmail = readResult("email");
        logger.debug("resultFromEmail = " + resultFromEmail);

        if (resultFromCalculatorPage != resultFromEmail) {
            logger.error("Assertion failed. The estimated price in the email: " + resultFromEmail + " does not match the estimated price on the Calculator Page: " + resultFromCalculatorPage);
        }
        assertEquals(resultFromCalculatorPage, resultFromEmail);
        logger.trace("The 'sendResultsByEmailTest' test completed.");
    }
}
