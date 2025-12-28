package com.bookmyshow.bookmyshow.repository;

import com.bookmyshow.bookmyshow.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

// Repository interface → database interaction ke liye
public interface UserRepository extends JpaRepository<User, Long> {

    // Custom query method
    // findByEmail → Spring method name se query auto-generate karega
    // Email exist ho sakta hai ya nahi → isliye Optional<User>, optional save us from null pointer exception
    Optional<User> findByEmail(String email);
}
