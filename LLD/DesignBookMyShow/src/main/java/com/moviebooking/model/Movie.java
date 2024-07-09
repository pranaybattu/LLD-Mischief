package com.moviebooking.model;

public class Movie {
    private String movieId;
    private String title;
    private String genre;
    private String releaseDate;
    private String language;

    // Getters and Setters

    public Movie(String movieId, String title, String genre, String releaseDate, String language) {
        this.movieId = movieId;
        this.title = title;
        this.genre = genre;
        this.releaseDate = releaseDate;
        this.language = language;
    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    //toString
    @Override
    public String toString() {
        return "Movie [movieId=" + movieId + ", title=" + title + ", genre=" + genre + ", releaseDate=" + releaseDate
                + ", language=" + language + "]";
    }
}
