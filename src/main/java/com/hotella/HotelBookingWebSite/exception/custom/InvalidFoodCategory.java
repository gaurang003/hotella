package com.hotella.HotelBookingWebSite.exception.custom;

public class InvalidFoodCategory extends RuntimeException{
    public InvalidFoodCategory() {
        super("Invalid food category");
    }
}
