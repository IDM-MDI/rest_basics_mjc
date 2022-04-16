package com.epam.esm.task.controller;

import com.epam.esm.task.exception.ExceptionCode;
import com.epam.esm.task.exception.ServiceException;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.validation.ConstraintViolationException;

import static com.epam.esm.task.exception.ExceptionCode.*;
import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestControllerAdvice
@Profile("prod")
public class ExceptionController {

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(BAD_REQUEST)
    public ResponseEntity<String> handleConstraintViolationException(ConstraintViolationException e) {
        return new ResponseEntity<>(BAD_PATH_ID.toString(), BAD_REQUEST);
    }

    @ExceptionHandler(ServiceException.class)
    public final ResponseEntity<Object> handleDaoExceptions(ServiceException exception) {
        return new ResponseEntity<>(exception.getMessage(),HttpStatus.SERVICE_UNAVAILABLE);
    }

    @ExceptionHandler({MethodArgumentTypeMismatchException.class, JsonProcessingException.class})
    public final ResponseEntity<String> handleBadRequestExceptions() {
        return new ResponseEntity<>(ExceptionCode.BAD_REQUEST.toString(), BAD_REQUEST);
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public final ResponseEntity<String> handleBadRequestException() {
        return new ResponseEntity<>(ExceptionCode.NOT_FOUND_EXCEPTION.toString(), NOT_FOUND);
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public final ResponseEntity<String> methodNotAllowedExceptionException() {
        return new ResponseEntity<>(METHOD_NOT_ALLOWED.toString(), HttpStatus.METHOD_NOT_ALLOWED);
    }
    @ExceptionHandler(HttpMediaTypeException.class)
    public final ResponseEntity<String> handleBadMediaTypeException() {
        return new ResponseEntity<>(BAD_MEDIA_TYPE.toString(), HttpStatus.UNSUPPORTED_MEDIA_TYPE);
    }

//    @ResponseStatus(BAD_REQUEST)
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public Map<String, String> handleValidationExceptions(
//            MethodArgumentNotValidException ex) {
//        Map<String, String> errors = new HashMap<>();
//        ex.getBindingResult().getAllErrors().forEach((error) -> {
//            String fieldName = ((FieldError) error).getField();
//            String errorMessage = error.getDefaultMessage();
//            errors.put(fieldName, errorMessage);
//        });
//        return errors;
//    }
}
