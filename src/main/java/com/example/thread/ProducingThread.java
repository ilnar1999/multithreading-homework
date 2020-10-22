package com.example.thread;

import com.example.entitiy.BookingRequest;
import com.example.service.RequestService;

import java.time.LocalDateTime;
import java.util.Random;

public class ProducingThread extends Thread {
    private static final int MAX_REQUEST_ID = 9999;

    private final Random random = new Random();
    private final String customerName;
    private final RequestService requestService;

    public ProducingThread(String customerName, RequestService requestService) {
        this.setName(customerName);
        this.customerName = customerName;
        this.requestService = requestService;
        this.start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {

            try {
                sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                this.interrupt();
            }

            this.requestService.add(
                    new BookingRequest(
                            random.nextInt(MAX_REQUEST_ID),
                            LocalDateTime.now(),
                            "Hotel",
                            this.customerName
                    )
            );
        }
    }
}
