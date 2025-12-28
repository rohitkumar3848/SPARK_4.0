package com.bookmyshow.bookmyshow.controller;

import com.bookmyshow.bookmyshow.entity.Theatre;
import com.bookmyshow.bookmyshow.repository.TheatreRepository;
import com.bookmyshow.bookmyshow.service.TheatreServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/theatres")
public class TheatreController {

    private final TheatreServiceImpl theatreService;

    public TheatreController(TheatreServiceImpl theatreService) {
        this.theatreService = theatreService;
    }

    @PostMapping
    public Theatre addTheatre(@RequestBody Theatre theatre) {
        return  theatreService.addTheatre(theatre);
    }

    @GetMapping
    public List<Theatre> getAllTheatre() {
        return theatreService.getAllTheatre();
    }

}
