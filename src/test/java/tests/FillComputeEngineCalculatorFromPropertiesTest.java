package tests;

import org.testng.annotations.Test;
import pages.ComputeEnginePricingCalculatorPage;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static utils.SwitchToNestedFrame.switchToNestedFrame;
import static utils.TestDataReader.getTestData;

public class FillComputeEngineCalculatorFromPropertiesTest extends TestSetup {
    @Test
    public void fillCalculatorFormTestFromPropertiesTest() {
        logger.trace("The 'fillCalculatorFormTestFromPropertiesTest' test started.");
        ComputeEnginePricingCalculatorPage computeEngineCalculatorPage = open("https://cloud.google.com/products/calculator", ComputeEnginePricingCalculatorPage.class);
        getWebDriver().manage().window().maximize();
        switchToNestedFrame();
        computeEngineCalculatorPage.selectTab(1);
        computeEngineCalculatorPage.setNumberOfInstances(Integer.parseInt(getTestData("numberOfInstances")));
        computeEngineCalculatorPage.setOperatingSystemAndSoftware(getTestData("operatingSystemAndSoftware"));
        computeEngineCalculatorPage.setProvisioningModel(getTestData("provisioningModel"));
        computeEngineCalculatorPage.setSeries(getTestData("series"));
        computeEngineCalculatorPage.setMachineType(getTestData("machineType"));
        if (Boolean.parseBoolean(getTestData("addGPUs"))) {
            computeEngineCalculatorPage.setAddGPUs(true);
            computeEngineCalculatorPage.setGPUType(getTestData("CPUType"));
            computeEngineCalculatorPage.setNumberOfGPUs(Integer.parseInt(getTestData("numberOfGPUs")));
        }
        computeEngineCalculatorPage.setLocalSSD(getTestData("localSSD"));
        computeEngineCalculatorPage.setDatacenterLocation(getTestData("datacenterLocation"));
        computeEngineCalculatorPage.setCommittedUsage(getTestData("committedUsage"));
        computeEngineCalculatorPage.clickAddToEstimate();
        logger.trace("The 'fillCalculatorFormTestFromPropertiesTest' test completed.");
    }
}
