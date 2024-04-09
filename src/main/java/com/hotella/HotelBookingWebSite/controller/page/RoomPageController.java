package com.hotella.HotelBookingWebSite.controller.page;

import com.hotella.HotelBookingWebSite.dto.BookingDTO;
import com.hotella.HotelBookingWebSite.entity.Booking;
import com.hotella.HotelBookingWebSite.entity.RoomType;
import com.hotella.HotelBookingWebSite.service.BookingService;
import com.hotella.HotelBookingWebSite.service.RoomService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import java.io.IOException;
import java.security.Principal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

@Controller
public class RoomPageController {

    @Autowired
    RoomService roomService;

    @Autowired
    BookingService bookingService;

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
    public String showBookingSummary(@ModelAttribute BookingDTO bookingDTO, Model model, Principal user) throws ParseException {

        RoomType roomType = roomService.getRoomTypeById(bookingDTO.getRoomId());
        int requiredRooms = (int) Math.ceil((float) bookingDTO.getGuests() /roomType.getMaxGuestCount());

        long numberOfDays = calculateNumberOfDays(bookingDTO.getCheckIn(), bookingDTO.getCheckOut());

        double totalAmount = requiredRooms * roomType.getDailyRent() * numberOfDays;

        model.addAttribute("guests",  bookingDTO.getGuests());
        model.addAttribute("checkIn",  bookingDTO.getCheckIn());
        model.addAttribute("checkOut",  bookingDTO.getCheckOut());
        model.addAttribute("room", roomType);
        model.addAttribute("roomId", roomType.getId());
        model.addAttribute("roomName", roomType.getName());
        model.addAttribute("roomCount",  requiredRooms);
        model.addAttribute("totalAmount", totalAmount );
        return "room-booking-summary";
    }

    private long calculateNumberOfDays(String checkIn, String checkOut) throws ParseException{
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date checkInDate = simpleDateFormat.parse(checkIn);
        Date checkOutDate = simpleDateFormat.parse(checkOut);
        long diffInMillis = Math.abs(checkOutDate.getTime()- checkInDate.getTime());
        return TimeUnit.DAYS.convert(diffInMillis, TimeUnit.MILLISECONDS) + 1;
    }

    @GetMapping("/proceed-payment")
    public RedirectView proceedToPayment(@ModelAttribute BookingDTO bookingDTO, Principal user, HttpServletRequest request, HttpServletResponse response) throws IOException, ParseException {

        RoomType roomType = roomService.getRoomTypeById(bookingDTO.getRoomId());
        int requiredRooms = (int) Math.ceil((float) bookingDTO.getGuests() /roomType.getMaxGuestCount());
        long numberOfDays = calculateNumberOfDays(bookingDTO.getCheckIn(), bookingDTO.getCheckOut()) ;
        double totalAmount = requiredRooms * roomType.getDailyRent() * numberOfDays;
        roomService.saveBooking(bookingDTO, user);

        String razorpayLing = "https://pages.razorpay.com/pl_NhrzF6tsnuItBO/view?amount=" + totalAmount;
        return new RedirectView(razorpayLing);
    }

    @GetMapping("/payment-receipt")
    public String getPaymentReceiptPage(@RequestParam Long bookingId, Model model) {

        Booking booking = bookingService.findById(bookingId);
        Optional<RoomType> roomTypeOptional = Optional.of(booking.getRoomType().stream().findFirst().get());
        RoomType roomType = roomTypeOptional.get();

        model.addAttribute("userFullName", booking.getUser().getName());
        model.addAttribute("emailId", booking.getUser().getEmail());
        model.addAttribute("bookingDate", booking.getBookingDate());
        model.addAttribute("invoiceNumber", booking.getId());
        model.addAttribute("roomTypeName", roomType.getName());
        model.addAttribute("guestCount", booking.getGuestCount());
        model.addAttribute("roomCount", 2);
        model.addAttribute("dailyRent", roomType.getDailyRent());
        model.addAttribute("totalAmount", booking.getTotalPrice());
        return "payment-receipt";
    }

}
