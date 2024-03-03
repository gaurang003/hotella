package com.hotella.HotelBookingWebSite.controller.page;

import com.hotella.HotelBookingWebSite.entity.Feedback;
import com.hotella.HotelBookingWebSite.security.CustomUserDetailsService;
import com.hotella.HotelBookingWebSite.service.FeedbackService;
import com.hotella.HotelBookingWebSite.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PageController {

    @Autowired
    FeedbackService feedbackService;

    @Autowired
    FoodService foodService;

    @Autowired
    CustomUserDetailsService customUserDetailsService;


    @GetMapping("/feedback")
    public String getFeedbackPage(Model model) {
        model.addAttribute("name", "Gaurang");
        model.addAttribute("comment", "comment");
        return "feedback";
    }

    @GetMapping("/canteen")
    public String getCanteenPage(Model model) {

        model.addAttribute("foodCategoryList", foodService.getAllFoodCategory());
        model.addAttribute("foods", foodService.getAllFood());
        return "canteen";
    }


    @GetMapping("/profile")
    public String getProfilePage(Model model) {
        model.addAttribute("user", customUserDetailsService.getCurrentUser());
        return "profile";
    }


    @GetMapping("/admin")
    public String getAdminPage(Model model) {

        model.addAttribute("foods", foodService.getAllFood());
        return "admin";
    }


    @PostMapping(value = "/feedback-output")
    public String saveFeedback(@ModelAttribute("feedback") Feedback feedback){
        feedbackService.saveFeedback(feedback);
        return "feedback-output";
    }
    @GetMapping("/rating")
    public String getRatingPage(Model model) {
        return "rating";
    }

    @GetMapping("/payment-receipt")
    public String getPaymentReceiptPage(Model model) {
        return "payment-receipt";
    }



}
