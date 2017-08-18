package com.wattics;

import org.apache.http.client.methods.CloseableHttpResponse;

import java.util.function.BiConsumer;

public interface MeasurementSentHandler {
    BiConsumer<Measurement, CloseableHttpResponse> remove();
}
