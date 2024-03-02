package com.hotella.HotelBookingWebSite.controller.rest;

import com.hotella.HotelBookingWebSite.entity.Booking;
import com.hotella.HotelBookingWebSite.service.BookingService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/room-booking")
public class BookingRestController {

    @Autowired
    BookingService bookingService;

    @GetMapping("/room-booking-summary")
    public List<Booking> getAllBooking(){
        return bookingService.getAllBooking();
    }

    @PostMapping("admin/admin-booking")
    public Booking saveBooking(@Valid  @RequestBody Booking booking) {
        return bookingService.saveBooking(booking);
    }

}
