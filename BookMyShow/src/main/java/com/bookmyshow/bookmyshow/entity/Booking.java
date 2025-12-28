package com.bookmyshow.bookmyshow.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.Min;

@Entity
@NoArgsConstructor
@Data
@AllArgsConstructor
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // One user → many bookings
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    // One show → many bookings
    @ManyToOne
    @JoinColumn(name = "show_id")
    private Show show;

    @Min(1)
    private int seats;

    private String status; // CONFIRMED OR CANCELLED
}
