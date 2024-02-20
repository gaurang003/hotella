package com.hotella.HotelBookingWebSite.repository;

import com.hotella.HotelBookingWebSite.entity.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodRepository extends JpaRepository<Food, Integer> {
}
