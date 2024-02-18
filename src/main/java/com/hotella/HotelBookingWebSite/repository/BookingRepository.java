package com.hotella.HotelBookingWebSite.repository;

import com.hotella.HotelBookingWebSite.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}
