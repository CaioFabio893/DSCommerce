package com.caiofabio.dscommerce.controllers.handlers;

import com.caiofabio.dscommerce.dto.CustomError;
import com.caiofabio.dscommerce.dto.ValidationError;
import com.caiofabio.dscommerce.services.exceptions.DatabaseException;
import com.caiofabio.dscommerce.services.exceptions.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

// para ajustar o erro do json
@ControllerAdvice
public class ControllerExceptionHandler {

    //error not found 404
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<CustomError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        // a ordem depende do de como o construtor do customerror foi feita
        CustomError err = new CustomError(
                e.getMessage(),
                request.getRequestURL().toString(),
                status.value(),
                Instant.now());
        return ResponseEntity.status(status).body(err);
    }


    // erro no delete databease error  400
    @ExceptionHandler(DatabaseException.class)
    public ResponseEntity<CustomError> database(DatabaseException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        CustomError err = new CustomError(
                e.getMessage(),
                request.getRequestURL().toString(),
                status.value(),
                Instant.now());
        return ResponseEntity.status(status).body(err);
    }

    // verificação metodos post e put , 422
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<CustomError> methodArgumentNotValidation(MethodArgumentNotValidException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.UNPROCESSABLE_ENTITY;
        // validation error criada pra editar mensagens de error
        ValidationError err = new ValidationError (
                "Dados invalidos",
                request.getRequestURL().toString(),
                status.value(),
                Instant.now());
        // editando as mensagens para as validaçoes que fizemos no dto
        for(FieldError f : e.getBindingResult().getFieldErrors()) {
            err.addError(f.getField(), f.getDefaultMessage());
        }

        return ResponseEntity.status(status).body(err);
    }

}
