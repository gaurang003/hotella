package com.hotella.HotelBookingWebSite.repository;

import com.hotella.HotelBookingWebSite.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;



public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);


}
