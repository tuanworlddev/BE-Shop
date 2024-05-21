package com.dacs.beshop.exceptions.handler;

import com.dacs.beshop.dto.response.ResponseDto;
import com.dacs.beshop.exceptions.AlreadyExistsException;
import com.dacs.beshop.exceptions.InvalidException;
import com.dacs.beshop.exceptions.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ResponseDto> handleUserNotFoundException(NotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseDto(HttpStatus.NOT_FOUND.value(), e.getMessage()));
    }

    @ExceptionHandler(AlreadyExistsException.class)
    public ResponseEntity<ResponseDto> handleUserAlreadyExistsException(AlreadyExistsException e) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(new ResponseDto(HttpStatus.CONFLICT.value(), e.getMessage()));
    }

    @ExceptionHandler(InvalidException.class)
    public ResponseEntity<ResponseDto> handleUserInvalidException(InvalidException e) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ResponseDto(HttpStatus.UNAUTHORIZED.value(), e.getMessage()));
    }
}
