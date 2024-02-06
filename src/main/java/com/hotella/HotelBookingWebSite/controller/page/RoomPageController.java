package com.hotella.HotelBookingWebSite.controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class RoomPageController {
    @GetMapping("/room")
    public String room(){
        return "room";
    }
}
