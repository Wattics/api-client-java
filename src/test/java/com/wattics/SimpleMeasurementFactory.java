package com.wattics;

import java.time.LocalDateTime;
import java.util.Random;

import static java.time.LocalDateTime.now;
import static java.util.UUID.randomUUID;

public class SimpleMeasurementFactory {
    private static final Random RANDOM = new Random();
    private static SimpleMeasurementFactory SINGLETON_INSTANCE;

    private String id;
    private LocalDateTime timestamp;
    private Double value;

    public static SimpleMeasurementFactory getInstance() {
        if (SINGLETON_INSTANCE == null) {
            SINGLETON_INSTANCE = new SimpleMeasurementFactory();
        }
        return SINGLETON_INSTANCE;
    }

    public SimpleMeasurement build() {
        SimpleMeasurement object = new SimpleMeasurement();
        object.setId(getId());
        object.setTimestamp(getTimestamp());
        object.setValue(getValue());
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

    public Double getValue() {
        if (value == null) {
            return RANDOM.nextDouble();
        }
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }
}
