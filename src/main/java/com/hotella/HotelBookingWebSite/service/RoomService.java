package com.hotella.HotelBookingWebSite.service;

import com.hotella.HotelBookingWebSite.dto.RoomTypeDTO;
import com.hotella.HotelBookingWebSite.entity.Room;
import com.hotella.HotelBookingWebSite.entity.RoomType;
import com.hotella.HotelBookingWebSite.repository.RoomRepository;
import com.hotella.HotelBookingWebSite.repository.RoomTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

@Service
public class RoomService {
    @Autowired
     RoomRepository roomRepository;

    @Autowired
    RoomTypeRepository roomTypeRepository;

    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    public Optional<Room> getRoomById(Long id) {
        return roomRepository.findById(id);
    }

    public Room saveRoom(Room room) {
        return roomRepository.save(room);
    }

    public RoomType addRoomType(RoomType roomType){
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
}
