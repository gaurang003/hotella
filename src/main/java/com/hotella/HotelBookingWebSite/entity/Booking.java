package com.hotella.HotelBookingWebSite.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Setter
@Getter
public class Booking {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @ManyToOne
        private Room room;

        private RoomType roomType;
        private User  guests;
        private LocalDate checkInDate;
        private LocalDate checkOutDate;
        private double totalPrice;
        private String status;

        // Getters and setters
    }

