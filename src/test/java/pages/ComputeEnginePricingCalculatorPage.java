package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import model.ComputeEnginePricingCalculator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;
import static utils.HighlightElement.highlightElement;
import static utils.SelectDropdownItem.selectItem;

public class ComputeEnginePricingCalculatorPage {
    protected static Logger logger = LogManager.getRootLogger();

    @FindBy(how = How.XPATH, using = "//input[@ng-model='listingCtrl.computeServer.quantity']")
    private SelenideElement numberOfInstances;
    @FindBy(how = How.XPATH, using = "//md-select[@ng-model='listingCtrl.computeServer.os']")
    private SelenideElement operatingSystemAndSoftware;
    @FindBy(how = How.XPATH, using = "//md-select[@placeholder='VM Class']")
    private SelenideElement provisioningModel;
    @FindBy(how = How.XPATH, using = "//md-select[@placeholder='Series']")
    private SelenideElement series;
    @FindBy(how = How.XPATH, using = "//md-select[@placeholder='Instance type']")
    private SelenideElement machineType;
    @FindBy(how = How.XPATH, using = "(//md-checkbox[@aria-label='Add GPUs'])[1]")
    private SelenideElement addGPUs;
    @FindBy(how = How.XPATH, using = "//md-select[@placeholder='GPU type']")
    private SelenideElement GPUType;
    @FindBy(how = How.XPATH, using = "//md-select[@placeholder='Number of GPUs']")
    private SelenideElement numberOfGPUs;
    @FindBy(how = How.XPATH, using = "(//md-select[@placeholder='Local SSD'])[1]")
    private SelenideElement localSSD;
    @FindBy(how = How.XPATH, using = "(//md-select[@placeholder='Datacenter location'])[1]")
    private SelenideElement datacenterLocation;
    @FindBy(how = How.XPATH, using = "(//md-select[@placeholder='Committed usage'])[1]")
    private SelenideElement committedUsage;

    public int getNumberOfInstances() {
        return Integer.parseInt(numberOfInstances.getAttribute("value"));
    }

    public String getOperatingSystemAndSoftware() {
        return operatingSystemAndSoftware.getText();
    }

    public String getProvisioningModel() {
        return provisioningModel.getText();
    }

    public String getSeries() {
        return series.getText();
    }

    public String getMachineType() {
        return machineType.getText();
    }

    public boolean getAddGPUs() {
        return Boolean.parseBoolean(addGPUs.getAttribute("aria-checked"));
    }

    public String getGPUType() {
        return GPUType.getText();
    }

    public int getNumberOfGPUs() {
        return Integer.parseInt(numberOfGPUs.getText());
    }

    public String getLocalSSD() {
        return localSSD.getText();
    }

    public String getDatacenterLocation() {
        return datacenterLocation.getText();
    }

    public String getCommittedUsage() {
        return committedUsage.getText();
    }

    public void selectTab(int tabNumber) {
        SelenideElement tab = $(By.xpath("//md-tab-item[@id='tab-item-" + tabNumber + "']"));
        highlightElement(tab);
        tab.click();
        logger.info("Selected tab " + tab.getText() + " in the navigation bar.");
    }

    public void setNumberOfInstances(int number) {
        numberOfInstances.sendKeys("" + number);
        highlightElement(numberOfInstances);
        logger.info("Number of instances: " + number + ".");
    }

    public void setOperatingSystemAndSoftware(String operatingSystem) {
        Selenide.executeJavaScript("arguments[0].click();", operatingSystemAndSoftware);
        selectItem(operatingSystem);
        logger.info("Operating System / Software: " + operatingSystem + ".");
    }

    public void setProvisioningModel(String VMClass) {
        Selenide.executeJavaScript("arguments[0].click();", provisioningModel);
        selectItem(VMClass);
        logger.info("Provisioning model: " + VMClass + ".");
    }

    public void setSeries(String seria) {
        Selenide.executeJavaScript("arguments[0].click();", series);
        selectItem(seria);
        logger.info("Series: " + seria + ".");
    }

    public void setMachineType(String instanceType) {
        Selenide.executeJavaScript("arguments[0].click();", machineType);
        selectItem(instanceType);
        logger.info("Machine type: " + instanceType + ".");
    }

    public void setAddGPUs(boolean checked) {

        if (checked && !getAddGPUs() || !checked && getAddGPUs()) {
            Selenide.executeJavaScript("arguments[0].scrollIntoView(false);", addGPUs);
            Selenide.executeJavaScript("window.scrollTo(0, 500)");
            Selenide.executeJavaScript("arguments[0].click();", addGPUs);
            highlightElement(addGPUs);
            logger.info("Add GPUs: " + checked + ".");
        }
    }

    public void setGPUType(String type) {
        Selenide.executeJavaScript("arguments[0].click();", GPUType);
        selectItem(type);
        logger.info("GPU type: " + type + ".");
    }

    public void setNumberOfGPUs(int number) {
        Selenide.executeJavaScript("arguments[0].click();", numberOfGPUs);
        SelenideElement selectedNumber = $(By.xpath("//md-option[@ng-repeat='item in listingCtrl.supportedGpuNumbers[listingCtrl.computeServer.gpuType]'][@value = '" + number + "']"));
        highlightElement(selectedNumber);
        Selenide.executeJavaScript("arguments[0].click();", selectedNumber);
        logger.info("Number of GPUs: " + number + ".");
    }

    public void setLocalSSD(String ssd) {
        Selenide.executeJavaScript("arguments[0].click();", localSSD);
        selectItem(ssd);
        logger.info("Local SSD: " + ssd + ".");
    }

    public void setDatacenterLocation(String location) {
        Selenide.executeJavaScript("window.scrollTo(0, 500)");
        Selenide.executeJavaScript("arguments[0].click();", datacenterLocation);
        selectItem(location);
        logger.info("Datacenter location: " + location + ".");
    }

    public void setCommittedUsage(String duration) {
        Selenide.executeJavaScript("arguments[0].scrollIntoView();", committedUsage);
        Selenide.executeJavaScript("window.scrollTo(0, 500)");
        Selenide.executeJavaScript("arguments[0].click();", committedUsage);
        selectItem(duration);
        logger.info("Committed usage: " + duration + ".");
    }

    public ComputeEnginePricingCalculator clickAddToEstimate() {
        ComputeEnginePricingCalculator form = new ComputeEnginePricingCalculator(this);
        SelenideElement addToEstimate = $(By.xpath("(//button[contains(text(),'Add to Estimate')])[1]"));
        highlightElement(addToEstimate);
        Selenide.executeJavaScript("arguments[0].click();", addToEstimate);
        logger.info("The form has been completed and submitted for estimation.");
        return form;
    }

    public EmailYourEstimateModalForm clickEmailEstimate() {
        SelenideElement emailButton = $(By.id("Email Estimate"));
        highlightElement(emailButton);
        Selenide.executeJavaScript("arguments[0].click();", emailButton);
        logger.info("Request to send a result by email has been submitted.");
        return page(EmailYourEstimateModalForm.class);
    }
}
