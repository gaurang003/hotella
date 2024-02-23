package com.hotella.HotelBookingWebSite.controller.page;

import com.hotella.HotelBookingWebSite.dto.BookingSummary;
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
import org.springframework.web.bind.annotation.RequestParam;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class PageController {

    @Autowired
    FeedbackService feedbackService;

    @Autowired
    FoodService foodService;

    @Autowired
    CustomUserDetailsService customUserDetailsService;


    @GetMapping("/room-booking")
    public String getRoomBookingPage(Model model) {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date currentDate= new Date();
        String minDate=sdf.format(currentDate);

        model.addAttribute("minDate", minDate);
        model.addAttribute("maxDate", "2024-02-24");
        return "room-booking";
    }

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

    @GetMapping(value = "/room-booking-summary")
    public String getRookBookingSummaryPage(
            @RequestParam String roomType,
            @RequestParam Integer guests,
            @RequestParam String checkIn,
            @RequestParam String checkOut,
            Model model) {

        model.addAttribute( "roomType", roomType);
        model.addAttribute("guests", guests);
        model.addAttribute("checkIn", checkIn);
        model.addAttribute("checkOut", checkOut);
        return "room-booking-summary";
    }

    @PostMapping(value = "/room-booking-summary")
    public String getRookBookingSummaryPage( @ModelAttribute BookingSummary bookingSummary,
            Model model) {

        model.addAttribute( "roomType", bookingSummary.getRoomType());
        model.addAttribute("guests", bookingSummary.getGuests());
        model.addAttribute("checkIn", bookingSummary.getCheckIn());
        model.addAttribute("checkOut", bookingSummary.getCheckOut());
        return "room-booking-summary";
    }

    @PostMapping(value = "/feedback-output")
    public String saveFeedback(@ModelAttribute("feedback") Feedback feedback){
        feedbackService.saveFeedback(feedback);
        return "feedback-output";
    }



}
