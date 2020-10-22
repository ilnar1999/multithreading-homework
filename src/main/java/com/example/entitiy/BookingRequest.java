package com.example.entitiy;

import java.time.LocalDateTime;

public class BookingRequest {
    private int id;
    private LocalDateTime dateTime;
    private String hotel;
    private String customer;

    public BookingRequest(int id, LocalDateTime dateTime, String hotel, String customer) {
        this.id = id;
        this.dateTime = dateTime;
        this.hotel = hotel;
        this.customer = customer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getHotel() {
        return hotel;
    }

    public void setHotel(String hotel) {
        this.hotel = hotel;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }
}
