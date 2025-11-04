package com.nukhbahire.platform.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // TODO: 11/4/2025 : logger should not be for prod environment, keep it for dev environment.
    private static final Logger _log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ErrorResponseDTO> handleBusinessException(BusinessException exception, HttpServletRequest request) {

        _log.error("Unhandled exception: {}", exception.getMessage(), exception);

        ErrorResponseDTO errorResponseDTO = new ErrorResponseDTO(
                HttpStatus.BAD_REQUEST.value(),
                exception.getErrorCode(),
                exception.getMessage(),
                request.getRequestURI()
        );
        return new ResponseEntity<>(errorResponseDTO, HttpStatus.BAD_REQUEST);
    }

    // Handle JSON parse / malformed body errors
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorResponseDTO> handleJsonParseException(HttpMessageNotReadableException ex, HttpServletRequest request) {

        _log.error("Unhandled exception: {}", ex.getMessage(), ex);

        ErrorResponseDTO errorResponseDTO = new ErrorResponseDTO(
                HttpStatus.BAD_REQUEST.value(),
                "JSON_PARSE_ERROR",
                ex.getMessage(),
                request.getRequestURI()
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponseDTO);
    }

    // Handle NullPointerException specifically
    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<ErrorResponseDTO> handleNullPointerException(NullPointerException ex, HttpServletRequest request) {
        _log.error("Unhandled exception: {}", ex.getMessage(), ex);

        String message = "A required value was missing during request processing. Please contact support if the problem persists.";

        ErrorResponseDTO error = new ErrorResponseDTO(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                "NULL_POINTER_ERROR",
                ex.getMessage() != null ? ex.getMessage() : message,
                request.getRequestURI()
        );
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // Fallback: handle everything else
    @ExceptionHandler(Throwable.class)
    public ResponseEntity<ErrorResponseDTO> handleAll(Throwable ex, HttpServletRequest request) {

        _log.error("Unhandled exception: {}", ex.getMessage(), ex);

        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        ErrorResponseDTO errorResponseDTO = new ErrorResponseDTO(
                status.value(),
                "INTERNAL_SERVER_ERROR",
                ex.getMessage() != null ? ex.getMessage() : "Unexpected error occurred",
                request.getRequestURI()
        );
        return ResponseEntity.status(status).body(errorResponseDTO);
    }
}
