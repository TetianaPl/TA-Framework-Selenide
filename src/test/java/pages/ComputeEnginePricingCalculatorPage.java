package pages;

import model.ComputeEnginePricingCalculator;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

import static utils.SelectDropdownItem.selectItem;

public class ComputeEnginePricingCalculatorPage extends PageModel {
    @FindBy(xpath = "//md-tabs-wrapper/md-tabs-canvas")
    private WebElement navigationBar;
    @FindBy(id = "input_99")
    private WebElement numberOfInstances;
    @FindBy(id = "select_value_label_91")
    private WebElement operatingSystemAndSoftware;
    @FindBy(id = "select_value_label_92")
    private WebElement provisioningModel;
    @FindBy(id = "select_value_label_94")
    private WebElement series;
    @FindBy(id = "select_value_label_95")
    private WebElement machineType;
    @FindBy(xpath = "(//md-checkbox[@aria-label='Add GPUs'])[1]")
    private WebElement addGPUs;
    @FindBy(id = "select_value_label_492")
    private WebElement CPUType;
    @FindBy(id = "select_value_label_493")
    private WebElement numberOfGPUs;
    @FindBy(id = "select_value_label_452")
    private WebElement localSSD;
    @FindBy(id = "select_value_label_97")
    private WebElement datacenterLocation;
    @FindBy(id = "select_value_label_98")
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
        navigationBar.findElement(By.xpath("//md-tab-item[@id='tab-item-" + tabNumber + "']")).click();
    }

    public void setNumberOfInstances(int number) {
        numberOfInstances.sendKeys("" + number);
    }

    public void setOperatingSystemAndSoftware(String operatingSystem) {
        operatingSystemAndSoftware.click();
        selectItem(driver, operatingSystem);
    }

    public void setProvisioningModel(String VMClass) {
        provisioningModel.click();
        selectItem(driver, VMClass);
    }

    public void setSeries(String seria) {
        series.click();
        selectItem(driver, seria);
    }

    public void setMachineType(String instanceType) {
        machineType.click();
        selectItem(driver, instanceType);
    }

    public void setAddGPUs(boolean checked) {
        if (checked && !getAddGPUs() || !checked && getAddGPUs()) {
            JavascriptExecutor jsExec = (JavascriptExecutor) driver;
            jsExec.executeScript("arguments[0].scrollIntoView(false);", addGPUs);
            jsExec.executeScript("window.scrollTo(0, 500)");
            jsExec.executeScript("arguments[0].click();", addGPUs);
        }
    }

    public void setCPUType(String type) {
        JavascriptExecutor jsExec = (JavascriptExecutor) driver;
        jsExec.executeScript("arguments[0].click();", CPUType);
        selectItem(driver, type);
    }

    public void setNumberOfGPUs(int number) {
        JavascriptExecutor jsExec = (JavascriptExecutor) driver;
        jsExec.executeScript("arguments[0].click();", driver.findElement(By.xpath("//div[@id = 'select_container_497']//md-option[@value = '" + number + "']")));
    }

    public void setLocalSSD(String SSD) {
        localSSD.click();
        selectItem(driver, SSD);
    }

    public void setDatacenterLocation(String location) {
        JavascriptExecutor jsExec = (JavascriptExecutor) driver;
        jsExec.executeScript("window.scrollTo(0, 500)");
        datacenterLocation.click();
        selectItem(driver, location);
    }

    public void setCommittedUsage(String duration) {
        JavascriptExecutor jsExec = (JavascriptExecutor) driver;
        jsExec.executeScript("arguments[0].scrollIntoView();", committedUsage);
        jsExec.executeScript("window.scrollTo(0, 500)");
        jsExec.executeScript("arguments[0].click();", committedUsage);
        selectItem(driver, duration);
    }

    public ComputeEnginePricingCalculator clickAddToEstimate() {
        ComputeEnginePricingCalculator form = new ComputeEnginePricingCalculator(this);
        addToEstimate.click();
        return form;
    }

    public EmailYourEstimateModalForm clickEmailEstimate() {
        emailButton.click();
        return new EmailYourEstimateModalForm(driver);
    }
}
