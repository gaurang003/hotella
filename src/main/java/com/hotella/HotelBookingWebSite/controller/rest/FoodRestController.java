package com.hotella.HotelBookingWebSite.controller.rest;

import com.hotella.HotelBookingWebSite.dto.FoodDTO;
import com.hotella.HotelBookingWebSite.entity.Food;
import com.hotella.HotelBookingWebSite.entity.FoodCategory;
import com.hotella.HotelBookingWebSite.service.FoodService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("rest/")
public class FoodRestController {

    @Autowired
    FoodService foodService;

    @GetMapping("food")
    public List<Food> getAllFoods(){
        return foodService.getAllFood();
    }

    @PostMapping("admin/food")
    public Food saveFood(@Valid @RequestBody FoodDTO foodDTO) {
        return foodService.saveFood(foodDTO);
    }

    @GetMapping("/category")
    public List<FoodCategory> getAllFoodCategories(){
        return foodService.getAllFoodCategory();
    }

}
