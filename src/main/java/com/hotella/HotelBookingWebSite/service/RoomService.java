package com.hotella.HotelBookingWebSite.service;

import com.hotella.HotelBookingWebSite.dto.BookingDTO;
import com.hotella.HotelBookingWebSite.dto.RoomTypeDTO;
import com.hotella.HotelBookingWebSite.dto.Status;
import com.hotella.HotelBookingWebSite.entity.Booking;
import com.hotella.HotelBookingWebSite.entity.Room;
import com.hotella.HotelBookingWebSite.entity.RoomType;
import com.hotella.HotelBookingWebSite.repository.BookingRepository;
import com.hotella.HotelBookingWebSite.repository.RoomRepository;
import com.hotella.HotelBookingWebSite.repository.RoomTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Service
public class RoomService {

    @Autowired
     RoomRepository roomRepository;

    @Autowired
    RoomTypeRepository roomTypeRepository;

    @Autowired
    UserService userService;

    @Autowired
    BookingRepository bookingRepository;

    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    public Optional<Room> getRoomById(Long id) {
        return roomRepository.findById(id);
    }

    public Room saveRoom(Room room) {
        return roomRepository.save(room);
    }

    public RoomType addRoomType(RoomTypeDTO roomTypeDTO){

        RoomType roomType = new RoomType();

        try {
            byte[] encodeBase64 = Base64.getEncoder().encode(roomTypeDTO.getPhoto().getBytes());

            roomType.setName(roomTypeDTO.getName());
            roomType.setDescription(roomTypeDTO.getDescription());
            roomType.setRoomCount(roomTypeDTO.getRoomCount());
            roomType.setMaxGuestCount(roomTypeDTO.getMaxGuestCount());
            roomType.setPhoto(encodeBase64);
            roomType.setDailyRent(roomType.getDailyRent());
        } catch (Exception ex) {

            throw new RuntimeException("Error while adding room type");
        }
        return roomTypeRepository.save(roomType);
    }

    public List<RoomTypeDTO> getAllAvailableRoomTypes(){
        
        List<RoomType> roomTypes = roomTypeRepository.findAll();
        List<RoomTypeDTO> roomTypeDTOS = new ArrayList<RoomTypeDTO>();

        roomTypes.forEach( roomType -> {
            roomTypeDTOS.add(roomType.getDTO());
        } );

        return roomTypeDTOS;
    }

    public Room deleteRoom(Long roomId) {
        Optional<Room> roomOptional = roomRepository.findById(roomId);

        if (roomOptional.isPresent()) {
            roomOptional.get().setIsDeleted(true);
            return roomRepository.save(roomOptional.get());
        } else {
            throw new RuntimeException("Room not found");
        }
    }

    public RoomType getRoomTypeById(Long roomId) {
        Optional<RoomType> roomTypeOptional = roomTypeRepository.findById(roomId);
        if (roomTypeOptional.isPresent())
            return roomTypeOptional.get();

        throw new RuntimeException("Room type not found");
    }

    public Booking saveBooking(BookingDTO bookingDTO, Principal user) {
        Booking booking = new Booking();

        booking.setUser(userService.findUserByEmail(user.getName()));

        Set<RoomType> roomTypeSet = new HashSet<>();
        RoomType roomType = getRoomTypeById(bookingDTO.getRoomId());
        roomTypeSet.add(roomType);
        booking.setRoomType(roomTypeSet);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        formatter = formatter.withLocale( Locale.ENGLISH );  // Locale specifies human language for translating, and cultural norms for lowercase/uppercase and abbreviations and such. Example: Locale.US or Locale.CANADA_FRENCH

        LocalDate checkInDate = LocalDate.parse(bookingDTO.getCheckIn(), formatter);
        booking.setCheckInDate(checkInDate);

        LocalDate checkOutDate = LocalDate.parse(bookingDTO.getCheckOut(), formatter);
        booking.setCheckOutDate(checkOutDate);

        LocalDate bookingDate = LocalDate.now();
        booking.setBookingDate(bookingDate);
        booking.setTotalPrice(bookingDTO.getRoomCount() * roomType.getDailyRent());

        booking.setStatus(Status.INITIATED.name());
        return bookingRepository.save(booking);
    }
}
