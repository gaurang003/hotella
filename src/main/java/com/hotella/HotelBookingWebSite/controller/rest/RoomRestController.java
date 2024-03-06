package com.hotella.HotelBookingWebSite.controller.rest;

import com.hotella.HotelBookingWebSite.dto.RoomTypeDTO;
import com.hotella.HotelBookingWebSite.entity.RoomType;
import com.hotella.HotelBookingWebSite.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("rest/")
@CrossOrigin("*")
public class RoomRestController {

    @Autowired
    RoomService roomService;

    // Not in use
    @PostMapping("admin/roomType")
    public RoomType addRooms(@RequestBody RoomTypeDTO roomType){

        return roomService.addRoomType(roomType);
    }
}
