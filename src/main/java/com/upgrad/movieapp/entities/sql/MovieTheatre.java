package com.upgrad.movieapp.entities.sql;

import javax.persistence.*;

@Entity
public class MovieTheatre {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int movieTheatreId;

    @ManyToOne
    @JoinColumn(name = "movie_id", nullable = false)
    private Movie movie;

    @ManyToOne
    @JoinColumn(name = "theatre_id",nullable = false)
    private Theatre theatre;


}
