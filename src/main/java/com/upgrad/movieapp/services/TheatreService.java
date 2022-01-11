package com.upgrad.movieapp.services;

import com.upgrad.movieapp.entities.sql.Theatre;

import java.util.List;

public interface TheatreService {
    Theatre acceptTheatreDetails(Theatre theatre);
    Theatre getTheatreDetails(int id) ;
    Theatre updateTheatreDetails(int id, Theatre theatre) ;
    boolean deleteTheatre(int id);
    List<Theatre> getAllTheatreDetails();
}
