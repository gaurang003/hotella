package com.hotella.HotelBookingWebSite.service;

import com.hotella.HotelBookingWebSite.entity.Booking;
import com.hotella.HotelBookingWebSite.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {
    @Autowired
    private BookingRepository bookingRepository;

    public Booking saveBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    public List<Booking> getAllBooking() {
        return bookingRepository.findAll();
    }
}
