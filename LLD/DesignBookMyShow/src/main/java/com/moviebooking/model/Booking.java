package com.moviebooking.model;

import java.util.List;

public class Booking {
    private String bookingId;
    private String userId;
    private String showId;
    private List<String> seats;
    private double totalPrice;
    private String paymentStatus;

    // Getters and Setters

    public Booking(String bookingId, String userId, String showId, List<String> seats, double totalPrice, String paymentStatus) {
        this.bookingId = bookingId;
        this.userId = userId;
        this.showId = showId;
        this.seats = seats;
        this.totalPrice = totalPrice;
        this.paymentStatus = paymentStatus;
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getShowId() {
        return showId;
    }

    public void setShowId(String showId) {
        this.showId = showId;
    }

    public List<String> getSeats() {
        return seats;
    }

    public void setSeats(List<String> seats) {
        this.seats = seats;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }
}
