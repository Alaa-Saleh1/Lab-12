package com.example.blog_lab12.Controlleradvice;


import com.example.blog_lab12.ApiResponse.ApiException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class Controlleradvice {


    @ExceptionHandler(value = ApiException.class)
    public ResponseEntity ApiException(ApiException exaption){
        String message= exaption.getMessage();
        return ResponseEntity.status(400).body(message);
    }
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity MethodArgumentNotValidException(MethodArgumentNotValidException exception){
        String message = exception.getMessage();
        return ResponseEntity.status(400).body(message);
    }
}