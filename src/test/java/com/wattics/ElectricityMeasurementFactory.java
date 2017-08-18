package com.wattics;

import java.time.LocalDateTime;
import java.util.Random;

import static java.time.LocalDateTime.now;
import static java.util.UUID.randomUUID;

public class ElectricityMeasurementFactory {
    private static final Random RANDOM = new Random();
    private static ElectricityMeasurementFactory SINGLETON_INSTANCE;

    private String id;
    private LocalDateTime timestamp;
    private Double activePowerPhaseA;
    private Double activePowerPhaseB;
    private Double activePowerPhaseC;
    private Double reactivePowerPhaseA;
    private Double reactivePowerPhaseB;
    private Double reactivePowerPhaseC;
    private Double apparentPowerPhaseA;
    private Double apparentPowerPhaseB;
    private Double apparentPowerPhaseC;
    private Double voltagePhaseA;
    private Double voltagePhaseB;
    private Double voltagePhaseC;
    private Double currentPhaseA;
    private Double currentPhaseB;
    private Double currentPhaseC;
    private Double activeEnergyPhaseA;
    private Double activeEnergyPhaseB;
    private Double activeEnergyPhaseC;
    private Double lineToLineVoltagePhaseAB;
    private Double lineToLineVoltagePhaseBC;
    private Double lineToLineVoltagePhaseAC;

    public static ElectricityMeasurementFactory getInstance() {
        if (SINGLETON_INSTANCE == null) {
            SINGLETON_INSTANCE = new ElectricityMeasurementFactory();
        }
        return SINGLETON_INSTANCE;
    }

    public ElectricityMeasurement build() {
        ElectricityMeasurement object = new ElectricityMeasurement();
        object.setId(getId());
        object.setTimestamp(getTimestamp());
        object.setActivePowerPhaseA(getActivePowerPhaseA());
        object.setActivePowerPhaseB(getActivePowerPhaseB());
        object.setActivePowerPhaseC(getActivePowerPhaseC());
        object.setReactivePowerPhaseA(getReactivePowerPhaseA());
        object.setReactivePowerPhaseB(getReactivePowerPhaseB());
        object.setReactivePowerPhaseC(getReactivePowerPhaseC());
        object.setApparentPowerPhaseA(getApparentPowerPhaseA());
        object.setApparentPowerPhaseB(getApparentPowerPhaseB());
        object.setApparentPowerPhaseC(getApparentPowerPhaseC());
        object.setVoltagePhaseA(getVoltagePhaseA());
        object.setVoltagePhaseB(getVoltagePhaseB());
        object.setVoltagePhaseC(getVoltagePhaseC());
        object.setCurrentPhaseA(getCurrentPhaseA());
        object.setCurrentPhaseB(getCurrentPhaseB());
        object.setCurrentPhaseC(getCurrentPhaseC());
        object.setActiveEnergyPhaseA(getActiveEnergyPhaseA());
        object.setActiveEnergyPhaseB(getActiveEnergyPhaseB());
        object.setActiveEnergyPhaseC(getActiveEnergyPhaseC());
        object.setLineToLineVoltagePhaseAB(getLineToLineVoltagePhaseAB());
        object.setLineToLineVoltagePhaseAC(getLineToLineVoltagePhaseAC());
        object.setLineToLineVoltagePhaseBC(getLineToLineVoltagePhaseBC());
        return object;
    }

    private String getId() {
        if (id == null) {
            return randomUUID().toString();
        }
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    private LocalDateTime getTimestamp() {
        if (timestamp == null) {
            return now();
        }
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public Double getActivePowerPhaseA() {
        if (activePowerPhaseA == null) {
            return RANDOM.nextDouble();
        }
        return activePowerPhaseA;
    }

    public void setActivePowerPhaseA(Double activePowerPhaseA) {
        this.activePowerPhaseA = activePowerPhaseA;
    }

    public Double getActivePowerPhaseB() {
        if (activePowerPhaseB == null) {
            return RANDOM.nextDouble();
        }
        return activePowerPhaseB;
    }

    public void setActivePowerPhaseB(Double activePowerPhaseB) {
        this.activePowerPhaseB = activePowerPhaseB;
    }

    public Double getActivePowerPhaseC() {
        if (activePowerPhaseC == null) {
            return RANDOM.nextDouble();
        }
        return activePowerPhaseC;
    }

    public void setActivePowerPhaseC(Double activePowerPhaseC) {
        this.activePowerPhaseC = activePowerPhaseC;
    }

    public Double getReactivePowerPhaseA() {
        if (reactivePowerPhaseA == null) {
            return RANDOM.nextDouble();
        }
        return reactivePowerPhaseA;
    }

    public void setReactivePowerPhaseA(Double reactivePowerPhaseA) {
        this.reactivePowerPhaseA = reactivePowerPhaseA;
    }

    public Double getReactivePowerPhaseB() {
        if (reactivePowerPhaseB == null) {
            return RANDOM.nextDouble();
        }
        return reactivePowerPhaseB;
    }

    public void setReactivePowerPhaseB(Double reactivePowerPhaseB) {
        this.reactivePowerPhaseB = reactivePowerPhaseB;
    }

    public Double getReactivePowerPhaseC() {
        if (reactivePowerPhaseC == null) {
            return RANDOM.nextDouble();
        }
        return reactivePowerPhaseC;
    }

    public void setReactivePowerPhaseC(Double reactivePowerPhaseC) {
        this.reactivePowerPhaseC = reactivePowerPhaseC;
    }

    public Double getApparentPowerPhaseA() {
        if (apparentPowerPhaseA == null) {
            return RANDOM.nextDouble();
        }
        return apparentPowerPhaseA;
    }

    public void setApparentPowerPhaseA(Double apparentPowerPhaseA) {
        this.apparentPowerPhaseA = apparentPowerPhaseA;
    }

    public Double getApparentPowerPhaseB() {
        if (apparentPowerPhaseB == null) {
            return RANDOM.nextDouble();
        }
        return apparentPowerPhaseB;
    }

    public void setApparentPowerPhaseB(Double apparentPowerPhaseB) {
        this.apparentPowerPhaseB = apparentPowerPhaseB;
    }

    public Double getApparentPowerPhaseC() {
        if (apparentPowerPhaseC == null) {
            return RANDOM.nextDouble();
        }
        return apparentPowerPhaseC;
    }

    public void setApparentPowerPhaseC(Double apparentPowerPhaseC) {
        this.apparentPowerPhaseC = apparentPowerPhaseC;
    }

    public Double getVoltagePhaseA() {
        if (voltagePhaseA == null) {
            return RANDOM.nextDouble();
        }
        return voltagePhaseA;
    }

    public void setVoltagePhaseA(Double voltagePhaseA) {
        this.voltagePhaseA = voltagePhaseA;
    }

    public Double getVoltagePhaseB() {
        if (voltagePhaseB == null) {
            return RANDOM.nextDouble();
        }
        return voltagePhaseB;
    }

    public void setVoltagePhaseB(Double voltagePhaseB) {
        this.voltagePhaseB = voltagePhaseB;
    }

    public Double getVoltagePhaseC() {
        if (voltagePhaseC == null) {
            return RANDOM.nextDouble();
        }
        return voltagePhaseC;
    }

    public void setVoltagePhaseC(Double voltagePhaseC) {
        this.voltagePhaseC = voltagePhaseC;
    }

    public Double getCurrentPhaseA() {
        if (currentPhaseA == null) {
            return RANDOM.nextDouble();
        }
        return currentPhaseA;
    }

    public void setCurrentPhaseA(Double currentPhaseA) {
        this.currentPhaseA = currentPhaseA;
    }

    public Double getCurrentPhaseB() {
        if (currentPhaseB == null) {
            return RANDOM.nextDouble();
        }
        return currentPhaseB;
    }

    public void setCurrentPhaseB(Double currentPhaseB) {
        this.currentPhaseB = currentPhaseB;
    }

    public Double getCurrentPhaseC() {
        if (currentPhaseC == null) {
            return RANDOM.nextDouble();
        }
        return currentPhaseC;
    }

    public void setCurrentPhaseC(Double currentPhaseC) {
        this.currentPhaseC = currentPhaseC;
    }

    public Double getActiveEnergyPhaseA() {
        if (activeEnergyPhaseA == null) {
            return RANDOM.nextDouble();
        }
        return activeEnergyPhaseA;
    }

    public void setActiveEnergyPhaseA(Double activeEnergyPhaseA) {
        this.activeEnergyPhaseA = activeEnergyPhaseA;
    }

    public Double getActiveEnergyPhaseB() {
        if (activeEnergyPhaseB == null) {
            return RANDOM.nextDouble();
        }
        return activeEnergyPhaseB;
    }

    public void setActiveEnergyPhaseB(Double activeEnergyPhaseB) {
        this.activeEnergyPhaseB = activeEnergyPhaseB;
    }

    public Double getActiveEnergyPhaseC() {
        if (activeEnergyPhaseC == null) {
            return RANDOM.nextDouble();
        }
        return activeEnergyPhaseC;
    }

    public void setActiveEnergyPhaseC(Double activeEnergyPhaseC) {
        this.activeEnergyPhaseC = activeEnergyPhaseC;
    }

    public Double getLineToLineVoltagePhaseAB() {
        if (lineToLineVoltagePhaseAB == null) {
            return RANDOM.nextDouble();
        }
        return lineToLineVoltagePhaseAB;
    }

    public void setLineToLineVoltagePhaseAB(Double lineToLineVoltagePhaseAB) {
        this.lineToLineVoltagePhaseAB = lineToLineVoltagePhaseAB;
    }

    public Double getLineToLineVoltagePhaseBC() {
        if (lineToLineVoltagePhaseBC == null) {
            return RANDOM.nextDouble();
        }
        return lineToLineVoltagePhaseBC;
    }

    public void setLineToLineVoltagePhaseBC(Double lineToLineVoltagePhaseBC) {
        this.lineToLineVoltagePhaseBC = lineToLineVoltagePhaseBC;
    }

    public Double getLineToLineVoltagePhaseAC() {
        if (lineToLineVoltagePhaseAC == null) {
            return RANDOM.nextDouble();
        }
        return lineToLineVoltagePhaseAC;
    }

    public void setLineToLineVoltagePhaseAC(Double lineToLineVoltagePhaseAC) {
        this.lineToLineVoltagePhaseAC = lineToLineVoltagePhaseAC;
    }
}
