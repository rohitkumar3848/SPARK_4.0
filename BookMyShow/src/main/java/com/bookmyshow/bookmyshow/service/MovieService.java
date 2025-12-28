package com.bookmyshow.bookmyshow.service;

import com.bookmyshow.bookmyshow.entity.Movie;

import java.util.List;

public interface MovieService {

    Movie addMovie(Movie movie);
    List<Movie> getAllMovies();
}
