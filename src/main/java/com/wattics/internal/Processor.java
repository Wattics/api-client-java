package com.wattics.internal;

import com.wattics.*;
import org.apache.http.client.methods.CloseableHttpResponse;

import java.io.IOException;
import java.util.Collection;
import java.util.Date;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.Semaphore;

public class Processor implements Runnable {
    private final Semaphore canConsumeSemaphore;
    private CanReportSentMeasurement reporter;
    private Client client;
    public PriorityBlockingQueue<MeasurementWithConfig> measurementsWithConfig;
    private boolean isSending = false;

    public Processor(CanReportSentMeasurement reporter) {
        this.reporter = reporter;
        this.client = ClientFactory.getInstance().createClient();
        this.measurementsWithConfig = new PriorityBlockingQueue<>();
        canConsumeSemaphore = new Semaphore(0);
    }

    public void process(MeasurementWithConfig measurementWithConfig) {
        measurementsWithConfig.add(measurementWithConfig);
        canConsumeSemaphore.release();
    }

    public void process(Collection<MeasurementWithConfig> measurementsWithConfig) {
        this.measurementsWithConfig.addAll(measurementsWithConfig);
        canConsumeSemaphore.release(measurementsWithConfig.size());
    }

    synchronized boolean isIdle() {
        return measurementsWithConfig.isEmpty() && !isSending;
    }

    @Override
    public void run() {
        try {
            while (true) {
                MeasurementWithConfig measurementWithConfig;

                canConsumeSemaphore.acquire();

                synchronized (this) {
                    measurementWithConfig = measurementsWithConfig.take();
                    this.isSending = true;
                }

                Measurement measurement = measurementWithConfig.getMeasurement();
                Config config = measurementWithConfig.getConfig();

                while (true) {
                    try {
                        CloseableHttpResponse response = client.send(measurement, config);

                        if (reporter != null) {
                            reporter.reportSentMeasurement(measurement, response);
                            reporter.setLastMeasurementSentTime((new Date()).getTime());
                        }

                        if (response != null && response.getStatusLine().getStatusCode() >= 400) {
                            throw new IOException(response.getStatusLine().getReasonPhrase());
                        }

                        break;
                    } catch (IOException e) {
                        e.printStackTrace();
                        Thread.sleep(60000L);
                    }
                }

                synchronized (this) {
                    this.isSending = false;
                }
            }
        } catch (InterruptedException e) {
        }
    }
}
