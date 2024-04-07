package com.sergio.crud.backend.yuwei.config.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class YuWeiExceptionHandler {
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> customizeName(RuntimeException exception){
        return ResponseEntity.status(HttpStatus.OK)
                .body("This is RuntimeException: "+exception.getMessage() );
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> customizeName(IllegalArgumentException exception){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body("This is IllegalArgumentException: "+exception.getMessage() );
    }
}
