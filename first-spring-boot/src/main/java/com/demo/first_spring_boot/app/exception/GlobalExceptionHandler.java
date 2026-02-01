package com.demo.first_spring_boot.app.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    //    Exception handle method
    @ExceptionHandler(UserNotFound.class)
    public ResponseEntity<Map<String,Object>> handleIllegalArgumentException(Exception exception){
        Map<String,Object> errorResponse = new HashMap<>();
        errorResponse.put("Status:- ", HttpStatus.BAD_REQUEST.value());
        errorResponse.put("Message:- ",exception.getMessage());
        return new ResponseEntity<>(errorResponse,HttpStatus.BAD_REQUEST);
    }
}
