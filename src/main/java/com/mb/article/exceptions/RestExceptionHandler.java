package com.mb.article.exceptions;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.persistence.EntityNotFoundException;
import java.util.HashMap;
import java.util.Map;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Deprecated
// @Order(Ordered.HIGHEST_PRECEDENCE)
// @ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler  {


    @ExceptionHandler({ EntityNotFoundException.class })
    public ResponseEntity<Object> handleEntityNotFound(
            EntityNotFoundException e) {
        return new ResponseEntity<>(new ApiError(false, e.getMessage()), new HttpHeaders(), HttpStatus.NOT_FOUND);
    }

    /*@ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleValidationExceptions(
            Exception ex) {
        if (ex instanceof MethodArgumentNotValidException) {
            Map<String, String> errors = new HashMap<>();
            MethodArgumentNotValidException e = (MethodArgumentNotValidException) ex;
            e.getBindingResult().getAllErrors().forEach((error) -> {
                String fieldName = ((FieldError) error).getField();
                String errorMessage = error.getDefaultMessage();
                errors.put(fieldName, errorMessage);
            });
            return new ResponseEntity<>(new ApiValidationError(false, e.getMessage(), errors), new HttpHeaders(), HttpStatus.UNPROCESSABLE_ENTITY);
        } else if (ex instanceof ConstraintViolationException) {
            return new ResponseEntity<>(new ApiError(false, ex.getMessage()), new HttpHeaders(), HttpStatus.BAD_REQUEST);
        }
        ex.printStackTrace();
        return new ResponseEntity<>(new ApiError(false, ex.getMessage()), new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }*/

    /*@ExceptionHandler({ RepositoryConstraintViolationException.class })
    public ResponseEntity<Object> handleValidationExceptions(
            Exception ex, WebRequest request) {
        RepositoryConstraintViolationException nevEx =
                (RepositoryConstraintViolationException) ex;

        String errors = nevEx.getErrors().getAllErrors().stream()
                .map(p -> p.toString()).collect(Collectors.joining("\n"));

        return new ResponseEntity<Object>(errors, new HttpHeaders(),
                HttpStatus.UNPROCESSABLE_ENTITY);
    }*/
}
