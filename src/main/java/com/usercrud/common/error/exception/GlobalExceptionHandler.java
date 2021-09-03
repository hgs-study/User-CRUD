package com.usercrud.common.error.exception;

import com.usercrud.common.error.response.ErrorResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RequiredArgsConstructor
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ErrorResponse> businessException(BusinessException e){
        ErrorResponse errorResponse = ErrorResponse.of(e.getErrorCode());
        errorResponse.setMessage(errorResponse.getMessage());
        errorResponse.setCode(errorResponse.getCode());

        return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.valueOf(errorResponse.getStatus()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> methodArgumentNotValidException(MethodArgumentNotValidException e){
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setMessage(e.getBindingResult().getFieldError().getDefaultMessage());
        errorResponse.setStatus(400);
        errorResponse.setCode("");

        return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}
