package model;

import pages.ComputeEnginePricingCalculatorPage;

public class ComputeEnginePricingCalculator {
    private int numberOfInstances;
    private String operatingSystemAndSoftware;
    private String provisioningModel;
    private String series;
    private String machineType;
    private boolean addGPUs;
    private String CPUType;
    private int numberOfGPUs;
    private String localSSD;
    private String datacenterLocation;
    private String committedUsage;

    public ComputeEnginePricingCalculator(ComputeEnginePricingCalculatorPage computeEnginePricingCalculatorPage) {
        this.numberOfInstances = computeEnginePricingCalculatorPage.getNumberOfInstances();
        this.operatingSystemAndSoftware = computeEnginePricingCalculatorPage.getOperatingSystemAndSoftware();
        this.provisioningModel = computeEnginePricingCalculatorPage.getProvisioningModel();
        this.series = computeEnginePricingCalculatorPage.getSeries();
        this.machineType = computeEnginePricingCalculatorPage.getMachineType();
        this.addGPUs = computeEnginePricingCalculatorPage.getAddGPUs();
        this.CPUType = computeEnginePricingCalculatorPage.getGPUType();
        this.numberOfGPUs = computeEnginePricingCalculatorPage.getNumberOfGPUs();
        this.localSSD = computeEnginePricingCalculatorPage.getLocalSSD();
        this.datacenterLocation = computeEnginePricingCalculatorPage.getDatacenterLocation();
        this.committedUsage = computeEnginePricingCalculatorPage.getCommittedUsage();
    }

    public void setNumberOfInstances(int numberOfInstances) {
        this.numberOfInstances = numberOfInstances;
    }

    public void setOperatingSystemAndSoftware(String operatingSystemAndSoftware) {
        this.operatingSystemAndSoftware = operatingSystemAndSoftware;
    }

    public void setProvisioningModel(String provisioningModel) {
        this.provisioningModel = provisioningModel;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public void setMachineType(String machineType) {
        this.machineType = machineType;
    }

    public void setAddGPUs(boolean addGPUs) {
        this.addGPUs = addGPUs;
    }

    public void setCPUType(String CPUType) {
        this.CPUType = CPUType;
    }

    public void setNumberOfGPUs(int numberOfGPUs) {
        this.numberOfGPUs = numberOfGPUs;
    }

    public void setLocalSSD(String localSSD) {
        this.localSSD = localSSD;
    }

    public void setDatacenterLocation(String datacenterLocation) {
        this.datacenterLocation = datacenterLocation;
    }

    public void setCommittedUsage(String committedUsage) {
        this.committedUsage = committedUsage;
    }
}
