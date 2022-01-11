package com.upgrad.movieapp.services;

import com.upgrad.movieapp.dao.sql.springorm.MovieDao;
import com.upgrad.movieapp.entities.sql.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    public MovieDao _movieDao;

    @Override
    public Movie acceptMovieDetails(Movie movie) {
        return _movieDao.save(movie);
    }

    @Override
    @Transactional
    public List<Movie> acceptMultipleMovieDetails(List<Movie> movies) {

        List<Movie> savedMovies = new ArrayList<>();
        for (Movie movie: movies){
            savedMovies.add(acceptMovieDetails(movie));
        }
        return savedMovies;
    }

    @Override
    public Movie getMovieDetails(int id) {
        return _movieDao.findById(id).get();
    }

    @Override
    public Movie updateMovieDetails(int id, Movie movie) {
        Movie savedMovie = getMovieDetails(id);
        savedMovie.setMovieName(movie.getMovieName());
        savedMovie.setDuration(movie.getDuration());
        savedMovie.setTrailer_url(movie.getTrailer_url());
        savedMovie.setCover_photo_url(movie.getCover_photo_url());
        savedMovie.setRelease_date(movie.getRelease_date());
        savedMovie.setMovie_desc(movie.getMovie_desc());
        return _movieDao.save(savedMovie);
    }

    @Override
    public boolean deleteMovie(int id) {
        boolean isSaved;
        Movie savedMovie  = getMovieDetails(id);

        isSaved = savedMovie == null? true: false;

         _movieDao.delete(getMovieDetails(id));
        return isSaved;
    }

    @Override
    public List<Movie> getAllMovies() {
        return _movieDao.findAll();
    }

    @Override
    public Page<Movie> getPaginatedMovies(Pageable pageable) {
        return _movieDao.findAll(pageable);
    }
}
