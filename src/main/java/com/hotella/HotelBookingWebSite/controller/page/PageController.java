package com.hotella.HotelBookingWebSite.controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/room")
    public String getRoomBookingPage(Model model) {
        return "room";
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
}
