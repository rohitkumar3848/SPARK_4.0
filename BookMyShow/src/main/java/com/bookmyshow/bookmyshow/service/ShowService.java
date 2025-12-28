package com.bookmyshow.bookmyshow.service;

import com.bookmyshow.bookmyshow.entity.Show;

import java.util.List;

public interface ShowService {

    Show addShow(Show show);
    List<Show> getShowsByCity(String city);

}
