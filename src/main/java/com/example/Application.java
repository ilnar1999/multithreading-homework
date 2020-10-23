package com.example;

import com.example.service.RequestService;
import com.example.runnable.ConsumingRunnable;
import com.example.runnable.ProducingRunnable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Application {
    private static final int PRODUCING_THREADS_COUNT = 3;
    private static final int CONSUMING_THREADS_COUNT = 6;

    public static void main(String[] args) {
        RequestService requestService = new RequestService();
        Logger logger = LoggerFactory.getLogger("file-logger");
        ExecutorService producingExecutorService = Executors.newFixedThreadPool(PRODUCING_THREADS_COUNT);
        ExecutorService consumingExecutorService = Executors.newFixedThreadPool(CONSUMING_THREADS_COUNT);

        logger.info("application is started");

        for (int i = 1; i <= PRODUCING_THREADS_COUNT; i++) {
            producingExecutorService.submit(new ProducingRunnable("Producer" + i, requestService));
        }

        for (int i = 1; i <= CONSUMING_THREADS_COUNT; i++) {
            consumingExecutorService.submit(new ConsumingRunnable("Consumer" + i, requestService));
        }
    }
}
