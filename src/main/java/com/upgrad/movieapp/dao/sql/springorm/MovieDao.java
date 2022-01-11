package com.upgrad.movieapp.dao.sql.springorm;

import com.upgrad.movieapp.entities.sql.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieDao extends JpaRepository<Movie,Integer> {

}
