package com.hotella.HotelBookingWebSite.repository;

import com.hotella.HotelBookingWebSite.entity.RoomType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomTypeRepository extends JpaRepository<RoomType,Long> {
}
