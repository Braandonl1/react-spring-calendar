package com.example.calender_api.exception;

import com.example.calender_api.dto.ErrorResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/*
 * Global felhantering för applikationen.
 * Samlar vanliga exceptions och returnerar en enhetlig felrespons till klienten.
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    /*
     * Hanterar valideringsfel från @Valid och returnerar HTTP 400.
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleException(
            MethodArgumentNotValidException ex) {

        FieldError error = ex.getBindingResult().getFieldError();

        String message;

        if (error != null) {
            message = error.getDefaultMessage();
        } else {
            message = "Validation failed.";
        }

        ErrorResponse errorResponse =
                new ErrorResponse(400, message);

        return ResponseEntity
                .badRequest()
                .body(errorResponse);
    }

    /*
     * Hanterar fall där ett event inte kan hittas.
     * Returnerar HTTP 404.
     */
    @ExceptionHandler(EventNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleEventNotFoundException(
            EventNotFoundException ex) {

        ErrorResponse errorResponse =
                new ErrorResponse(404, ex.getMessage());

        return ResponseEntity
                .status(404)
                .body(errorResponse);
    }
}