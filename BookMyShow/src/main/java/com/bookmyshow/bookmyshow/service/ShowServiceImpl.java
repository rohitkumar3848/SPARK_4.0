package com.bookmyshow.bookmyshow.service;


import com.bookmyshow.bookmyshow.entity.Movie;
import com.bookmyshow.bookmyshow.entity.Show;
import com.bookmyshow.bookmyshow.entity.Theatre;
import com.bookmyshow.bookmyshow.exception.ResourceNotFoundException;
import com.bookmyshow.bookmyshow.repository.MovieRepository;
import com.bookmyshow.bookmyshow.repository.ShowRepository;
import com.bookmyshow.bookmyshow.repository.TheatreRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShowServiceImpl implements ShowService {
    private final ShowRepository showRepository;
    private final MovieRepository movieRepository;
    private final TheatreRepository theatreRepository;

    public ShowServiceImpl(ShowRepository showRepository,
                           MovieRepository movieRepository,
                           TheatreRepository theatreRepository) {
        this.showRepository = showRepository;
        this.movieRepository = movieRepository;
        this.theatreRepository = theatreRepository;
    }


    @Override
    public Show addShow(Show show){

        Long movieId = show.getMovie().getId();
        Long theatreId = show.getTheatre().getId();

        Movie movie = movieRepository.findById(movieId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Movie not found with id: " + movieId));

        Theatre theatre = theatreRepository.findById(theatreId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Theatre not found with id: " + theatreId));

        show.setMovie(movie);
        show.setTheatre(theatre);

        return showRepository.save(show);
   }

   @Override
    public List<Show> getShowsByCity(String city){
       return showRepository.findByTheatre_City(city);
   }


}
