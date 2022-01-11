package com.upgrad.movieapp.entities.sql;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "theatre")
public class Theatre {

    @Id
    @GeneratedValue
    private int theatreId;

    @Column(length = 20,nullable = false,unique = true)
    private String theatreName;

    @Column(nullable = false)
    private float ticketPrice = 150.0f;

    @ManyToOne
    @JoinColumn(nullable = false, name = "city_id")
    private City city;

    @ManyToMany(mappedBy = "theatres")
    private Set<Movie> movies;

    public int getTheatreId() {
        return theatreId;
    }

    public void setTheatreId(int theatreId) {
        this.theatreId = theatreId;
    }

    public String getTheatreName() {
        return theatreName;
    }

    public void setTheatreName(String theatreName) {
        this.theatreName = theatreName;
    }

    public float getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(float ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Set<Movie> getMovies() {
        return movies;
    }

    public void setMovies(Set<Movie> movies) {
        this.movies = movies;
    }

    @Override
    public String toString() {
        return "Theatres{" +
                "theatreId=" + theatreId +
                ", theatreName='" + theatreName + '\'' +
                ", ticketPrice=" + ticketPrice +
                ", city=" + city +
                '}';
    }
}
