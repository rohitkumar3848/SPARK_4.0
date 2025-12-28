package com.bookmyshow.bookmyshow.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

// Entity map this class with DB table basically it create table of show name using JPA with these attribute as a cloumn with validation
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "shows")
public class Show {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //Its means many shows and 1 movie where movie_id is foreign key here
    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;

    @ManyToOne
    @JoinColumn(name = "theatre_id")
    private Theatre  theatre;

    private LocalDateTime time;
}
