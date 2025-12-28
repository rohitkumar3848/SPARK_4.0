package com.bookmyshow.bookmyshow.controller;

import com.bookmyshow.bookmyshow.entity.Movie;
import com.bookmyshow.bookmyshow.service.BookingService;
import com.bookmyshow.bookmyshow.service.MovieService;
import com.bookmyshow.bookmyshow.service.MovieServiceImpl;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movies")
public class MovieController {
    private final MovieServiceImpl movieService;

    public MovieController(MovieServiceImpl movieService) {
        this.movieService = movieService;
    }

    // ADD MOVIE
    @PostMapping
    public Movie addMovie(@Valid @RequestBody Movie movie) {
        return  movieService.addMovie(movie);
    }

    // GET ALL MOVIES
    @GetMapping
    public List<Movie> getAllMovies() {
        return movieService.getAllMovies();
    }

    @GetMapping("/{id}")
    public  Movie getMovieById(@PathVariable Long id) {
        return movieService.getMovieById(id);
    }
}
