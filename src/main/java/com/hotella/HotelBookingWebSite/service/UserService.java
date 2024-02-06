package com.hotella.HotelBookingWebSite.service;

import com.hotella.HotelBookingWebSite.dto.UserDto;
import com.hotella.HotelBookingWebSite.entity.User;

import java.util.List;

public interface UserService {
    void saveUser(UserDto userDto);

    User findUserByEmail(String email);

    List<UserDto> findAllUsers();
}
