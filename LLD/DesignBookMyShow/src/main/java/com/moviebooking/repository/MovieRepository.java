package com.moviebooking.repository;

import com.moviebooking.model.Movie;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class MovieRepository {
    private List<Movie> movieStore = new ArrayList<>();

    public List<Movie> findAll() {
        return new ArrayList<>(movieStore);
    }

    public Optional<Movie> findById(String movieId) {
        return movieStore.stream()
                .filter(movie -> movie.getMovieId().equals(movieId))
                .findFirst();
    }

    public void save(Movie movie) {
        movieStore.add(movie);
        System.out.println("Movie saved: " + movie.getTitle());
    }

    public void update(Movie movie) {
        for (int i = 0; i < movieStore.size(); i++) {
            if (movieStore.get(i).getMovieId().equals(movie.getMovieId())) {
                movieStore.set(i, movie);
                System.out.println("Movie updated: " + movie.getTitle());
                return;
            }
        }
        System.out.println("Movie not found: " + movie.getMovieId());
    }

    public void delete(String movieId) {
        movieStore.removeIf(movie -> movie.getMovieId().equals(movieId));
        System.out.println("Movie deleted: " + movieId);
    }

    public List<Movie> searchMovies(String title, String genre, String releaseDate, String language) {
        return movieStore.stream()
                .filter(movie -> (title == null || movie.getTitle().equalsIgnoreCase(title)) &&
                        (genre == null || movie.getGenre().equalsIgnoreCase(genre)) &&
                        (releaseDate == null || movie.getReleaseDate().equals(releaseDate)) &&
                        (language == null || movie.getLanguage().equalsIgnoreCase(language)))
                .collect(Collectors.toList());
    }

    public List<Movie> sortMoviesByReleaseDate(List<Movie> movies, boolean ascending) {
        return movies.stream()
                .sorted(Comparator.comparing(Movie::getReleaseDate,
                        ascending ? Comparator.naturalOrder() : Comparator.reverseOrder()))
                .collect(Collectors.toList());
    }
}
