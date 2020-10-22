package com.example;

import com.example.service.RequestService;
import com.example.thread.ConsumingThread;
import com.example.thread.ProducingThread;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Application {
    public static void main(String[] args) {
        RequestService requestService = new RequestService();
        Logger logger = LoggerFactory.getLogger("file-logger");

        logger.info("application is started");

        new ProducingThread("Alex", requestService);
        new ProducingThread("Brandon", requestService);
        new ProducingThread("Charlie", requestService);

        new ConsumingThread("Booker1", requestService);
        new ConsumingThread("Booker2", requestService);
        new ConsumingThread("Booker3", requestService);
        new ConsumingThread("Booker4", requestService);
        new ConsumingThread("Booker5", requestService);
        new ConsumingThread("Booker6", requestService);
    }
}
