package com.bookmyshow.bookmyshow.repository;

import com.bookmyshow.bookmyshow.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}
