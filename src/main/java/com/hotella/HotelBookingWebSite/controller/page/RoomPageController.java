package com.hotella.HotelBookingWebSite.controller.page;

import com.hotella.HotelBookingWebSite.dto.BookingDTO;
import com.hotella.HotelBookingWebSite.entity.RoomType;
import com.hotella.HotelBookingWebSite.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class RoomPageController {

    @Autowired
    RoomService roomService;

    @GetMapping("/room-booking")
    public String getRoomBookingPage(Model model) {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date currentDate= new Date();
        String minDate=sdf.format(currentDate);

        model.addAttribute("minDate", minDate);
        model.addAttribute("maxDate", "2024-06-24");
        return "room-booking";
    }

    @GetMapping("/room-availability")
    public String showAvailableRooms(@ModelAttribute BookingDTO bookingDTO, Model model) {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date currentDate= new Date();
        String minDate=sdf.format(currentDate);

        model.addAttribute("minDate", minDate);
        model.addAttribute("maxDate", "2024-06-24");
        model.addAttribute("guests",  bookingDTO.getGuests());
        model.addAttribute("checkIn",  bookingDTO.getCheckIn());
        model.addAttribute("checkOut",  bookingDTO.getCheckOut());
        model.addAttribute("roomTypes", roomService.getAllAvailableRoomTypes());
        return "room-availability";
    }

    @GetMapping("/room-booking-summary")
    public String showBookingSummary(@ModelAttribute BookingDTO bookingDTO, Model model, Principal user) {

        RoomType roomType = roomService.getRoomTypeById(bookingDTO.getRoomId());
        int requiredRooms = (int) Math.ceil((float) bookingDTO.getGuests() /roomType.getMaxGuestCount());

        model.addAttribute("guests",  bookingDTO.getGuests());
        model.addAttribute("checkIn",  bookingDTO.getCheckIn());
        model.addAttribute("checkOut",  bookingDTO.getCheckOut());
        model.addAttribute("room", roomType);
        model.addAttribute("roomCount",  requiredRooms);
        model.addAttribute("totalAmount",  requiredRooms * roomType.getDailyRent());
        return "room-booking-summary";
    }

}
