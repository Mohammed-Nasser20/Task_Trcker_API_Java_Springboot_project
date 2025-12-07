package com.canMe.task_list.controller;

import com.canMe.task_list.dto.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorResponse> handleException(
            IllegalArgumentException ex, WebRequest request
    ) {
            var response = new ErrorResponse(
                    ex.getMessage(),
                    HttpStatus.BAD_REQUEST.value(),
                    LocalDateTime.now(),
                    request.getDescription(false)
            );
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);

    }
}
