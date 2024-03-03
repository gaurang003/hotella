package com.hotella.HotelBookingWebSite.repository;

import com.hotella.HotelBookingWebSite.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

    @Query(value = "select * from booking", nativeQuery = true)
    public List<Booking> findAllByCheckInDateBetweenAndCheckOutDateBetween(String checkInDate, String checkOutDate);
}
