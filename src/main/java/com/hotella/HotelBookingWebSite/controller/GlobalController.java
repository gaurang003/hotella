package com.hotella.HotelBookingWebSite.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
public class GlobalController {

    @ModelAttribute("servletPath")
    String getRequestServletPath(HttpServletRequest request) {
        return request.getServletPath();
    }

    @ModelAttribute("isAdmin")
    Boolean isAdmin(HttpServletRequest request) {

        return request.isUserInRole("ROLE_ADMIN");
    }
}
