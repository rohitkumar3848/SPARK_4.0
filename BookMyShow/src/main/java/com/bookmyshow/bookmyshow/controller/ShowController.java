package com.bookmyshow.bookmyshow.controller;

import com.bookmyshow.bookmyshow.entity.Show;
import com.bookmyshow.bookmyshow.service.ShowService;
import com.bookmyshow.bookmyshow.service.ShowServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/shows")
public class ShowController {

    private ShowServiceImpl showService;

    public ShowController(ShowServiceImpl showService) {
        this.showService = showService;
    }

    @PostMapping
    public Show addShow(@RequestBody Show show) {
        return showService.addShow(show);
    }

    @GetMapping("/city/{city}")
    public List<Show> getShowsByCity(@PathVariable String city) {
        return showService.getShowsByCity(city);
    }

}
