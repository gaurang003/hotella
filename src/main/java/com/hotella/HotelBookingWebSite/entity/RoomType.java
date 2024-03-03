package com.hotella.HotelBookingWebSite.entity;

import com.hotella.HotelBookingWebSite.dto.RoomTypeDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

@Entity
@Getter
@Setter
public class RoomType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    @Lob
    private byte[] photo;

    @Min(1)
    @Max(100)
    private Integer roomCount;
    @Min(1)
    @Max(30)
    private Integer maxGuestCount;
    private double dailyRent;

    private transient RoomTypeDTO roomTypeDTO;
    public RoomTypeDTO getDTO(){

        String base64Encoded ="";

        try {

            byte[] encodeBase64 = Base64.getEncoder().encode(this.photo);
            base64Encoded = new String(encodeBase64, "UTF-8");

        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }

        if (roomTypeDTO == null) {
            roomTypeDTO = RoomTypeDTO.builder().id(this.id)
                    .name(this.name)
                    .description(this.description)
                    .photo(base64Encoded)
                    .roomCount(this.roomCount)
                    .maxGuestCount(this.maxGuestCount)
                    .dailyRent(this.dailyRent)
                    .build();
        }

        return roomTypeDTO;
    }
}
