package com.hotella.HotelBookingWebSite.repository;

import com.hotella.HotelBookingWebSite.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User,Long>{
     User findByEmail(String email);


}

