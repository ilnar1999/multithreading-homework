package com.example.runnable;

import com.example.entitiy.BookingRequest;
import com.example.service.RequestService;

import java.time.LocalDateTime;
import java.util.Random;

public class ProducingRunnable implements Runnable {
    private static final int MAX_REQUEST_ID = 9999;

    private final Random random = new Random();
    private final String customerName;
    private final RequestService requestService;

    public ProducingRunnable(String customerName, RequestService requestService) {
        this.customerName = customerName;
        this.requestService = requestService;
    }

    @Override
    public void run() {
        Thread.currentThread().setName(this.customerName);
        for (int i = 0; i < 5; i++) {

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
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
