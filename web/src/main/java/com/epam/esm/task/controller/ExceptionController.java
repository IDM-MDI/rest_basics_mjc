//package com.epam.esm.task.controller;
//
//import com.epam.esm.task.exception.ExceptionCode;
//import com.epam.esm.task.exception.ServiceException;
//import com.fasterxml.jackson.core.JsonProcessingException;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.HttpRequestMethodNotSupportedException;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.RestControllerAdvice;
//import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
//import org.springframework.web.servlet.NoHandlerFoundException;
//
//import static com.epam.esm.task.exception.ExceptionCode.NOT_FOUND_EXCEPTION;
//import static org.springframework.http.HttpStatus.*;
//import static org.springframework.http.HttpStatus.BAD_REQUEST;
//
//@RestControllerAdvice
//public class ExceptionController {
//    @ExceptionHandler(ServiceException.class)
//    public final ResponseEntity<Object> handleDaoExceptions(ServiceException exception) {
//        return new ResponseEntity<>(NOT_FOUND_EXCEPTION,NOT_FOUND);
//    }
//
//    @ExceptionHandler(ServiceException.class)
//    public final ResponseEntity<Object> handleIncorrectParameterExceptions(ServiceException exception) {
//        return new ResponseEntity<>(exception.getMessage(), BAD_REQUEST);
//    }
//
//    @ExceptionHandler({MethodArgumentTypeMismatchException.class, JsonProcessingException.class})
//    public final ResponseEntity<Object> handleBadRequestExceptions() {
//        return new ResponseEntity<>(ExceptionCode.BAD_REQUEST, BAD_REQUEST);
//    }
//
//    @ExceptionHandler(NoHandlerFoundException.class)
//    public final ResponseEntity<Object> handleBadRequestException() {
//        return new ResponseEntity<>(NOT_FOUND_EXCEPTION, NOT_FOUND);
//    }
//
//    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
//    public final ResponseEntity<Object> methodNotAllowedExceptionException() {
//        return new ResponseEntity<>(ExceptionCode.METHOD_NOT_ALLOWED, METHOD_NOT_ALLOWED);
//    }
//}
