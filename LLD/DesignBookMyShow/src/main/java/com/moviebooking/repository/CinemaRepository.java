package com.moviebooking.repository;

import com.moviebooking.model.Cinema;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CinemaRepository {
    private List<Cinema> cinemaStore = new ArrayList<>();

    public List<Cinema> findAll() {
        return new ArrayList<>(cinemaStore);
    }

    public Optional<Cinema> findById(String cinemaId) {
        return cinemaStore.stream()
                .filter(cinema -> cinema.getCinemaId().equals(cinemaId))
                .findFirst();
    }

    public void save(Cinema cinema) {
        cinemaStore.add(cinema);
        System.out.println("Cinema saved: " + cinema.getName());
    }

    public void update(Cinema cinema) {
        for (int i = 0; i < cinemaStore.size(); i++) {
            if (cinemaStore.get(i).getCinemaId().equals(cinema.getCinemaId())) {
                cinemaStore.set(i, cinema);
                System.out.println("Cinema updated: " + cinema.getName());
                return;
            }
        }
        System.out.println("Cinema not found: " + cinema.getCinemaId());
    }

    public void delete(String cinemaId) {
        cinemaStore.removeIf(cinema -> cinema.getCinemaId().equals(cinemaId));
        System.out.println("Cinema deleted: " + cinemaId);
    }
}
