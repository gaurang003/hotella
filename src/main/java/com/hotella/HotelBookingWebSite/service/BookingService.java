package com.hotella.HotelBookingWebSite.service;

import com.hotella.HotelBookingWebSite.dto.ProfileBookingDTO;
import com.hotella.HotelBookingWebSite.dto.RoomTypeDTO;
import com.hotella.HotelBookingWebSite.entity.Booking;
import com.hotella.HotelBookingWebSite.entity.RoomType;
import com.hotella.HotelBookingWebSite.repository.BookingRepository;
import com.hotella.HotelBookingWebSite.repository.RoomTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookingService {
    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private RoomTypeRepository roomTypeRepository;

    @Autowired
    private UserService userService;

    public Booking saveBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    public List<Booking> getAllBooking() {
        return bookingRepository.findAll();
    }

    // room types - already booked rooms
    // 10 - 8 =2
    public List<RoomTypeDTO> getAllAvailableRooms(LocalDate checkInDate, LocalDate checkOutDate){
        List<RoomType> roomTypes  = roomTypeRepository.findAll();
//        List<Booking> bookings = bookingRepository.findAllByCheckInDateBetweenAndCheckOutDateBetween(checkInDate.toString(), checkOutDate.toString());
        return null;
    }

    public List<ProfileBookingDTO> getAllBookingsByUserId(Long userId){

        List<Booking> bookings = bookingRepository.findAllByUserId(userId);

        List<ProfileBookingDTO> bookingDTOS = new ArrayList<ProfileBookingDTO>();
        bookings.forEach(booking -> {
            bookingDTOS.add(booking.getDTO());
        });
        return bookingDTOS;
    }
}
