package com.courseapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@ControllerAdvice
public class ApiExceptionHandler {

    //handling specific exception
    @ExceptionHandler(value = {ResourceNotFoundException.class})
    public ResponseEntity<Object> handleResourceNotFoundException(ResourceNotFoundException e) {
        //Create payload containing exception details
        //Return response entity

        HttpStatus badRequest = HttpStatus.NOT_FOUND;
        ErrorDetails errorDetails = new ErrorDetails(
                e.getMessage(),
                badRequest,
                ZonedDateTime.now(ZoneId.of("Z"))
        );
        return new ResponseEntity<>(errorDetails, badRequest);
    }

    //handle global exception
    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<Object> handleGlobalException(Exception e) {
        //Create payload containing exception details
        //Return response entity

        HttpStatus badRequest = HttpStatus.BAD_REQUEST;
        ErrorDetails errorDetails = new ErrorDetails(
                e.getMessage(),
                badRequest,
                ZonedDateTime.now(ZoneId.of("Z"))
        );
        return new ResponseEntity<>(errorDetails, badRequest);
    }

}
