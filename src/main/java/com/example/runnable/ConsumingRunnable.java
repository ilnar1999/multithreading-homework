package com.example.runnable;

import com.example.service.RequestService;

public class ConsumingRunnable implements Runnable {
    private RequestService requestService;
    private String name;

    public ConsumingRunnable(String name, RequestService requestService) {
        this.name = name;
        this.requestService = requestService;
    }

    @Override
    public void run() {
        Thread.currentThread().setName(this.name);
        while (!Thread.currentThread().isInterrupted()) {
            this.requestService.get();

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }
        }
    }
}
