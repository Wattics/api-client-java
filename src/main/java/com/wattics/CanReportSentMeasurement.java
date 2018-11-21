package com.wattics;

import org.apache.http.client.methods.CloseableHttpResponse;

public interface CanReportSentMeasurement {
    void reportSentMeasurement(Measurement measurement, CloseableHttpResponse response);
}
