package com.caiofabio.dscommerce.controllers.handlers;

import com.caiofabio.dscommerce.dto.CustomError;
import com.caiofabio.dscommerce.services.exceptions.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<CustomError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        // a ordem depende do de como o construtor do customerror foi feita
        CustomError err = new CustomError(
                e.getMessage(),
                request.getRequestURL().toString(),
                status.value(),
                Instant.now()
        );

        return ResponseEntity.status(status).body(err);
    }
}
