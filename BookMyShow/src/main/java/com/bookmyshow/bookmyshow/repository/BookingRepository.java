package com.bookmyshow.bookmyshow.repository;


import com.bookmyshow.bookmyshow.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

// Repository interface → Booking table ke saath database interaction
public interface BookingRepository extends JpaRepository<Booking,Long> {

    // Nested (Foreign Key) Query
    // findByUser_Id →
    // Booking → User (FK relation) → id field
    //
    // Meaning:
    // Kisi particular user ki saari bookings lao
    //
    // Spring Data JPA method name se query banata hai:
    // Booking.user.id = ?
    //
    // SQL equivalent:
    // SELECT b.*
    // FROM booking b
    // WHERE b.user_id = ?
    List<Booking> findByUser_Id(Long userId);
}
