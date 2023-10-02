package com.wattics;

import com.google.common.collect.LinkedListMultimap;
import com.google.common.collect.ListMultimap;
import com.wattics.internal.MeasurementWithConfig;
import com.wattics.internal.Processor;
import com.wattics.internal.ProcessorPool;
import org.apache.http.client.methods.CloseableHttpResponse;

import java.util.*;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;

import static com.google.common.collect.Lists.newArrayList;
import static com.google.common.collect.Multimaps.synchronizedListMultimap;

public class Agent implements CanReportSentMeasurement {
    private static Agent SINGLETON_INSTANCE;

    private final ThreadGroup agentThreadGroup;
    private ProcessorPool processorPool;
    private final ListMultimap<String, MeasurementWithConfig> enqueuedMeasurementsWithConfig;
    private final BlockingQueue<Object[]> sentMeasurementsWithContext;
    private final List<BiConsumer<Measurement, CloseableHttpResponse>> measurementSentHandlerList;
    private long lastMeasurementSentTime;

    public static synchronized Agent getInstance() {
        return getInstance(0);
    }

    public static synchronized Agent getInstance(int maximumParallelSenders) {
        if (SINGLETON_INSTANCE == null) {
            SINGLETON_INSTANCE = new Agent(maximumParallelSenders);
        }

        return SINGLETON_INSTANCE;
    }

    public static synchronized void dispose() {
        if (SINGLETON_INSTANCE != null) {
            SINGLETON_INSTANCE.agentThreadGroup.interrupt();
            SINGLETON_INSTANCE = null;
        }
    }

    private Agent(int maximumParallelSenders) {
        agentThreadGroup = new ThreadGroup("Agent");
        processorPool = new ProcessorPool(this, maximumParallelSenders, agentThreadGroup);
        enqueuedMeasurementsWithConfig = synchronizedListMultimap(LinkedListMultimap.create());
        sentMeasurementsWithContext = new LinkedBlockingQueue<>();
        measurementSentHandlerList = new CopyOnWriteArrayList<BiConsumer<Measurement, CloseableHttpResponse>>();
        lastMeasurementSentTime = 0;
        startProcessorFeeder();
        startMeasurementSentHandlerDispatcher();
    }

    private void startProcessorFeeder() {
        new Thread(agentThreadGroup, () -> {
            try {
                while (true) {
                    String channelId = null;
                    boolean hasNext = true;
                    synchronized (enqueuedMeasurementsWithConfig) {
                        Iterator<String> iterator = enqueuedMeasurementsWithConfig.keySet().iterator();
                        hasNext = iterator.hasNext();
                        if (hasNext) {
                            channelId = iterator.next();
                        }
                    }

                    if (!hasNext) {
                        sleep();
                        continue;
                    }


                    boolean hasProcessor = false;

                    synchronized (enqueuedMeasurementsWithConfig) {
                        Processor processor = processorPool.getProcessor(channelId);
                        if (processor != null) {
                            hasProcessor = true;
                            // Creates a new list because the returned collection is weak and if you remove all elements
                            // from the multimap it will also remove from the returned collection
                            Collection<MeasurementWithConfig> measurementsWithConfig = newArrayList(enqueuedMeasurementsWithConfig.asMap().get(channelId));
                            enqueuedMeasurementsWithConfig.removeAll(channelId);
                            processor.process(measurementsWithConfig);
                        }
                    }

                    if (!hasProcessor) {
                        sleep();
                    }
                }
            } catch (InterruptedException e) {
            }
        }, "ProcessorFeeder").start();
    }

    private void startMeasurementSentHandlerDispatcher() {
        new Thread(agentThreadGroup, () -> {
            try {
                while (true) {
                    Object[] array = sentMeasurementsWithContext.take();
                    Measurement measurement = (Measurement) array[0];
                    CloseableHttpResponse response = (CloseableHttpResponse) array[1];
                    Agent.this.measurementSentHandlerList.forEach(measurementSentHandler -> measurementSentHandler.accept(measurement, response));
                }
            } catch (InterruptedException e) {
            }
        }, "MeasurementSentHandlerDispatcher").start();
    }

    private void sleep() throws InterruptedException {
        Thread.sleep(100L);
    }

    public void send(Measurement measurement, Config config) {
        synchronized (enqueuedMeasurementsWithConfig) {
            MeasurementWithConfig measurementWithConfig = new MeasurementWithConfig(measurement, config);
            enqueuedMeasurementsWithConfig.put(measurement.getId(), measurementWithConfig);
        }
    }

    public void send(Collection<Measurement> measurements, Config config) {
        synchronized (enqueuedMeasurementsWithConfig) {
            Map<String, List<Measurement>> measurementGroups = measurements
                    .parallelStream()
                    .collect(Collectors.groupingBy(Measurement::getId));

            measurementGroups.forEach((channelId, measurementsForChannelId) -> {
                List<MeasurementWithConfig> measurementsWithConfig = measurementsForChannelId
                        .stream()
                        .map(measurement -> new MeasurementWithConfig(measurement, config))
                        .collect(Collectors.toList());
                enqueuedMeasurementsWithConfig.putAll(channelId, measurementsWithConfig);
            });
        }
    }

    public void reportSentMeasurement(Measurement measurement, CloseableHttpResponse response) {
        sentMeasurementsWithContext.add(new Object[]{measurement, response});
    }

    public void setLastMeasurementSentTime(long time) {
        lastMeasurementSentTime = time;
    }

    public long getLastMeasurementSentTime() {
        return lastMeasurementSentTime;
    }

    public MeasurementSentHandler addMeasurementSentHandler(BiConsumer<Measurement, CloseableHttpResponse> handler) {
        MeasurementSentHandler measurementSentHandler = new MeasurementSentHandler() {
            @Override
            public BiConsumer<Measurement, CloseableHttpResponse> remove() {
                Agent.this.measurementSentHandlerList.remove(handler);
                return handler;
            }
        };
        this.measurementSentHandlerList.add(handler);
        return measurementSentHandler;
    }
}
