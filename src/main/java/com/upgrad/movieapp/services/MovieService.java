package com.upgrad.movieapp.services;

import com.upgrad.movieapp.entities.sql.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface MovieService {

    public Movie acceptMovieDetails(Movie move);
    public List<Movie> acceptMultipleMovieDetails(List<Movie> movies);
    public Movie getMovieDetails(int id);
    public Movie updateMovieDetails(int id, Movie movie);
    public boolean deleteMovie(int id);
    public List<Movie> getAllMovies();
    public Page<Movie> getPaginatedMovies(Pageable pageable);
}
