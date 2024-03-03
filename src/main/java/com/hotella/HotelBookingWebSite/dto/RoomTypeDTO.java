package com.hotella.HotelBookingWebSite.dto;

import lombok.Builder;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
@Builder
public class RoomTypeDTO {

    private Long id;
    private String name;
    private String description;
    private MultipartFile photo;
    private String photoString;
    private Integer roomCount;
    private Integer maxGuestCount;
    private double dailyRent;
}
