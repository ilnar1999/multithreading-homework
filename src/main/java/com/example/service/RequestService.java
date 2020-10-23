package com.example.service;

import com.example.entitiy.BookingRequest;
import com.example.repository.RequestRepository;

public class RequestService {
    private static final int MAX_QUEUE_SIZE = 5;

    private final RequestRepository requestRepository = new RequestRepository();

    public synchronized void add(BookingRequest bookingRequest) {
        while (this.requestRepository.countOfRequests() >= MAX_QUEUE_SIZE) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }
        }
        notifyAll();
        this.requestRepository.add(bookingRequest);
    }

    public synchronized BookingRequest get() {
        while (this.requestRepository.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }
        }
        return this.requestRepository.get();
    }
}
