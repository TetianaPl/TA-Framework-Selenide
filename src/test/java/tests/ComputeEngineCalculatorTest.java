package tests;

import org.testng.annotations.Test;
import pages.ComputeEnginePricingCalculatorPage;

import static utils.SwitchToNestedFrame.switchToNestedFrame;

public class ComputeEngineCalculatorTest extends TestSetup {

    @Test
    public void fillCalculatorFormTest() {
        logger.info("The 'fillCalculatorFormTest' test started.");
        driver.get("https://cloud.google.com/products/calculator");
        ComputeEnginePricingCalculatorPage computeEngineCalculatorPage = new ComputeEnginePricingCalculatorPage(driver);
        switchToNestedFrame(driver);
        computeEngineCalculatorPage.selectTab(1);
        computeEngineCalculatorPage.setNumberOfInstances(4);
        computeEngineCalculatorPage.setOperatingSystemAndSoftware("Free: Debian, CentOS, CoreOS, Ubuntu");
        computeEngineCalculatorPage.setProvisioningModel("Regular");
        computeEngineCalculatorPage.setSeries("N1");
        computeEngineCalculatorPage.setMachineType("n1-standard-8");
        computeEngineCalculatorPage.setAddGPUs(true);
//        computeEngineCalculatorPage.setCPUType("NVIDIA Tesla V100");
        computeEngineCalculatorPage.setCPUType("NVIDIA Tesla P100");
        computeEngineCalculatorPage.setNumberOfGPUs(1);
        computeEngineCalculatorPage.setLocalSSD("2x375");
        computeEngineCalculatorPage.setDatacenterLocation("Frankfurt");
        computeEngineCalculatorPage.setCommittedUsage("1 Year");
        computeEngineCalculatorPage.clickAddToEstimate();
        logger.info("The 'fillCalculatorFormTest' test completed.");
    }
}
