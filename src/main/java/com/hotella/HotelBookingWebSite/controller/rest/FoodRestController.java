package com.hotella.HotelBookingWebSite.controller.rest;

import com.hotella.HotelBookingWebSite.entity.Food;
import com.hotella.HotelBookingWebSite.entity.FoodCategory;
import com.hotella.HotelBookingWebSite.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("admin/food")
public class FoodRestController {

    @Autowired
    FoodService foodService;

    @PostMapping()
    public Food saveFood(@RequestBody Food food) {
        return foodService.saveFood(food);
    }

    @GetMapping("/category")
    public List<FoodCategory> getAllFoodCategories(){
        return foodService.getAllFoodCategory();
    }

}
