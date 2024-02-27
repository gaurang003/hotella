package com.hotella.HotelBookingWebSite.controller.page;

import com.hotella.HotelBookingWebSite.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin-canteen")
public class AdminCanteenPageController {

    public static final String PAGE = "admin-canteen";

    public static final String FOOD = "/food";

    @Autowired
    FoodService foodService;

    @GetMapping
    public String getAdminCanteenPage(Model model) {

        model.addAttribute("foodCategories", foodService.getAllFoodCategory());
        model.addAttribute("foods", foodService.getAllFood());
        return PAGE;
    }

}
