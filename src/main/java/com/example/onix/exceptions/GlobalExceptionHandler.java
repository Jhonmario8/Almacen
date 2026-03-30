package com.example.onix.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(InvalidCredentialsException.class)
    public ResponseEntity<?> handlerInvalidCredentialsException(InvalidCredentialsException ex){
        logger.error("Error: {}", ex.getMessage());
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ErrorResponse(ex.getMessage(),401));
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> handlerUserNotFoundException(NotFoundException ex) {
        logger.error("Error: {}", ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse(ex.getMessage(), 404));
    }

    @ExceptionHandler(ConflictException.class)
    public ResponseEntity<?> handlerEmailAlreadyExistsException(ConflictException ex){
        logger.error("Error: {}", ex.getMessage());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(new ErrorResponse(ex.getMessage(),409));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleValidationErrors(MethodArgumentNotValidException ex){
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error ->
                errors.put(error.getField(),
                        error.getDefaultMessage()));
        Map<String, Object> response = new HashMap<>();
        response.put("message","Datos invalidos");
        response.put("errors",errors);
        response.put("status",400);

        return ResponseEntity.badRequest().body(response);
    }

}
