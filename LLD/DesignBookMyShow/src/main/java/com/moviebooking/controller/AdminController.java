package com.moviebooking.controller;

import com.moviebooking.model.Movie;
import com.moviebooking.service.MovieService;

public class AdminController {

    private MovieService movieService = new MovieService();

    public void addMovie(Movie movie) {
        movieService.addMovie(movie);
        System.out.println("Movie added: " + movie.getTitle());
    }

    public void modifyMovie(Movie movie) {
        movieService.updateMovie(movie);
        System.out.println("Movie modified: " + movie.getTitle());
    }

    public void removeMovie(String movieId) {
        movieService.deleteMovie(movieId);
        System.out.println("Movie removed: " + movieId);
    }

    // Other admin methods

}
