package com.moviebooking.repository;

import com.moviebooking.model.Booking;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class BookingRepository {
    private Map<String, Booking> bookingStore = new HashMap<>();

    public Optional<Booking> findById(String bookingId) {
        return Optional.ofNullable(bookingStore.get(bookingId));
    }

    public void save(Booking booking) {
        bookingStore.put(booking.getBookingId(), booking);
        System.out.println("Booking saved: " + booking.getBookingId());
    }

    public void update(Booking booking) {
        bookingStore.put(booking.getBookingId(), booking);
        System.out.println("Booking updated: " + booking.getBookingId());
    }

    public void delete(String bookingId) {
        bookingStore.remove(bookingId);
        System.out.println("Booking deleted: " + bookingId);
    }
}
