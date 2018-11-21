package com.wattics.internal;

import com.wattics.CanReportSentMeasurement;

import java.util.HashMap;
import java.util.Map;

import static java.lang.Runtime.getRuntime;

public class ProcessorPool {
    private int MAX_PROCESSORS;
    private CanReportSentMeasurement reporter;
    private Map<String, Processor> processors;
    private final ThreadGroup processorThreadGroup;

    public ProcessorPool(CanReportSentMeasurement reporter, int maximumParallelSenders, ThreadGroup agentThreadGroup) {
        this.reporter = reporter;
        if (maximumParallelSenders > 0) {
            MAX_PROCESSORS = maximumParallelSenders;
        } else {
            MAX_PROCESSORS = 2 * getRuntime().availableProcessors();
        }
        processors = new HashMap<>();
        processorThreadGroup = new ThreadGroup(agentThreadGroup, "Processors");
    }

    public synchronized Processor getProcessor(String channelId) {
        Processor processor;

        processor = processors.get(channelId);
        if (processor != null) {
            return processor;
        }

        if (processors.size() < MAX_PROCESSORS) {
            processor = spawnNewProcessor();
            processors.put(channelId, processor);
            return processor;
        }

        return rebindProcessorToChannelId(channelId);
    }

    private Processor spawnNewProcessor() {
        Processor processor = new Processor(reporter);
        new Thread(processorThreadGroup, processor, "Processor-" + processors.size()).start();
        return processor;
    }

    private Processor rebindProcessorToChannelId(String newChannelId) {
        Map.Entry<String, Processor> idleProcessorEntry = processors.entrySet()
                .stream()
                .filter(entry -> entry.getValue().isIdle())
                .findFirst()
                .orElse(null);

        if (idleProcessorEntry == null) {
            return null;
        }

        String oldChannelId = idleProcessorEntry.getKey();
        Processor idleProcessor = idleProcessorEntry.getValue();
        processors.remove(oldChannelId);
        processors.put(newChannelId, idleProcessor);
        return idleProcessor;
    }
}
