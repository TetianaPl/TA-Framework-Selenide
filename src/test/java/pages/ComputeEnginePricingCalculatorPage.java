package pages;

import model.ComputeEnginePricingCalculator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static utils.HighlightElement.highlightElement;
import static utils.SelectDropdownItem.selectItem;

public class ComputeEnginePricingCalculatorPage extends PageModel {
    @FindBy(xpath = "//md-tabs-wrapper/md-tabs-canvas")
    private WebElement navigationBar;
    @FindBy(xpath = "//input[@ng-model='listingCtrl.computeServer.quantity']")
    private WebElement numberOfInstances;
    @FindBy(xpath = "//md-select[@ng-model='listingCtrl.computeServer.os']")
    private WebElement operatingSystemAndSoftware;
    @FindBy(xpath = "//md-select[@placeholder='VM Class']")
    private WebElement provisioningModel;
    @FindBy(xpath = "//md-select[@placeholder='Series']")
    private WebElement series;
    @FindBy(xpath = "//md-select[@placeholder='Instance type']")
    private WebElement machineType;
    @FindBy(xpath = "(//md-checkbox[@aria-label='Add GPUs'])[1]")
    private WebElement addGPUs;
    @FindBy(xpath = "//md-select[@placeholder='GPU type']")
    private WebElement CPUType;
    @FindBy(xpath = "//md-select[@placeholder='Number of GPUs']")
    private WebElement numberOfGPUs;
    @FindBy(xpath = "(//md-select[@placeholder='Local SSD'])[1]")
    private WebElement localSSD;
    @FindBy(xpath = "(//md-select[@placeholder='Datacenter location'])[1]")
    private WebElement datacenterLocation;
    @FindBy(xpath = "(//md-select[@placeholder='Committed usage'])[1]")
    private WebElement committedUsage;
    @FindBy(xpath = "(//button[contains(text(),'Add to Estimate')])[1]")
    private WebElement addToEstimate;
    @FindBy(id = "Email Estimate")
    private WebElement emailButton;

    public ComputeEnginePricingCalculatorPage(WebDriver driver) {
        super(driver);
    }

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

    public String getCPUType() {
        return CPUType.getText();
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
        WebElement element = navigationBar.findElement(By.xpath("//md-tab-item[@id='tab-item-" + tabNumber + "']"));
        highlightElement(driver, element);
        element.click();
        logger.trace("Selected tab " + element.getText() + " in the navigation bar.");
    }

    public void setNumberOfInstances(int number) {
        numberOfInstances.sendKeys("" + number);
        highlightElement(driver, numberOfInstances);
        logger.trace("Number of instances: " + number + ".");
    }

    public void setOperatingSystemAndSoftware(String operatingSystem) {
        operatingSystemAndSoftware.click();
        selectItem(driver, operatingSystem);
        logger.trace("Operating System / Software: " + operatingSystem + ".");
    }

    public void setProvisioningModel(String VMClass) {
        provisioningModel.click();
        selectItem(driver, VMClass);
        logger.trace("Provisioning model: " + VMClass + ".");
    }

    public void setSeries(String seria) {
        JavascriptExecutor jsExec = (JavascriptExecutor) driver;
        jsExec.executeScript("arguments[0].click();", series);
        selectItem(driver, seria);
        logger.trace("Series: " + seria + ".");
    }

    public void setMachineType(String instanceType) {
        JavascriptExecutor jsExec = (JavascriptExecutor) driver;
        jsExec.executeScript("arguments[0].click();", machineType);
        selectItem(driver, instanceType);
        logger.trace("Machine type: " + instanceType + ".");
    }

    public void setAddGPUs(boolean checked) {
        if (checked && !getAddGPUs() || !checked && getAddGPUs()) {
            JavascriptExecutor jsExec = (JavascriptExecutor) driver;
            jsExec.executeScript("arguments[0].scrollIntoView(false);", addGPUs);
            jsExec.executeScript("window.scrollTo(0, 500)");
            jsExec.executeScript("arguments[0].click();", addGPUs);
            highlightElement(driver, addGPUs);
            logger.trace("Add GPUs: " + checked + ".");
        }
    }

    public void setCPUType(String type) {
        JavascriptExecutor jsExec = (JavascriptExecutor) driver;
        jsExec.executeScript("arguments[0].click();", CPUType);
        selectItem(driver, type);
        logger.trace("CPU type: " + type + ".");
    }

    public void setNumberOfGPUs(int number) {
        JavascriptExecutor jsExec = (JavascriptExecutor) driver;
        WebElement element = numberOfGPUs.findElement(By.xpath("//md-option[@ng-repeat='item in listingCtrl.supportedGpuNumbers[listingCtrl.computeServer.gpuType]'][@value = '" + number + "']"));
        highlightElement(driver, element);
        jsExec.executeScript("arguments[0].click();", element);
        logger.trace("Number of GPUs: " + number + ".");
    }

    public void setLocalSSD(String ssd) {
        JavascriptExecutor jsExec = (JavascriptExecutor) driver;
        jsExec.executeScript("arguments[0].click();", localSSD);
        selectItem(driver, ssd);
        logger.trace("Local SSD: " + ssd + ".");
    }

    public void setDatacenterLocation(String location) {
        JavascriptExecutor jsExec = (JavascriptExecutor) driver;
        jsExec.executeScript("window.scrollTo(0, 500)");
        datacenterLocation.click();
        selectItem(driver, location);
        logger.trace("Datacenter location: " + location + ".");
    }

    public void setCommittedUsage(String duration) {
        JavascriptExecutor jsExec = (JavascriptExecutor) driver;
        jsExec.executeScript("arguments[0].scrollIntoView();", committedUsage);
        jsExec.executeScript("window.scrollTo(0, 500)");
        jsExec.executeScript("arguments[0].click();", committedUsage);
        selectItem(driver, duration);
        logger.trace("Committed usage: " + duration + ".");
    }

    public ComputeEnginePricingCalculator clickAddToEstimate() {
        ComputeEnginePricingCalculator form = new ComputeEnginePricingCalculator(this);
        highlightElement(driver, addToEstimate);
        JavascriptExecutor jsExec = (JavascriptExecutor) driver;
        jsExec.executeScript("arguments[0].click();", addToEstimate);
        logger.trace("The form has been completed and submitted for estimation.");
        return form;
    }

    public EmailYourEstimateModalForm clickEmailEstimate() {
        highlightElement(driver, emailButton);
        emailButton.click();
        logger.info("Request to send a result by email has been submitted.");
        return new EmailYourEstimateModalForm(driver);
    }
}
