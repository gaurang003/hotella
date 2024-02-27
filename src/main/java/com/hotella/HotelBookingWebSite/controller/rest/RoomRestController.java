package com.hotella.HotelBookingWebSite.controller.rest;

import com.hotella.HotelBookingWebSite.entity.Room;
import com.hotella.HotelBookingWebSite.entity.RoomType;
import com.hotella.HotelBookingWebSite.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("rest/")
@CrossOrigin("*")
public class RoomRestController {

    @Autowired
    RoomService roomService;

    @PostMapping("admin/roomType")
    public RoomType addRooms(@RequestBody RoomType roomType){

        return roomService.addRoomType(roomType);
    }
}
