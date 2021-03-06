package com.upgrad.movieapp.entities.sql;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "Movie")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int movie_id;

    @Column(length = 25, nullable = false)
    String movieName;

    @Column(length = 256, nullable = false)
    String movie_desc;

    @Column(nullable = false)
    LocalDate release_date;

    @Column( nullable = false)
    int duration;

    @Column( nullable = true)
    String cover_photo_url;

    @Column( nullable = true)
    String trailer_url;

    @Column( nullable = false)
    int status_id;

    @ManyToMany
    private Set<Theatre> theatres;


    public int getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(int movie_id) {
        this.movie_id = movie_id;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movie_name) {
        this.movieName = movie_name;
    }

    public String getMovie_desc() {
        return movie_desc;
    }

    public void setMovie_desc(String movie_desc) {
        this.movie_desc = movie_desc;
    }

    public LocalDate getRelease_date() {
        return release_date;
    }

    public void setRelease_date(LocalDate release_date) {
        this.release_date = release_date;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getCover_photo_url() {
        return cover_photo_url;
    }

    public void setCover_photo_url(String cover_photo_url) {
        this.cover_photo_url = cover_photo_url;
    }

    public String getTrailer_url() {
        return trailer_url;
    }

    public void setTrailer_url(String trailer_url) {
        this.trailer_url = trailer_url;
    }

    public int getStatus_id() {
        return status_id;
    }

    public void setStatus_id(int status_id) {
        this.status_id = status_id;
    }

    public Set<Theatre> getTheatres() {
        return theatres;
    }

    public void setTheatres(Set<Theatre> theatres) {
        this.theatres = theatres;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "movie_id=" + movie_id +
                ", movieName='" + movieName + '\'' +
                ", movie_desc='" + movie_desc + '\'' +
                ", release_date=" + release_date +
                ", duration=" + duration +
                ", cover_photo_url='" + cover_photo_url + '\'' +
                ", trailer_url='" + trailer_url + '\'' +
                ", status_id=" + status_id +
                ", theatres=" + theatres +
                '}';
    }
}
