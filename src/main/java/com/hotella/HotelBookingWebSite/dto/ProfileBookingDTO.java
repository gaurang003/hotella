package com.hotella.HotelBookingWebSite.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProfileBookingDTO {
    private String roomType;
    private Integer guests;
    private String checkInDate;
    private String checkOutDate;
    private String bookingDate;
    private int roomCount;
    private double totalPrice;
    private double paidAmount;
}
