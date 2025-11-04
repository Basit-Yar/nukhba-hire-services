package com.nukhbahire.platform.exception;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ErrorResponseDTO {

    private LocalDateTime timeStamp;
    private int status;
    private String error;
    private String message;
    private String path;

    public ErrorResponseDTO(int status, String error, String message, String path) {
        timeStamp = LocalDateTime.now();
        this.status = status;
        this.error = error;
        this.message = message;
        this.path = path;
    }

    public ErrorResponseDTO() {
        timeStamp = LocalDateTime.now();
    }

}
