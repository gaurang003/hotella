package com.hotella.HotelBookingWebSite.dto;

import com.hotella.HotelBookingWebSite.entity.FoodCategory;
import jakarta.annotation.Nonnull;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FoodDTO {
    Integer id;

    @NotNull(message = "name can not be null")
    @NotBlank(message = "name can not be blank")
    String name;
    @NotNull(message = "description can not be null")
    @NotBlank(message = "description can not be blank")
    String description;
    @NotNull(message = "price can not be null")
    Double price;
    @NotNull(message = "Category not selected")
    Integer categoryId;

}
