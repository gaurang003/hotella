package com.hotella.HotelBookingWebSite.exception;

import com.hotella.HotelBookingWebSite.exception.custom.InvalidFoodCategory;
import jakarta.validation.ValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({ValidationException.class})
    public ResponseEntity<Object> handleStudentNotFoundException(ValidationException exception) {
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(exception.getMessage());
    }


    @ExceptionHandler({InvalidFoodCategory.class})
    public ResponseEntity<Object> handleStudentNotFoundException(InvalidFoodCategory exception) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(exception.getMessage());
    }


}
