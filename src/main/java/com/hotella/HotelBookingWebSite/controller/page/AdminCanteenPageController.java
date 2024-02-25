package com.hotella.HotelBookingWebSite.controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin-canteen")
public class AdminCanteenPageController {

    public static final String PAGE = "admin-canteen";

    public static final String ADD_ROOM_TYPE = "/type";

    @GetMapping
    public String getAdminRoomPage(Model model) {
        return PAGE;
    }
}
