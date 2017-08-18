package com.wattics;

import com.google.gson.annotations.SerializedName;

import java.time.LocalDateTime;

public abstract class Measurement implements Comparable {
    protected String id;

    @SerializedName("tsISO8601")
    protected LocalDateTime timestamp;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public int compareTo(Object o) {
        Measurement that = (Measurement) o;
        return this.timestamp.compareTo(that.timestamp);
    }
}
