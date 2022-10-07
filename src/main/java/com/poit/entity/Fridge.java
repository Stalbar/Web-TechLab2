package com.poit.entity;

public class Fridge extends Appliance {
    private double powerConsumption;
    private double heightInMeters;
    private double widthInMeters;

    public Fridge(double price, String manufacturer, String color, double powerConsumption, double heightInMeters, double widthInMeters) {
        super(price, manufacturer, color);
        this.powerConsumption = powerConsumption;
        this.heightInMeters = heightInMeters;
        this.widthInMeters = widthInMeters;
    }

    public double getPowerConsumption() {
        return powerConsumption;
    }

    public void setPowerConsumption(double powerConsumption) {
        this.powerConsumption = powerConsumption;
    }

    public double getHeightInMeters() {
        return heightInMeters;
    }

    public void setHeightInMeters(double heightInMeters) {
        this.heightInMeters = heightInMeters;
    }

    public double getWidthInMeters() {
        return widthInMeters;
    }

    public void setWidthInMeters(double widthInMeters) {
        this.widthInMeters = widthInMeters;
    }
}
