package com.bookmyshow.bookmyshow.controller;

import com.bookmyshow.bookmyshow.entity.Booking;
import com.bookmyshow.bookmyshow.entity.Movie;
import com.bookmyshow.bookmyshow.service.BookingService;
import com.bookmyshow.bookmyshow.service.BookingServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user/bookings")
public class BookingController {
    private final BookingServiceImpl bookingService;

    public BookingController(BookingServiceImpl bookingService) {
        this.bookingService = bookingService;
    }

    // BOOK SHOW
    @PostMapping
    public Booking bookShow(@RequestBody Booking booking,
                            HttpServletRequest request) {

        Long userId = (Long) request.getAttribute("userId");
        if (userId == null) {
            throw new RuntimeException("UserId not found in JWT");
        }

        booking.getUser().setId(userId);
        return bookingService.bookShow(booking);
    }

    // GET BOOKINGS BY USER
    @GetMapping("/user/{id}")
    public List<Booking> getBookingsByUser(@PathVariable Long id){
        return bookingService.getBookingByUser(id);
    }

    @GetMapping("/{id}")
    public Booking getBookingById(@PathVariable Long id){
        return bookingService.getBookingById(id);
    }
}
