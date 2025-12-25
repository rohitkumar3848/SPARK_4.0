package com.cfs.SpringBootJP03.service;

import com.cfs.SpringBootJP03.entity.Movies;
import com.cfs.SpringBootJP03.repo.MoviesRepo;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class MoviesService {

   private final MoviesRepo moviesRepo;
   public MoviesService(MoviesRepo moviesRepo) {
       this.moviesRepo = moviesRepo;
   }

   //getAll--
    public List<Movies> findAllMovies() {
        return moviesRepo.findAll();
    }

    //get param date -
    public List<Movies> findMoviesDueBefore(Date date) {
        return moviesRepo.findByDueDateBefore(date);
    }

    //getById-
    public Movies findMovie(Long id) {
       return moviesRepo.findById(id).orElseThrow(()->new RuntimeException("Movies Not Found"));
    }

    //createMovie-
    public Movies createMovie(Movies movies) {
        return moviesRepo.save(movies);
    }

    //updateMovie-
    public Movies updateMovie(Long id,Movies movies) {
       Movies movies1 = moviesRepo.findById(id).orElseThrow(()->new RuntimeException("Movies Not Found"));
       movies1.setTitle(movies.getTitle());
       movies1.setDescription(movies.getDescription());
       movies1.setDueDate(movies.getDueDate());
       movies1.setStatus(movies.getStatus());
       return moviesRepo.save(movies1);
    }

    //update title of movie-
    public Movies updateFieldMovie(Long id,String title) {
        Movies movies1 = moviesRepo.findById(id).orElseThrow(()->new RuntimeException("Movies Not Found"));
        movies1.setTitle(title);
        return moviesRepo.save(movies1);
    }


    //delete movie-
    public void deleteMovie(Long id) {
       if(!moviesRepo.existsById(id)){
           throw new RuntimeException("Movies Not Found");
       }
       moviesRepo.deleteById(id);
    }

}
