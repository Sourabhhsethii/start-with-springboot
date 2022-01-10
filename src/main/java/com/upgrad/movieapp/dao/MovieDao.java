package com.upgrad.movieapp.dao;

import com.upgrad.movieapp.entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MovieDao extends JpaRepository<Movie,Integer> {

}
