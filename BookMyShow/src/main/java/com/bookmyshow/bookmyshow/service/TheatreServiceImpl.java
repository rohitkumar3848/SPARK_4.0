package com.bookmyshow.bookmyshow.service;

import com.bookmyshow.bookmyshow.entity.Theatre;
import com.bookmyshow.bookmyshow.repository.TheatreRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TheatreServiceImpl implements TheatreService {

    private final TheatreRepository  theatreRepository;

    public TheatreServiceImpl(TheatreRepository theatreRepository) {
        this.theatreRepository = theatreRepository;
    }

    @Override
    public Theatre addTheatre(Theatre theatre) {
        return theatreRepository.save(theatre);
    }

    @Override
    public List<Theatre> getAllTheatre() {
        return theatreRepository.findAll();
    }
}
