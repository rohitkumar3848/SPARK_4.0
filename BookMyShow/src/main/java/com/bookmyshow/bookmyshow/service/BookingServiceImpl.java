package com.bookmyshow.bookmyshow.service;

import com.bookmyshow.bookmyshow.entity.Booking;
import com.bookmyshow.bookmyshow.entity.Show;
import com.bookmyshow.bookmyshow.entity.User;
import com.bookmyshow.bookmyshow.exception.ResourceNotFoundException;
import com.bookmyshow.bookmyshow.repository.BookingRepository;
import com.bookmyshow.bookmyshow.repository.MovieRepository;
import com.bookmyshow.bookmyshow.repository.ShowRepository;
import com.bookmyshow.bookmyshow.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;
    private final UserRepository userRepository;
    private final ShowRepository showRepository;

    public BookingServiceImpl(BookingRepository bookingRepository,
                              UserRepository userRepository,
                              ShowRepository showRepository) {
        this.bookingRepository = bookingRepository;
        this.userRepository = userRepository;
        this.showRepository = showRepository;
    }

    @Override
    public Booking bookShow(Booking booking) {
        Long userId = booking.getUser().getId();
        Long showId = booking.getShow().getId();


        User user = userRepository.findById(userId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("User not found with id: " + userId));

        Show show = showRepository.findById(showId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Show not found with id: " + showId));
        booking.setUser(user);
        booking.setShow(show);

        booking.setStatus("CONFIRMED");
        return bookingRepository.save(booking);
    }

    @Override
    public List<Booking> getBookingByUser(Long userId) {
        return bookingRepository.findByUser_Id(userId);
    }

    public Booking getBookingById(Long id) {
        return bookingRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Booking not found with id: " + id));
    }

}
