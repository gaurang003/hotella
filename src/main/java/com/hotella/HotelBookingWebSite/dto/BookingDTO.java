package com.hotella.HotelBookingWebSite.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookingDTO {

    Integer guests;
    String checkIn;
    String checkOut;
    Long roomId;
    int roomCount;
}
