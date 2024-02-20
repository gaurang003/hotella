package com.hotella.HotelBookingWebSite.service;

import com.hotella.HotelBookingWebSite.entity.Food;
import com.hotella.HotelBookingWebSite.entity.FoodCategory;
import com.hotella.HotelBookingWebSite.repository.FoodCategoryRepository;
import com.hotella.HotelBookingWebSite.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodService {

    @Autowired
    FoodRepository foodRepository;

    @Autowired
    FoodCategoryRepository foodCategoryRepository;

    public Food saveFood(Food food){
        return foodRepository.save(food);
    }

    public List<FoodCategory> getAllFoodCategory() {
        return foodCategoryRepository.findAll();
    }

    public List<Food> getAllFood() {
        return foodRepository.findAll();
    }
}
