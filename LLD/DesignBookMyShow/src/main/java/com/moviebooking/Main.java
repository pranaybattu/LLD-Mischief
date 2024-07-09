package com.moviebooking;

import com.moviebooking.model.*;
import com.moviebooking.observer.notification.EmailNotification;
import com.moviebooking.observer.notification.SMSNotification;
import com.moviebooking.service.*;
import com.moviebooking.strategy.payment.*;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Setting up services
        UserService userService = new UserService();
        BookingService bookingService = new BookingService();
        MovieService movieService = new MovieService();
        NotificationService notificationService = new NotificationService();
        PaymentService paymentService = new PaymentService();

        // Setting up notification observers
        EmailNotification emailNotification = new EmailNotification();
        SMSNotification smsNotification = new SMSNotification();
        notificationService.addObserver(emailNotification);
        notificationService.addObserver(smsNotification);

        // Setting up payment strategies
        CreditCardPayment creditCardPayment = new CreditCardPayment();
        PayPalPayment payPalPayment = new PayPalPayment();
        paymentService.setPaymentStrategy(creditCardPayment);

        // Creating user
        User user = new User("1", "John Doe", "john@example.com", "password", "Customer");
        userService.registerUser(user);
        userService.loginUser(user.getEmail(), user.getPassword());

        // Creating multiple movies
        Movie movie1 = new Movie("1", "Inception", "Sci-Fi", "2010-07-16", "English");
        Movie movie2 = new Movie("2", "The Dark Knight", "Action", "2008-07-18", "English");
        Movie movie3 = new Movie("3", "Parasite", "Thriller", "2019-05-30", "Korean");
        Movie movie4 = new Movie("4", "Interstellar", "Sci-Fi", "2014-11-07", "English");
        movieService.addMovie(movie1);
        movieService.addMovie(movie2);
        movieService.addMovie(movie3);
        movieService.addMovie(movie4);

        // Searching for movies by title
        List<Movie> foundMoviesByTitle = movieService.searchMovies("Inception", null, null, null);
        System.out.println("Found movies by title: " + foundMoviesByTitle);

        // Searching for movies by genre
        List<Movie> foundMoviesByGenre = movieService.searchMovies(null, "Sci-Fi", null, null);
        System.out.println("Found movies by genre: " + foundMoviesByGenre);

        // Searching for movies by release date
        List<Movie> foundMoviesByReleaseDate = movieService.searchMovies(null, null, "2010-07-16", null);
        System.out.println("Found movies by release date: " + foundMoviesByReleaseDate);

        // Searching for movies by language
        List<Movie> foundMoviesByLanguage = movieService.searchMovies(null, null, null, "English");
        System.out.println("Found movies by language: " + foundMoviesByLanguage);

        // Sorting movies by release date (ascending)
        List<Movie> sortedMoviesAsc = movieService.sortMoviesByReleaseDate(movieService.getAllMovies(), true);
        System.out.println("Movies sorted by release date (ascending): " + sortedMoviesAsc);

        // Sorting movies by release date (descending)
        List<Movie> sortedMoviesDesc = movieService.sortMoviesByReleaseDate(movieService.getAllMovies(), false);
        System.out.println("Movies sorted by release date (descending): " + sortedMoviesDesc);

        // Creating booking
        Booking booking = new Booking("1", user.getUserId(), "1", Arrays.asList("1", "2"), 20.0, "Pending");
        bookingService.createBooking(booking);

        // Processing payment
        paymentService.processPayment(booking.getTotalPrice());

        // Sending notifications
        notificationService.notifyAllObservers("Booking confirmed for " + user.getName());

        // Logging out user
        userService.logoutUser(user.getUserId());
    }
}
