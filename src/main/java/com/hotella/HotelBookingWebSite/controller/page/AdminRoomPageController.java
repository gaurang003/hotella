package com.hotella.HotelBookingWebSite.controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin-room")
public class AdminRoomPageController {

    public static final String PAGE = "admin-room";

    public static final String ADD_ROOM_TYPE = "/type";

    @GetMapping
    public String getAdminRoomPage(Model model) {
        return PAGE;
    }

    @PostMapping(ADD_ROOM_TYPE)
    public String addRoomType(Model model) {
        return PAGE;
    }
}
