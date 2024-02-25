package com.hotella.HotelBookingWebSite.controller.page;

import com.hotella.HotelBookingWebSite.dto.BookingSummary;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class RoomPageController {

    @GetMapping("/room-booking")
    public String getRoomBookingPage(Model model) {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date currentDate= new Date();
        String minDate=sdf.format(currentDate);

        model.addAttribute("minDate", minDate);
        model.addAttribute("maxDate", "2024-06-24");
        return "room-booking";
    }
    @PostMapping(value = "/room-booking-summary")
    public String getRookBookingSummaryPage( @ModelAttribute BookingSummary bookingSummary,
                                             Model model) {

        model.addAttribute( "roomType", bookingSummary.getRoomType());
        model.addAttribute("guests", bookingSummary.getGuests());
        model.addAttribute("checkIn", bookingSummary.getCheckIn());
        model.addAttribute("checkOut", bookingSummary.getCheckOut());
        return "room-booking-summary";
    }


}
