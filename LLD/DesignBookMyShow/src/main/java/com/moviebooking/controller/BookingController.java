package com.moviebooking.controller;

import com.moviebooking.model.Booking;
import com.moviebooking.service.BookingService;

public class BookingController {

    private BookingService bookingService = new BookingService();

    public Booking createBooking(Booking booking) {
        Booking createdBooking = bookingService.createBooking(booking);
        System.out.println("Booking created: " + createdBooking.getBookingId());
        return createdBooking;
    }

    public void viewBooking(String bookingId) {
        Booking booking = bookingService.getBookingById(bookingId);
        if (booking != null) {
            System.out.println("Booking details: " + booking.getBookingId());
        } else {
            System.out.println("Booking not found: " + bookingId);
        }
    }

    public void cancelBooking(String bookingId) {
        bookingService.cancelBooking(bookingId);
        System.out.println("Booking cancelled: " + bookingId);
    }

    // Other booking methods
}
