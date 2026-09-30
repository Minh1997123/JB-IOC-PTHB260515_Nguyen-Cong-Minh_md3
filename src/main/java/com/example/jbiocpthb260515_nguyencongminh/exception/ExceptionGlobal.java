package com.example.jbiocpthb260515_nguyencongminh.exception;


import com.example.jbiocpthb260515_nguyencongminh.DTO.response.APIResponse;
import jakarta.validation.UnexpectedTypeException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionGlobal {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<APIResponse<?>> handleException(Exception e) {
        APIResponse<?> apiResponse = new APIResponse<>(false , e.getMessage(), null , 400);
        return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiResponse);
    }
    @ExceptionHandler(UnexpectedTypeException.class)
    public ResponseEntity<APIResponse<?>> handleException(UnexpectedTypeException e) {
        APIResponse<?> apiResponse = new APIResponse<>(false , e.getMessage(), null , 400);
        return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiResponse);
    }
}
