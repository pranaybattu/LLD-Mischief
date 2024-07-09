package com.moviebooking.service;

import com.moviebooking.model.Movie;
import com.moviebooking.repository.MovieRepository;

import java.util.List;

public class MovieService {

    private MovieRepository movieRepository = new MovieRepository();

    public void addMovie(Movie movie) {
        movieRepository.save(movie);
        System.out.println("Movie added: " + movie.getTitle());
    }

    public void updateMovie(Movie movie) {
        movieRepository.update(movie);
        System.out.println("Movie updated: " + movie.getTitle());
    }

    public void deleteMovie(String movieId) {
        movieRepository.delete(movieId);
        System.out.println("Movie deleted: " + movieId);
    }

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public Movie getMovieById(String movieId) {
        return movieRepository.findById(movieId).orElse(null);
    }

    public List<Movie> searchMovies(String title, String genre, String releaseDate, String language) {
        return movieRepository.searchMovies(title, genre, releaseDate, language);
    }

    public List<Movie> sortMoviesByReleaseDate(List<Movie> movies, boolean ascending) {
        return movieRepository.sortMoviesByReleaseDate(movies, ascending);
    }
}
