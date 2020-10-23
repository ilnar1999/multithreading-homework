package com.example.repository;

import com.example.entitiy.BookingRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayDeque;
import java.util.Queue;

public class RequestRepository {
    private final Queue<BookingRequest> requests = new ArrayDeque<>();
    private final Logger logger = LoggerFactory.getLogger("file-logger");

    public synchronized void add(BookingRequest bookingRequest) {
        synchronized (this.logger) {
            this.logger.info("producer {}: sent request №{}", Thread.currentThread().getName(), bookingRequest.getId());
        }

        synchronized (this.requests) {
            this.requests.add(bookingRequest);
        }
    }

    public synchronized BookingRequest get() {
        BookingRequest bookingRequest;

        synchronized (this.requests) {
            bookingRequest = this.requests.poll();
        }

        synchronized (this.logger) {
            this.logger.info("consumer {}: received request №{}", Thread.currentThread().getName(), bookingRequest.getId());
        }

        return bookingRequest;
    }

    public synchronized boolean isEmpty() {
        return this.requests.isEmpty();
    }

    public synchronized int countOfRequests() {
        return this.requests.size();
    }
}
