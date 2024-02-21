package com.hotella.HotelBookingWebSite.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Room {
     /*   @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String type; // Normal, Deluxe, Luxury

        private double price;

        // Getters and setters  */
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;

        private String name;
        private String description;
        private String roomType;
        private double costPerDay;

}




