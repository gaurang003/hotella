package com.hotella.HotelBookingWebSite.service;

import com.hotella.HotelBookingWebSite.entity.Room;
import com.hotella.HotelBookingWebSite.entity.RoomType;
import com.hotella.HotelBookingWebSite.repository.RoomRepository;
import com.hotella.HotelBookingWebSite.repository.RoomTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public List<RoomType> getAllAvailableRoomTypes(){
        return roomTypeRepository.findAll();
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
