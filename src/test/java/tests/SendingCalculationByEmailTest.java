package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import pages.ComputeEnginePricingCalculatorPage;
import pages.EmailYourEstimateModalForm;

import static org.testng.Assert.assertEquals;
import static utils.CreatingEmailAddress.createEmailAddress;
import static utils.SendCalculation.sendCalculation;
import static utils.SwitchToNewWindow.openAndSwitchToNewWindow;
import static utils.ReadResult.readResult;
import static utils.SwitchToNestedFrame.switchToNestedFrame;

public class SendingCalculationByEmailTest extends TestSetup {

    @Test
    public void sendResultsByEmail() {
        driver.get("https://cloud.google.com/products/calculator#id=acb50003-b82f-4780-a931-6fbc240c3588");
        String originalWindow = driver.getWindowHandle();
        ComputeEnginePricingCalculatorPage computeEngineCalculatorPage = new ComputeEnginePricingCalculatorPage(driver);
        switchToNestedFrame(driver);

        double resultFromCalculatorPage = readResult(driver, "calculatorForm");

        EmailYourEstimateModalForm modalWindow = computeEngineCalculatorPage.clickEmailEstimate();

        String newWindow = openAndSwitchToNewWindow(driver);

        String emailAddress = createEmailAddress(driver);

        driver.switchTo().window(originalWindow);
        driver.switchTo().defaultContent();
        switchToNestedFrame(driver);

        sendCalculation(modalWindow, emailAddress);

        driver.switchTo().window(newWindow);
        JavascriptExecutor jsExec = (JavascriptExecutor) driver;
        jsExec.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        jsExec.executeScript("window.scrollBy(0,-500)");

        wait.until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText("Google Cloud Price Estimate"))).click();

        double resultFromEmail = readResult(driver, "email");

        assertEquals(resultFromCalculatorPage, resultFromEmail);
    }
}
