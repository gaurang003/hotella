package com.hotella.HotelBookingWebSite.controller.page;

import com.hotella.HotelBookingWebSite.dto.BookingSummary;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class PageController {

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
        return "canteen";
    }

    @GetMapping("/profile")
    public String getProfilePage(Model model) {
        return "profile";
    }


    @GetMapping(value = "/room-booking-summary")
    public String getRookBookingSummaryPage( @RequestParam String roomType,
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
}
