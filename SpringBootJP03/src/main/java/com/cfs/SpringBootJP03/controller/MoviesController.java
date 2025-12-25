package com.cfs.SpringBootJP03.controller;

import com.cfs.SpringBootJP03.entity.Movies;
import com.cfs.SpringBootJP03.service.MoviesService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/movies")
public class MoviesController {
    private final MoviesService moviesService;
    public MoviesController(MoviesService moviesService) {
        this.moviesService = moviesService;
    }

//    @GetMapping
//    public List<Movies> findAllMovies() {
//        return moviesService.findAllMovies();
//    }

    @GetMapping
    public List<Movies> findAllMovies(
            @RequestParam(required = false)
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
            Date dueBefore
    ) {
        if (dueBefore != null) {
            return moviesService.findMoviesDueBefore(dueBefore);
        }
        return moviesService.findAllMovies();
    }


    @PostMapping
    public Movies createMovie(@RequestBody Movies movies) {
        return moviesService.createMovie(movies);
    }

    @PatchMapping("/{id}")
    public Movies updateFieldMovie(@PathVariable Long id,@RequestBody Map<String, Object> payload ) {
        return moviesService.updateFieldMovie(id,payload.get("title").toString());
    }

    @PutMapping("/{id}")
    public Movies updateMovie(@PathVariable Long id,@RequestBody Movies movies) {
        return moviesService.updateMovie(id,movies);
    }

    @GetMapping("/{id}")
    public Movies findMovie(@PathVariable Long id) {
        return moviesService.findMovie(id);
    }


    @DeleteMapping("/{id}")
    public void deleteMovie(@PathVariable Long id) {
         moviesService.deleteMovie(id);
    }

}
