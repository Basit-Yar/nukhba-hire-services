package com.nukhbahire.platform.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ErrorResponseDTO> handleBusinessException(BusinessException exception, HttpServletRequest request) {
        ErrorResponseDTO errorResponseDTO = new ErrorResponseDTO(
                HttpStatus.BAD_REQUEST.value(),
                exception.getErrorCode(),
                exception.getMessage(),
                request.getRequestURI()
        );
        return new ResponseEntity<>(errorResponseDTO, HttpStatus.BAD_REQUEST);
    }
}
