package com.wattics.internal;

import com.wattics.Config;
import com.wattics.Measurement;

public class MeasurementWithConfig implements Comparable {
    private Measurement measurement;
    private Config config;

    public MeasurementWithConfig(Measurement measurement, Config config) {
        this.measurement = measurement;
        this.config = config;
    }

    public Measurement getMeasurement() {
        return measurement;
    }

    public void setMeasurement(Measurement measurement) {
        this.measurement = measurement;
    }

    public Config getConfig() {
        return config;
    }

    public void setConfig(Config config) {
        this.config = config;
    }

    @Override
    public int compareTo(Object o) {
        MeasurementWithConfig that = (MeasurementWithConfig) o;
        return this.measurement.compareTo(that.measurement);
    }
}
