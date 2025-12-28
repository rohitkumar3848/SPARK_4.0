package com.bookmyshow.bookmyshow.service;

import com.bookmyshow.bookmyshow.entity.Booking;

import java.util.List;

public interface BookingService {

    Booking bookShow(Booking booking);

    List<Booking> getBookingByUser(Long userId);
}
