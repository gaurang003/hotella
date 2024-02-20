package com.hotella.HotelBookingWebSite.repository;

import com.hotella.HotelBookingWebSite.entity.FoodCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodCategoryRepository extends JpaRepository<FoodCategory, Integer> {
}
