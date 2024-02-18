package com.hotella.HotelBookingWebSite.repository;

import com.hotella.HotelBookingWebSite.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Long> {
}
