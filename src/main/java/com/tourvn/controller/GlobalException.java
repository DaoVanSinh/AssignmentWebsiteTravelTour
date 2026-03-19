package com.tourvn.controller;

import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

@RestControllerAdvice
public class GlobalException {
        @ExceptionHandler(IllegalArgumentException.class)
            public ResponseEntity<String> handleBadRequest(Exception ex){
                return ResponseEntity.badRequest().body(ex.getMessage());
            }   
        }
