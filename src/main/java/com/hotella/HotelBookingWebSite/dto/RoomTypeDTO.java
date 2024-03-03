package com.hotella.HotelBookingWebSite.dto;

import jakarta.persistence.Lob;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RoomTypeDTO {

    private Long id;
    private String name;
    private String description;
    private String photo;
    private Integer roomCount;
    private Integer maxGuestCount;
    private double dailyRent;
}
