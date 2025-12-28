package com.bookmyshow.bookmyshow.repository;

// Show entity import → jis table pe query chalani hai
import com.bookmyshow.bookmyshow.entity.Show;

// JpaRepository import → CRUD + custom queries ke liye
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

// Repository interface → Show table ke saath database interaction
public interface ShowRepository extends JpaRepository<Show,Long> {

    // Nested (Property Traversal) Query
    // findByTheatre_City →
    // Show → Theatre (FK relationship) → City field
    //
    // Meaning:
    // Jo shows un theatres me chal rahe hain
    // jinka city = given city
    //
    // Spring Data JPA method name ko tod kar query banata hai:
    // Show.theatre.city = ?
    //
    // SQL equivalent:
    // SELECT s.*
    // FROM show s--
    // JOIN theatre t ON s.theatre_id = t.id
    // WHERE t.city = ?

    List<Show> findByTheatre_City(String city);


}
