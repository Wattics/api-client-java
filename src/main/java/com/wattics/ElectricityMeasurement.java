package com.wattics;

import com.google.gson.annotations.SerializedName;

public class ElectricityMeasurement extends Measurement {
    @SerializedName("aP_1")
    private Double activePowerPhaseA;

    @SerializedName("aP_2")
    private Double activePowerPhaseB;

    @SerializedName("aP_3")
    private Double activePowerPhaseC;

    @SerializedName("rP_1")
    private Double reactivePowerPhaseA;

    @SerializedName("rP_2")
    private Double reactivePowerPhaseB;

    @SerializedName("rP_3")
    private Double reactivePowerPhaseC;

    @SerializedName("apP_1")
    private Double apparentPowerPhaseA;

    @SerializedName("apP_2")
    private Double apparentPowerPhaseB;

    @SerializedName("apP_3")
    private Double apparentPowerPhaseC;

    @SerializedName("v_1")
    private Double voltagePhaseA;

    @SerializedName("v_2")
    private Double voltagePhaseB;

    @SerializedName("v_3")
    private Double voltagePhaseC;

    @SerializedName("c_1")
    private Double currentPhaseA;

    @SerializedName("c_2")
    private Double currentPhaseB;

    @SerializedName("c_3")
    private Double currentPhaseC;

    @SerializedName("pC_1")
    private Double activeEnergyPhaseA;

    @SerializedName("pC_2")
    private Double activeEnergyPhaseB;

    @SerializedName("pC_3")
    private Double activeEnergyPhaseC;

    @SerializedName("v_12")
    private Double lineToLineVoltagePhaseAB;

    @SerializedName("v_23")
    private Double lineToLineVoltagePhaseBC;

    @SerializedName("v_13")
    private Double lineToLineVoltagePhaseAC;

    public Double getActivePowerPhaseA() {
        return activePowerPhaseA;
    }

    public void setActivePowerPhaseA(Double activePowerPhaseA) {
        this.activePowerPhaseA = activePowerPhaseA;
    }

    public Double getActivePowerPhaseB() {
        return activePowerPhaseB;
    }

    public void setActivePowerPhaseB(Double activePowerPhaseB) {
        this.activePowerPhaseB = activePowerPhaseB;
    }

    public Double getActivePowerPhaseC() {
        return activePowerPhaseC;
    }

    public void setActivePowerPhaseC(Double activePowerPhaseC) {
        this.activePowerPhaseC = activePowerPhaseC;
    }

    public Double getReactivePowerPhaseA() {
        return reactivePowerPhaseA;
    }

    public void setReactivePowerPhaseA(Double reactivePowerPhaseA) {
        this.reactivePowerPhaseA = reactivePowerPhaseA;
    }

    public Double getReactivePowerPhaseB() {
        return reactivePowerPhaseB;
    }

    public void setReactivePowerPhaseB(Double reactivePowerPhaseB) {
        this.reactivePowerPhaseB = reactivePowerPhaseB;
    }

    public Double getReactivePowerPhaseC() {
        return reactivePowerPhaseC;
    }

    public void setReactivePowerPhaseC(Double reactivePowerPhaseC) {
        this.reactivePowerPhaseC = reactivePowerPhaseC;
    }

    public Double getApparentPowerPhaseA() {
        return apparentPowerPhaseA;
    }

    public void setApparentPowerPhaseA(Double apparentPowerPhaseA) {
        this.apparentPowerPhaseA = apparentPowerPhaseA;
    }

    public Double getApparentPowerPhaseB() {
        return apparentPowerPhaseB;
    }

    public void setApparentPowerPhaseB(Double apparentPowerPhaseB) {
        this.apparentPowerPhaseB = apparentPowerPhaseB;
    }

    public Double getApparentPowerPhaseC() {
        return apparentPowerPhaseC;
    }

    public void setApparentPowerPhaseC(Double apparentPowerPhaseC) {
        this.apparentPowerPhaseC = apparentPowerPhaseC;
    }

    public Double getVoltagePhaseA() {
        return voltagePhaseA;
    }

    public void setVoltagePhaseA(Double voltagePhaseA) {
        this.voltagePhaseA = voltagePhaseA;
    }

    public Double getVoltagePhaseB() {
        return voltagePhaseB;
    }

    public void setVoltagePhaseB(Double voltagePhaseB) {
        this.voltagePhaseB = voltagePhaseB;
    }

    public Double getVoltagePhaseC() {
        return voltagePhaseC;
    }

    public void setVoltagePhaseC(Double voltagePhaseC) {
        this.voltagePhaseC = voltagePhaseC;
    }

    public Double getCurrentPhaseA() {
        return currentPhaseA;
    }

    public void setCurrentPhaseA(Double currentPhaseA) {
        this.currentPhaseA = currentPhaseA;
    }

    public Double getCurrentPhaseB() {
        return currentPhaseB;
    }

    public void setCurrentPhaseB(Double currentPhaseB) {
        this.currentPhaseB = currentPhaseB;
    }

    public Double getCurrentPhaseC() {
        return currentPhaseC;
    }

    public void setCurrentPhaseC(Double currentPhaseC) {
        this.currentPhaseC = currentPhaseC;
    }

    public Double getActiveEnergyPhaseA() {
        return activeEnergyPhaseA;
    }

    public void setActiveEnergyPhaseA(Double activeEnergyPhaseA) {
        this.activeEnergyPhaseA = activeEnergyPhaseA;
    }

    public Double getActiveEnergyPhaseB() {
        return activeEnergyPhaseB;
    }

    public void setActiveEnergyPhaseB(Double activeEnergyPhaseB) {
        this.activeEnergyPhaseB = activeEnergyPhaseB;
    }

    public Double getActiveEnergyPhaseC() {
        return activeEnergyPhaseC;
    }

    public void setActiveEnergyPhaseC(Double activeEnergyPhaseC) {
        this.activeEnergyPhaseC = activeEnergyPhaseC;
    }

    public Double getLineToLineVoltagePhaseAB() {
        return lineToLineVoltagePhaseAB;
    }

    public void setLineToLineVoltagePhaseAB(Double lineToLineVoltagePhaseAB) {
        this.lineToLineVoltagePhaseAB = lineToLineVoltagePhaseAB;
    }

    public Double getLineToLineVoltagePhaseBC() {
        return lineToLineVoltagePhaseBC;
    }

    public void setLineToLineVoltagePhaseBC(Double lineToLineVoltagePhaseBC) {
        this.lineToLineVoltagePhaseBC = lineToLineVoltagePhaseBC;
    }

    public Double getLineToLineVoltagePhaseAC() {
        return lineToLineVoltagePhaseAC;
    }

    public void setLineToLineVoltagePhaseAC(Double lineToLineVoltagePhaseAC) {
        this.lineToLineVoltagePhaseAC = lineToLineVoltagePhaseAC;
    }

    @Override
    public String toString() {
        return "ElectricityMeasurement{" +
                "id='" + id + '\'' +
                ", timestamp=" + timestamp +
                ", activePowerPhaseA=" + activePowerPhaseA +
                ", activePowerPhaseB=" + activePowerPhaseB +
                ", activePowerPhaseC=" + activePowerPhaseC +
                ", reactivePowerPhaseA=" + reactivePowerPhaseA +
                ", reactivePowerPhaseB=" + reactivePowerPhaseB +
                ", reactivePowerPhaseC=" + reactivePowerPhaseC +
                ", apparentPowerPhaseA=" + apparentPowerPhaseA +
                ", apparentPowerPhaseB=" + apparentPowerPhaseB +
                ", apparentPowerPhaseC=" + apparentPowerPhaseC +
                ", voltagePhaseA=" + voltagePhaseA +
                ", voltagePhaseB=" + voltagePhaseB +
                ", voltagePhaseC=" + voltagePhaseC +
                ", currentPhaseA=" + currentPhaseA +
                ", currentPhaseB=" + currentPhaseB +
                ", currentPhaseC=" + currentPhaseC +
                ", activeEnergyPhaseA=" + activeEnergyPhaseA +
                ", activeEnergyPhaseB=" + activeEnergyPhaseB +
                ", activeEnergyPhaseC=" + activeEnergyPhaseC +
                ", lineToLineVoltagePhaseAB=" + lineToLineVoltagePhaseAB +
                ", lineToLineVoltagePhaseBC=" + lineToLineVoltagePhaseBC +
                ", lineToLineVoltagePhaseAC=" + lineToLineVoltagePhaseAC +
                '}';
    }
}
