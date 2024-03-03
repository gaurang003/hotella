package com.hotella.HotelBookingWebSite.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Setter
@Getter
public class Booking {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @ManyToMany(fetch = FetchType.EAGER, cascade=CascadeType.DETACH)
        @JoinTable(
                name="room_booking_mapping",
                joinColumns={@JoinColumn(name="BOOKING_ID", referencedColumnName="ID")},
                inverseJoinColumns={@JoinColumn(name="ROOM_TYPE_ID", referencedColumnName="ID")})
        private Set<RoomType> roomType;

        @ManyToOne
        @JoinColumn(name = "user", nullable = false)
        private User user;

        private LocalDate checkInDate;
        private LocalDate checkOutDate;
        private double totalPrice;
        private String status;
        private boolean isCancelled;
        private LocalDate bookingDate;
        private Double paidAmount;
        // Getters and setters
    }

