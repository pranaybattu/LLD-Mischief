package com.moviebooking.service;

import com.moviebooking.model.Booking;
import com.moviebooking.repository.BookingRepository;

public class BookingService {

    private BookingRepository bookingRepository = new BookingRepository();

    public Booking createBooking(Booking booking) {
        bookingRepository.save(booking);
        System.out.println("Booking created: " + booking.getBookingId());
        return booking;
    }

    public Booking getBookingById(String bookingId) {
        return bookingRepository.findById(bookingId).orElse(null);
    }

    public void cancelBooking(String bookingId) {
        bookingRepository.delete(bookingId);
        System.out.println("Booking cancelled: " + bookingId);
    }

    // Other booking-related methods
}
