package com.hotella.HotelBookingWebSite.service;

import com.hotella.HotelBookingWebSite.dto.FoodDTO;
import com.hotella.HotelBookingWebSite.entity.Food;
import com.hotella.HotelBookingWebSite.entity.FoodCategory;
import com.hotella.HotelBookingWebSite.exception.custom.InvalidFoodCategory;
import com.hotella.HotelBookingWebSite.repository.FoodCategoryRepository;
import com.hotella.HotelBookingWebSite.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FoodService {

    @Autowired
    private FoodRepository foodRepository;

    @Autowired
    private FoodCategoryRepository foodCategoryRepository;

    public Food saveFood(FoodDTO foodDTO){

        Optional<FoodCategory> foodCategoryOptional = foodCategoryRepository.findById(foodDTO.getCategoryId());

        if (foodCategoryOptional.isPresent()){
            Food food = new Food();
            food.setName(foodDTO.getName());
            food.setDescription(foodDTO.getDescription());
            food.setFoodCategory(foodCategoryOptional.get());
            food.setPrice(foodDTO.getPrice());
            return foodRepository.save(food);
        } else {
            throw new InvalidFoodCategory();
        }
    }

    public FoodCategory saveFoodCategory(FoodCategory foodCategory) {
        return foodCategoryRepository.save(foodCategory);
    }

    public List<FoodCategory> getAllFoodCategory() {
        return foodCategoryRepository.findAll();
    }

    public List<Food> getAllFood() {
        return foodRepository.findAll();
    }
}
