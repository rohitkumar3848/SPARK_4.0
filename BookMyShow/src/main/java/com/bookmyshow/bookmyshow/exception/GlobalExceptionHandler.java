package com.bookmyshow.bookmyshow.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

// @RestControllerAdvice
// → Poore application ke liye GLOBAL exception handler
// → Sabhi controllers ke errors yahin handle honge
@RestControllerAdvice
public class GlobalExceptionHandler {

    // ================================
    // 1️⃣ RESOURCE NOT FOUND EXCEPTION
    // ================================

    // Jab bhi ResourceNotFoundException throw hogi
    // (for example: User not found, Movie not found)
    // toh yeh method call hoga
    @ExceptionHandler(ResourceNotFoundException.class)

    // Client ko HTTP 404 status milega
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String, String> handleNotFound(ResourceNotFoundException ex) {

        // Error response ke liye Map banaya
        Map<String, String> error = new HashMap<>();

        // "error" key me exception ka message bheja
        error.put("error", ex.getMessage());

        // JSON response return hoga
        // Example:
        // {
        //   "error": "User not found with id: 5"
        // }
        return error;
    }

    // ================================
    // 2️⃣ VALIDATION EXCEPTION HANDLER
    // ================================

    // Jab @Valid fail hota hai
    // (e.g. @NotBlank, @Email)
    // Spring automatically MethodArgumentNotValidException throw karta hai
    @ExceptionHandler(MethodArgumentNotValidException.class)

    // Client ko HTTP 400 BAD REQUEST milega
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, String> handleValidation(MethodArgumentNotValidException ex) {

        // Har field ke validation error ko store karne ke liye Map
        Map<String, String> errors = new HashMap<>();

        // BindingResult se saare field errors nikalte hain
        ex.getBindingResult()
                .getFieldErrors()
                .forEach(e ->
                        // Field name → error message
                        // Example:
                        // "email" → "must be a well-formed email address"
                        errors.put(e.getField(), e.getDefaultMessage())
                );

        // Final JSON response:
        // {
        //   "name": "must not be blank",
        //   "email": "must be a well-formed email address"
        // }
        return errors;
    }
}
