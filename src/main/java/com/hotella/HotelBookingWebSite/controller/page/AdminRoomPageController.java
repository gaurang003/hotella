package com.hotella.HotelBookingWebSite.controller.page;

import com.hotella.HotelBookingWebSite.dto.RoomTypeDTO;
import com.hotella.HotelBookingWebSite.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin-room")
public class AdminRoomPageController {

    public static final String PAGE = "admin-room";

    public static final String ADD_ROOM_TYPE = "/type";

    @Autowired
    RoomService roomService;

    @GetMapping
    public String getAdminRoomPage(Model model) {

        model.addAttribute("isRoomAdded", false);
        model.addAttribute("roomTypes", roomService.getAllAvailableRoomTypes() );
        return PAGE;
    }

    @PostMapping()
    public String addRoomType(@ModelAttribute RoomTypeDTO roomType, Model model) {

        roomService.addRoomType(roomType);
        model.addAttribute("isRoomAdded", true);
        model.addAttribute("roomTypes", roomService.getAllAvailableRoomTypes() );
        return PAGE;
    }
}
