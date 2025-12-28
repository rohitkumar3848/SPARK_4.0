package com.bookmyshow.bookmyshow.service;

import com.bookmyshow.bookmyshow.entity.Theatre;

import java.util.List;


public interface TheatreService {

    Theatre addTheatre(Theatre theatre);
    List<Theatre> getAllTheatre();

}
