package com.hotella.HotelBookingWebSite.entity;

import com.hotella.HotelBookingWebSite.dto.ProfileBookingDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
        private int guestCount;
        private double totalPrice;
        private String status;
        private boolean isCancelled;
        private LocalDate bookingDate;
        private double paidAmount;
        // Getters and setters


        public ProfileBookingDTO getDTO(){

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

                ProfileBookingDTO profileBookingDTO = ProfileBookingDTO.builder()
                        .bookingDate(bookingDate.format(formatter))
                        .checkInDate(checkInDate.format(formatter))
                        .checkOutDate(checkOutDate.format(formatter))
                        .roomType(roomType.stream().findFirst().get().getName())
                        .guests(guestCount)
                        .totalPrice(totalPrice)
                        .paidAmount(paidAmount)
                        .build();

                return profileBookingDTO;
        }
    }

