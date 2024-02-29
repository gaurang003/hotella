package com.hotella.HotelBookingWebSite.controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin-bookings")
public class AdminBookingPageController {

    public static final String PAGE = "admin-booking";

    @GetMapping
    public String getAdminRoomPage(Model model) {
        return PAGE;
    }
}
