package com.example.thread;

import com.example.service.RequestService;

public class ConsumingThread extends Thread {
    private RequestService requestService;

    public ConsumingThread(String name, RequestService requestService) {
        super(name);
        this.requestService = requestService;
        this.start();
    }

    @Override
    public void run() {
        while (!isInterrupted()) {
            this.requestService.get();

            try {
                sleep(6000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                this.interrupt();
            }
        }
    }
}
