package tests;

import org.testng.annotations.Test;
import pages.ComputeEnginePricingCalculatorPage;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static utils.SwitchToNestedFrame.switchToNestedFrame;

public class ComputeEngineCalculatorTest extends TestSetup {

    @Test
    public void fillCalculatorFormTest() {
        logger.trace("The 'fillCalculatorFormTest' test started.");
        ComputeEnginePricingCalculatorPage computeEngineCalculatorPage = open("https://cloud.google.com/products/calculator", ComputeEnginePricingCalculatorPage.class);
        getWebDriver().manage().window().maximize();
        switchToNestedFrame();
        computeEngineCalculatorPage.selectTab(1);
        computeEngineCalculatorPage.setNumberOfInstances(4);
        computeEngineCalculatorPage.setOperatingSystemAndSoftware("Free: Debian, CentOS, CoreOS, Ubuntu");
        computeEngineCalculatorPage.setProvisioningModel("Regular");
        computeEngineCalculatorPage.setSeries("N1");
        computeEngineCalculatorPage.setMachineType("n1-standard-8");
        computeEngineCalculatorPage.setAddGPUs(true);
//        computeEngineCalculatorPage.setCPUType("NVIDIA Tesla V100");
        computeEngineCalculatorPage.setGPUType("NVIDIA Tesla P100");
        computeEngineCalculatorPage.setNumberOfGPUs(1);
        computeEngineCalculatorPage.setLocalSSD("2x375");
        computeEngineCalculatorPage.setDatacenterLocation("Frankfurt");
        computeEngineCalculatorPage.setCommittedUsage("1 Year");
        computeEngineCalculatorPage.clickAddToEstimate();
        logger.trace("The 'fillCalculatorFormTest' test completed.");
    }
}
