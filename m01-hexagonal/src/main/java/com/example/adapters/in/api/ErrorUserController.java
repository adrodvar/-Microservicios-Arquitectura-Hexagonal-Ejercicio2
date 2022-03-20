package com.example.adapters.in.api;


import com.example.config.domain.exceptions.ErrorResponse;
import com.example.config.domain.exceptions.UserDontExistException;
import com.example.config.domain.exceptions.UserExistException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class ErrorUserController {

    @ExceptionHandler({UserDontExistException.class})
    public ResponseEntity<ErrorResponse> handleUserDontExistException(UserDontExistException exception) {

        return new ResponseEntity(new ErrorResponse(exception.getMessage(), HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.getReasonPhrase()),
                HttpStatus.NOT_FOUND);
    }



    @ExceptionHandler({UserExistException.class})
    public ResponseEntity<ErrorResponse> handleUserExistException(UserExistException exception) {

        return new ResponseEntity(new ErrorResponse(exception.getMessage(), HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase()),
                HttpStatus.BAD_REQUEST);
    }
}
